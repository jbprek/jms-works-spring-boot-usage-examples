package com.foo.jms.p2p.requestresponse;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="app.calculator" +
        ".queue")
@Data
public class CalculatorQueueParameters {
    private String name;
}
