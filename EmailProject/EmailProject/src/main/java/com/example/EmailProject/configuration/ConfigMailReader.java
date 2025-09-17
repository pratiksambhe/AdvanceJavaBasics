package com.example.EmailProject.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "spring.receive.imap")
public class ConfigMailReader {
    private String host;
    private int port;
    private String user;
    private String protocol;
    private Boolean sslEnable;
    private String password;

}
