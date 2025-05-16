const express = require('express');
const router = express.Router();

const multer = require('multer'); //파일업로드
const path = require('path'); //경로
const fs = require('fs'); // file system

const {Post, User, Image, Comment, Hashtag} = require('../models');
const {isLoggedIn} = require('./middlewares');

//폴더 존재여부 확인
try{
  fs.accessSync('uploads'); // 폴더 존재여부 확인
}catch(error){
  console.log('uploads 폴더가 없으면 생성합니다.');
  fs.mkdirSync('uploads'); // 폴더만들기
}

/////////////////////////////////////////////////

//1. 업로드 설정
const upload = multer({
  storage : multer.diskStorage({ // 저장소 설정 - 업로드된 파일의 저장위치, 파일이름 지정
    //파일을 디스크(로컬파일시스템)에 저장하도록 설정
    destination(req, file, done){ // 지정경로
      done(null, 'uploads'); // 지정경로 지정 - 콜백
      //null 에러없음, uploads 저장될 폴더경로
    },
    filename(req,file,done){ // 업로드된 파일이름 지정
      //images1.png
      const ext = path.extname(file.originalname); //1. 확장자추출 .png
      const basename = path.basename(file.originalname, ext); //2. 이미지이름  images1
      done(null, basename+'_'+new Date().getTime()+ext );//3. images1_날짜지정.png
    },
  }),
  limits : {fileSize:10*1024*1024} //10mb
});

//2. 게시글 생성하고 관련데이터 저장하는 역할
// Post : localhost:3065/post           로그인을 했다면
// {"content" : "새게시글입니다 #노드 #리액트"} 
// upload.none() : form file 업로드 없을 때  upload.none() 에서 처리
router.post('/', isLoggedIn, upload.none(), async(req, res, next)=>{
  //res.send('............post 게시글');
  try{
    //1. 해시태그 추출 
    // https://regex101.com/ - //gm - 전역(g)에서 여러줄(m)로 들어가 있는 모든 라인에서 검색
    // / #[]+ /gm : []안에 있는 거 1개 이상
    // / #[^\s#]+ /gm ^\s:공백빼고 ^\s#:공백,샵빼고  | ^ 부정 \s 공백
    const hashtags = req.body.content.match(/#[^\s#]+/g);
    //2. 게시글 저장
    const post = await Post.create({
      content : req.body.content,
      UserId: req.user.id
    })
    //3. 해시태그 존재하면 해시태그별로 저장
    if(hashtags){
      const result = await Promise.all( // 비동기로 작업 병렬로 실행하고, 작업 완료 시 결과 반환(create 다수일 때 Primise.all 사용)
        hashtags.map((tag)=>
          Hashtag.findOrCreate({ // db상 태그 존재하는지 확인 후 생성
            where:{ name : tag.slice(1).toLowerCase() } //slice(1) 문자열 첫번째 제거 (#node의 #) toLowerCase - 소문자로 저장
          })
        )
      );
      await post.addHashtags(result.map(v=>v[0])) // [node, true], [react, true]
    }
    //4. 이미지처리
    if(req.body.image){
      if(Array.isArray(req.body.image)){//여러개 이미지
        const images = await Promise.all(
          req.body.image.map( (image) => Image.create({src: image})   )
        );
        await post.addImages(images);
      }
    }else{ //1개 이미지
      const image = await Image.create({src:req.body.image});
      await post.addImages(image);
    }
    //5. 게시글 상세정보조회 - 해당유저의 id에 맞는 글 찾기 / join / Image 테이블, Comment, User
    const fullPost = await Post.findOne({
      where : {id:post.id},
      include : [
        { model:Image } // 상단에 where 조건에 포함되어 있기 때문에 attribute :['id'] 명시적으로 추가안해도 자동으로 포함
        ,{ model:  User , as : 'Likers', attributes: ['id']}
        ,{ model: User , attributes:['id', 'nickname'] }
        ,{ model: Comment, include: [{ model:User, attributes: ['id', 'nickname'] }] }
      ]
    });
    res.status(201).json(post);
  }catch(error){console.error; next(error);}
});

// create : 객체.create({})
// select : 객체.findAll , 객체.findOne
// update : 객체.update
// delete : 객체.destory()

//이미지 업로드 - 로그인-이미지업로드 테스트
/* Post localhost:3065/post/images 
Header  : content-type : multipart/form-data
Bodt    :  form-data "image" : 업로드할 파일 선택 test.png
*/
router.post('/images', isLoggedIn, upload.array('image'), (req,res,next)=>{
  console.log(req.files);
 // res.json(req.files.map( (v)=> v.filename ) );
 res.json(  req.files.map(  (v)=> v.filename  ));
});


//3. 글 삭제
// Delete : localhost:3065/post/:postId 로그인을 했다면
router.delete('/:postId', isLoggedIn, async(req, res, next)=>{
  //res.send('............post 게시글 삭제');
  try{
    await Post.destroy({
      where : {
        id : req.params.postId, //삭제하려는 게시글 id
        UserId : req.user.id    //게시글 작성자
      }
    }); // 삭제글 게시글 id와 게시글 작성자가 동일하면 삭제
    res.status(200).json({ PostId : parseInt(req.params.postId, 10) });
  }catch(error){console.error(); next(error); }
});

/////////////////////////////////////////////////

//4. 좋아요 추가 
/* PATCH : localhost:3065/post/1/like
    게시글 존재여부 확인 Post.findOne
    좋아요 추가 post.addLikers
    응답*/
    router.patch('/:postId/like', isLoggedIn, async(req, res, next)=>{
      try{
        const post = await Post.findOne({ where : {id:req.params.postId} })
        if(!post){return res.status(403).send('게시글을 확인해주세요')}
        
    await post.addLikers(req.user.id);
    res.json({ UserId:req.user.id, Post:post.id });
  }catch(error){console.error(error); next(error);}
});

//5. 좋아요 삭제
/* DELETE : localhost:3065/post/1/like
    게시글 존재여부 확인 Post.findOne
    좋아요 추가 post.addLikers
    응답*/
router.delete('/:postId/like',isLoggedIn,async(req, res, next)=>{
  try{
    const post = await Post.findOne({where:{id:req.params.postId}});
    if(!post){return res.status(403).send('게시글을 확인해주세요')};

    await post.removeLikers(req.user.id);
    res.json({ UserId:req.user.id, Post:post.id });
  }catch(error){console.error(error); next(error);}
});

//6. 사용자 댓글
/*POST localhost:3065/post/7/comment
  게시물 존재확인
  댓글생성
  댓글조회
  응답코드*/
router.post('/:postId/comment', isLoggedIn, async(req,res,next)=>{
  try{
    const post = await Post.findOne({where : {id:req.params.postId}});
    if(!post){return res.status(403).send('게시글을 확인해주세요')};

    const comment = await Comment.create({
      content : req.body.content,
      PostId: parseInt(req.params.postId,10),
      UserId: req.user.id
    });
    
    const fullComment = await Comment.findOne({ // 댓글생성확인
      where:{id:comment.id},
      include: [{ model:User, attributes: ['id', 'nickname'] }]
    });

    res.status(201).json(fullComment);
  }catch(error){console.error(error); next(error);}
});

//7. 리트윗



module.exports = router;