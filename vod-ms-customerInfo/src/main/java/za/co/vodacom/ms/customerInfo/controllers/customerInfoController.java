package za.co.vodacom.ms.customerInfo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.ResponseEntity;
import za.co.vodacom.ms.config.VodMsRestContollerPublic;
import za.co.vodacom.ms.config.metrics.annotations.VodacomRxMetered;
import za.co.vodacom.ms.customerInfo.services.customerInfoService;
import za.co.vodacom.ms.customerInfo.model.customerInfoModel;
import za.co.vodacom.ms.commons.dto.response.Result;
import za.co.vodacom.ms.commons.dto.response.ServiceResult;

import java.util.List;

import static za.co.vodacom.ms.config.constants.VodMsCoreConstants.BASE_PATH_PUBLIC;

@VodMsRestContollerPublic(BASE_PATH_PUBLIC + "/tests")
@Validated
public class customerInfoController{
    @Autowired
    customerInfoService service;

    @RequestMapping(value="/hello",produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @VodacomRxMetered
    public ResponseEntity<Result<customerInfoModel>> sayHello(){
        return ResponseEntity.ok(new ServiceResult<customerInfoModel>().withResult(service.sayHello()));
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/customer/{msisdn}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Object getDetailsByMsisdn(@PathVariable("msisdn") Long msisdn){
        return service.getMsisdnDetails(msisdn);
    }
}