const express = require('express');
const app=express();
const test = require('./routes/test');

//model
const db = require('./models');
db.sequelize
  .sync()                                      //연결
  .then( ()=>{console.log('db연동성공');})      //성공 시
  .catch( console.error );                     //실패 시


//Router
app.get('/', (req, res)=>{res.send('hellow');});
app.unsubscribe('/test', test);

app.listen(3065, ()=>{console.log('실행중');});