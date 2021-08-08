//app.js

const express = require("express");
const app = express();

app.use(express.urlencoded({ extended: false }));

const logger = require('./logger');

const indexRouter = require("./index");
app.use("/",indexRouter);

const port = 3030;

app.listen(port,()=>{
    logger.info("Starting the server:")
    console.log(`app listening at http://localhost:${port}`)
});