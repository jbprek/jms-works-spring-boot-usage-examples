package com.foo.jms.p2p.simple.echo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="app.echo.queue")
@Data
public class EchoQueueParameters {
    private String name;
}
