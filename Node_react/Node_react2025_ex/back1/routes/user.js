const express = require('express');
const router = express.Router();
const bcrypt = require('bcrypt');
const passport = require('passport');
const {User} = require('../models');
const { isLoggedIn, isNotLoggedIn } = require('./middlewares');

//회원가입
// post :  localhost:3065/user/
//설정 : content-Type : applocation/json
//설정2 : Body -[Raw] -[Json]
router.post('/', isNotLoggedIn, async (req, res, next)=>{ //res.send('.............회원가입');
  try{
    //1. 이메일 중복확인 sql - select : 객체.findOne
    const user = await User.findOne({where:{email:req.body?.email}});
    //2. 결과확인 - 존재하면 이미 사용중인 아이디입니다.
    if(user){return res.status(403).send('이미 사용중인 아이디입니다.');}
    //3. 비밀번호 암호화
    const hashPassword = await bcrypt.hash(req.body.password, 12); //암호화 강도 10~13
    //4. 사용자 생성 객체.create
    await User.create({
      email:req.body.email,
      nickname:req.body.nickname,
      password:hashPassword,
    });
    //5. 성공응답
    res.status(201).send('회원가입완료!');
  }catch(error){
    console.error(error);
    next(error);
  }
} );


//로그인
router.post('/login',isNotLoggedIn, async(req, res, next)=>{ //res.send('.............로그인');
  passport.authenticate('local', (err, user, info)=>{
    //1. err 오류처리
    if(err){ console.error(err); return next(err); };
    //2. 인증정보있다면 -세션 401 상태코드 (인증필요)
    if(info){ return res.status(401).send(info.reason); };
    //3. 사용자세션에 등록
    return req.login(user, async (loginErr) => {
      //3-1 로그인시 에러발생
      if(loginErr){ console.error(loginErr); return next(loginErr); }
      //3-2 사용자 정보조회 (sql-join)
      const fulluser = await user.findOne( { //sql : select
        where:{ id: user.id },
        attributes: { exclude:['password'] }, //password 제외하고 조회
        include : [ { model:Post, attributes: ['id'] }
                    ,{ model:User, as:'Followings' , attributes: ['id'] }  //사용자가 follow한 id
                    ,{ model:User, as:'Followers' , attributes: ['id'] } ], //사용자를 follow하는 id
      } );
      return res.status(200).json(fulluser);
    } );
  } ); (req, res, next); //passport.authenticate()의 반환값을 즉시실행
});


module.exports = router;

