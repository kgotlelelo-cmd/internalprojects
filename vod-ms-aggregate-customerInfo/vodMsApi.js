const request = require('request');
const logger = require('./logger');


_VODACOM_CUSTOMER_URL = 'http://localhost:8082/public-services/tests/customer/';


const vodacomCustomerApiRequest = (id,callback) =>{
    var data;

    request(_VODACOM_CUSTOMER_URL+id,{ json: true },(err,res,body)=>{
        if(err){
            return callback(err);
        }

        try{

            //build the response
            logger.info("Building the response data");
            
            var data ={
                firstname:"You do not have a debit order in place for your Vodacom account",
                lastname: "To set up a debit order, please call 082 135. FREE from a Vodacom number.",
                billingaddress:[]
            }

            let name = body["result"]["bankDetails"]["firstName"];
            let lastName = body["result"]["bankDetails"]["lastName"];
            let address = body["result"]["personalDetails"]["addressList"]["billingAddress"];


            data.firstname = name;
            data.lastname = lastName;
            data.billingaddress = address;

            logger.info("sending existing customer data");
            return callback(data);

        }catch(err){
            logger.info("The customer doesn't have debit order registered")
            return callback(data);
        }
        
        
        });
};


module.exports.callApi = vodacomCustomerApiRequest;