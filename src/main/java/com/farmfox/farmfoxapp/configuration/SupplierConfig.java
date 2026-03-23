package com.farmfox.farmfoxapp.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
@ConfigurationProperties(prefix = "supplier.info")
@Data
public class SupplierConfig {
    private String path;
    private String protocol;
    private String bucketName;

    public String buildPath() {
        return MessageFormat.format(
                path,
                protocol,
                bucketName
        );
    }

}
