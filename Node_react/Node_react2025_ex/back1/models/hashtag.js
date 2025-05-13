module.exports = ( sequelize, DataTypes ) =>{
  const HashTag = sequelize.define ('HashTag', {
    
    name : {
      type : DataTypes.STRING(20),
      allowNull : false,
    },
  }, {
    charset : 'utf8',
    collate : 'utf8_general_ci' //한글저장
  });
  HashTag.associate = (db) =>{
    db.HashTag.belongsToMany(db.Post , {through : 'PostHashTag'} );
  };
  return HashTag;
};
/*
해시태그 관리  - [ models ] - hahshtag.js
id 기본값
name varchar(20) 필수
createAt updateAt
*/