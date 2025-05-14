module.exports = ( sequelize, DataTypes ) => {
  // const User
  const User = sequelize.define('User', { // s가 자동으로 붙어 생성
    //id 기본값으로 자동설정
    email : {
      type : DataTypes.STRING(30), //string text booleanm, insteger, float, datetime 
      allowNull : false, //필수
      unique : true, 
    },
    nickname : {
      type : DataTypes.STRING(30),
      allowNull : false, 
      unique : true
    },
    password : {
      type : DataTypes.STRING(200),
      allowNull : false,
      unique :  true,
    },
  }, {
    charset : 'utf8',
    collate : 'utf8_general_ci' //한글저장
  } ); 
  // 관계설정
  User.associate = (db) => { 
    db.User.hasMany(db.Post);
    db.User.hasMany(db.Comment);
    db.User.belongsToMany(db.Post, { through : 'Like', as: 'Liked' });
    db.User.belongsToMany(db.User, { through : 'Follow', as : 'Followers', foreignKey : 'FollowingId' });
    //                                                        user.getFollowers()
    // Follow 테이블에서 팔로우하는 사람 (FollowingId) 기준으로 관계설정 - 팔로우하는 사람 ID
    db.User.belongsToMany(db.User, { through : 'Follow', as : 'Followings', foreignKey : 'FollowerId' });
    //                                                        usesr.getFollowings()
    // Follow 테이블에서 팔로잉하는 사람 (FollowerId) 기준으로 관계설정 - 팔로우받는 사람 ID
   };
   return User;
};

/*
-유저는 많은 post 가진다 (1-다)     hasMany
-유저는 많은 comment 가진다 (1-다)  hasMany

-좋아요 : User 객체와 Post 객체 사이에 다-다 관계 : 
 belongsToMany | 테이블명-like | 별칭 : liked user.getLiked() 특정 유저가 좋아요한 게시글 목록 불러오기
 유저는 많은 글에 대한 좋아요를 남길 수 있고
 글도 많은 유저가 좋아요를 남길 수 있다.
 
-팔로워 : 나를 팔로우하는 사람 | 내가 올린 게시물을 보는 사람
 User 객체에서 User 테이블 사이 다:다 belongsToMany 테이블명-follow 별칭-followers fk:followingId
-팔로잉 : 내가 팔로우하는 사람 | 내가 팔로우한 사람의 게시물을 볼 수 있는 상태
User 객체에서 User 테이블 사이 다:다 belongsToMany 테이블명-follow 별칭-followings fk:followerId

멤버관리 - [ models ] - user.js
id 기본값
email varchar(30) 필수 , unique
nickname varchar(30) 필수 , unique
password varchar(30) 필수 , unique
createAt updateAt -> 자동처리
*/