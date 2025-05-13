const express = require('express');
const app = express();

//1. 경로 / 
app.get('/', (req, res) => { res.send('Hellow Express'); });

//2. 경로 /api 화면 /api-Get 출력
app.get('/api', (req, res) => {res.send('/api-Get');});

//3. 경로 /api/one 화면 one 출력
app.get('/api/one', (req, res)=> {res.send('ONE');});

//4. 경로 /api/posts
app.get( '/api/posts', (req, res)=>{
  res.json( [
    {id: 1, content: 'one'},
    {id: 2, content: 'two'},
    {id: 3, content: 'three'},
  ]);
});

//5. 경로 /api/posts
app.post( '/api/post', (req, res)=>{
  res.json( [
    {id: 1, content: 'one'},
    {id: 2, content: 'two'}, 
  ]);
});

//6. 경로 /api/posts
app.delete( '/api/post', (req, res)=>{
  res.json( [
    {id: 1, content: 'one'}, 
  ]);
});


app.listen(3065, () => { console.log('서버실행중...'); });