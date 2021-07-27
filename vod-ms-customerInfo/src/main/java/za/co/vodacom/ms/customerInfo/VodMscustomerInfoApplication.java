package za.co.vodacom.ms.customerInfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import za.co.vodacom.ms.config.EnableVodacomExceptions;
import za.co.vodacom.ms.config.EnableVodacomResourceServer;
import za.co.vodacom.ms.config.EnableVodacomSpring;
import za.co.vodacom.ms.core.auditing.annotations.EnableVodacomAuditable;
import za.co.vodacom.ms.core.logging.annotatations.EnableVodacomLogging;


@SpringBootApplication
@EnableVodacomSpring
@EnableVodacomExceptions
@EnableVodacomLogging
@EnableVodacomResourceServer
@EnableVodacomAuditable
public class VodMscustomerInfoApplication{

    public static void main(String[]args){

        System.setProperty("za.co.vodacom.i18n.locale.language.default","en");
        System.setProperty("za.co.vodacom.i18n.locale.country","ZA");
        SpringApplication.run(VodMscustomerInfoApplication.class,args);
    }

}
