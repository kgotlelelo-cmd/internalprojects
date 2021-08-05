package za.co.vodacom.ms.customerInfo.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(
        value = "vodacom-ms-customer",
        url = "${service.props.nonProdUrl}")
public interface customerClient {
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/customers/{msisdn}/details"
    )
    public Object getDetailsByMsisdn(@PathVariable("msisdn") String msisdn);
}
