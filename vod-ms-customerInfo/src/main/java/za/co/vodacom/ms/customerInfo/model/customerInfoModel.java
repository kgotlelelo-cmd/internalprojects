package za.co.vodacom.ms.customerInfo.model;

import lombok.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class customerInfoModel {

    private String message;

    private String customerMessage;

    private String applicationName;

}
