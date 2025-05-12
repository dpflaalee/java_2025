const express = require('express');
const app = express();
const basicRouter = require('./routes/basic');
const testRouter = require('./routes/test');

//1. 경로 / 
app.get('/', (req, res) => { res.send('Hellow Express'); });

app.use('/api', basicRouter);
app.use('/test', testRouter);

app.listen(3065, () => { console.log('서버실행중...'); });