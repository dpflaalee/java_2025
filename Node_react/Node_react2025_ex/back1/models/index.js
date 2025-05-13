const Sequelize = require('sequelize');

const env = process.env.NODE_ENV || 'development';
const config = require('../config/config')[env];
const db = {} ;  // 객체 생성하여 객체저장공간 만들기

const sequelize = new Sequelize(config.database , config.usrename, config.password, config);
//db, username, password, config 설정정보 이용하여 인스턴스 생성

//1. sequelize - 모델정의
db.User = require('./user')(sequelize, Sequelize); // 모듈연결 sequelize  실행
db.Post = require('./post')(sequelize, Sequelize);
db.Image = require('./image')(sequelize, Sequelize);
db.HashTag = require('./hashtag')(sequelize, Sequelize);
db.Comment = require('./comment')(sequelize, Sequelize);

//2. 모델 관계설정
Object.keys(db).forEach( modelName => {
  if(db[modelName].associate){ // model 안의 modelName associate가 있다면
    db[modelName].associate(db); //associate 실행
  }
});

db.sequelize = sequelize; //인스턴스
db.Sequelize = Sequelize; //라이브러리 db객체에 저장

module.exports = db; // 타 파일에서도 db 사용가능하게