package za.co.vodacom.ms.customerInfo.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import static za.co.vodacom.ms.config.constants.VodMsCoreConstants.SERVICE_CORE_PROPERTIES_PREFIX;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RefreshScope
@ConfigurationProperties(prefix = SERVICE_CORE_PROPERTIES_PREFIX)
@Component
public class ServiceProperties {

    private String applicationName;

    private String message;

    private String customerMessage;

}
