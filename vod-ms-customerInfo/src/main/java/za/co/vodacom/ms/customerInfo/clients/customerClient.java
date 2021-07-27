package za.co.vodacom.ms.customerInfo.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(
        value = "vodacom-ms-customer",
        url = "http://vod-ms-swagger-combined.qa.cloud.vodacom.corp/"
)
public interface customerClient {
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/vod-ms-customer/restricted-cluster-only-services/customers/{msisdn}/details"
    )
    public Object getDetailsByMsisdn(@PathVariable("msisdn") Long msisdn);
}
