package com.foo.jms.queue.simple.echo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.stream.IntStream;

@Slf4j
@RestController
public class EchoProducerRest {

    private JmsTemplate jmsTemplate;
    private EchoQueueParameters echoQueueParameters;

    public EchoProducerRest(JmsTemplate jmsTemplate, EchoQueueParameters echoQueueParameters) {
        this.jmsTemplate = jmsTemplate;
        this.echoQueueParameters = echoQueueParameters;
    }

    @GetMapping(path="echo")
    public String ping() {
        return "Ping at:" + Instant.now();
    }

    @PostMapping(path="echo/single", consumes = "text/plain")
    @ResponseStatus(HttpStatus.CREATED)
    public void sendSingleMessageToEchoQueue(@RequestBody String message) {
        jmsTemplate.send(echoQueueParameters.getName(), session -> session.createTextMessage(message));
    }


    @PostMapping(path = "echo/multi/{numMessages}")
    @ResponseStatus(HttpStatus.CREATED)
    public void sendMultiMessageToEchoQueue(@PathVariable("numMessages") int numMessages) {
        log.info("Multi messages : {}", numMessages);
        IntStream.rangeClosed(1, numMessages)
                .forEach(i -> jmsTemplate.send(echoQueueParameters.getName(), session -> session.createTextMessage("Message " + i)));
    }
}
