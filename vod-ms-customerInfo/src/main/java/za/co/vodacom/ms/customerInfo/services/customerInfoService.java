package za.co.vodacom.ms.customerInfo.services;

import org.springframework.beans.factory.annotation.Autowired;
import za.co.vodacom.ms.config.VodMsBusinessService;
import lombok.extern.slf4j.Slf4j;
import za.co.vodacom.ms.customerInfo.clients.customerClient;
import za.co.vodacom.ms.customerInfo.config.ServiceProperties;
import za.co.vodacom.ms.customerInfo.model.customerInfoModel;

import java.util.List;

@VodMsBusinessService
@Slf4j
public class customerInfoService {

    @Autowired
    ServiceProperties serviceProperties;

    customerClient customerClient;

    public customerInfoService(customerClient customerClient){
        this.customerClient = customerClient;
    }

    public customerInfoModel sayHello() {
        return customerInfoModel.builder().message(serviceProperties.getMessage()).build() ;
    }

    public Object getMsisdnDetails(Long msisdn){
        return customerClient.getDetailsByMsisdn(msisdn);
    }

}
