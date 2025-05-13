//파일분리 test
const express = require('express');
const router = express.Router();

//4. 경로 /api/posts
router.get( '/post', (req, res)=>{
  res.json( [
    {id: 1, content: 'one'},
    {id: 2, content: 'two'},
    {id: 3, content: 'three'},
  ]);
});

//5. 경로 /api/posts
router.post( '/post', (req, res)=>{
  res.json( [
    {id: 1, content: 'one'},
    {id: 2, content: 'two'}, 
  ]);
});

//6. 경로 /api/posts
router.delete( '/post', (req, res)=>{
  res.json( [
    {id: 1, content: 'one'}, 
    {id: 2, content: 'two'}, 
  ]);
});

module.exports = router;