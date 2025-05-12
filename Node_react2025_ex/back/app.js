const express = require('express');
const app = express();
const userRouter = require('./routes/user');
const postRouter = require('./routes/post');

app.use('/user', userRouter);
app.use('/post', postRouter);

app.listen(3065, ()=>{console.log('server...');});