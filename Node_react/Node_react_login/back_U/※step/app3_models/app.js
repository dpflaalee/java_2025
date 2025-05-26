const express = require('express');
const app = express();
const basicRouter = require('./routes/basic');  
const  testRouter = require('./routes/test');   
 

/////////// Models
const db = require('./models');
db.sequelize
  .sync()
  .then(() => { console.log('db.......');  } )
  .catch(  console.error  );

/////////// Router
app.get('/', (req, res) => { res.send('Hello express'); });
app.use('/api'    , basicRouter);  //## 추가2
app.use('/test', testRouter);


app.listen(3065, () => { console.log('server....'); });
