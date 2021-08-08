//index

// const express = require('express');
// const apicall = require('./vodMsApi');
// const logger = require('./logger');
// const app = express();
// const port = 3030;

// app.get('/customer/:id',(req,res)=>{
//     logger.info("The end-point was called")
    
//     apicall.callApi(req.params.id,function(response){
//         res.send(response);
//     });
// });


// app.listen(port,()=>{
//     logger.info("Starting the server:")
//     console.log(`app listening at http://localhost:${port}`)
// });
const logger = require('./logger');
const apicall = require('./vodMsApi');

const express = require("express");
const index = express.Router();

index.get('/customer/:id',(req,res)=>{
    logger.info("The end-point was called")
    
    apicall.callApi(req.params.id,function(response){
        res.send(response);
    });
});

module.exports = index;