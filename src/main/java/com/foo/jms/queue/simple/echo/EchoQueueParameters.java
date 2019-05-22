package com.foo.jms.queue.simple.echo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="app.echo.queue")
@Data
public class EchoQueueParameters {
    private String name;
}
