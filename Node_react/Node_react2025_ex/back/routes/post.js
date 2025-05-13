const express = require('express');
const { route } = require('./user');
const router = express.Router();

router.get('/post', (req, res)=>{res.send('글쓰기');});

router.get('/post/posts', (req, res)=>{res.send('페이징');});

module.exports = router;