const index = require("../index");

const request = require("supertest");
const express = require("express");
const app = express();

app.use(express.urlencoded({ extended:false }));
app.use("/",index);

test('testing the controller', done => {
    request(app)
        .get("/customer/27630000455")
        .expect("Content-Type", /json/)
        .expect({
            "firstname": null,
            "lastname": null,
            "billingaddress": [
                {
                    "country": null,
                    "mainBillingAddress": "N",
                    "latitude": null,
                    "longitude": null,
                    "addressID": "",
                    "addressType": null,
                    "addressLine1": "",
                    "addressLine2": "",
                    "addressLine3": null,
                    "addressLine4": null,
                    "city": null,
                    "province": null,
                    "postalCode": "",
                    "deliveryFlag": null,
                    "buildingName": null,
                    "suburb": null,
                    "streetNo": null,
                    "seoid": null,
                    "ebillingAddress": null
                }
            ]
        })
        .expect(200,done)
});