module.exports = (sequelize, DataType) => {
  //const
  const Post = sequelize.define( 'Post' , {
    content : { 
      type : DataType.TEXT,
      allowNull : false,
     }
  },{
    charset : 'utf8mb4',
    cpllate : 'utf8mb4_general_ci',
  })

  //관계설정
  Post.associate = (db) => { 
    db.Post.hasMany(db.Comment);  // post.addComments, post.getComments
    db.Post.hasMany(db.Image);     //post.addImage, post.getImage
    db.Post.belongsTo(db.User);
    db.Post.belongsTo(db.Post, { as : 'Retweet'});
    db.Post.belongsToMany(db.HashTag, { through : 'PostHashTag'});
    db.Post.belongsToMany(db.User, { through : 'Like', as:'Likers'});

   };   
   return Post;

};
/*
-게시글은 많은 Image를 갖는다     hasMany
-게시글은 많은 Comment를 갖는다   hasMany

-게시글은 User에 속해있다   belongsTo
※유저는 많은 Post를 가진다 1:다 hasMany
  Post >-----------------------|- User

-게시글은 많은 공유(게시글: Post)를 갖는다 belongsTo

-게시글은 많은 HashTag를 갖는다 belongsToMany (HashTag) 중간테이블 : PostHashTag 
-좋아요는 많은 좋아요를 갖는다 belongsToMany (User) 중간테이블 : Like , as Likes

포스트(게시판)관리 - [ models ] - post.js
id 기본값 
contest text 필수
createAt updateAt --> 자동처리 */