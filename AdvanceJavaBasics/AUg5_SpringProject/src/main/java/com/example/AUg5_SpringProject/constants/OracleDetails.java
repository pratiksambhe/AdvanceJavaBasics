package com.example.AUg5_SpringProject.constants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@ConfigurationProperties("spring.oracle.datasource")
public class OracleDetails {
    private String username;
    private String password;
}
