const index = require("./index");

const request = require("supertest");
const express = require("express");
const app = express();

app.use(express.urlencoded({ extended:false }));
app.use("/",index);

test('should work', (done) => {
    request(app)
        .get("/customer/27630189447")
        .expect("Content-Type", /json/)
        .expect(200,done)
})
