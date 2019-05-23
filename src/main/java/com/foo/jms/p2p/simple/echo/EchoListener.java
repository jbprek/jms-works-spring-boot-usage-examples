package com.foo.jms.p2p.simple.echo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class EchoListener {

    private EchoQueueParameters echoQueueParameters;

    @PostConstruct
    public void init(){
        log.info("Starting Listener for queue :{}", echoQueueParameters.getName());
    }

    public EchoListener(EchoQueueParameters echoQueueParameters) {
        this.echoQueueParameters = echoQueueParameters;
    }

    @JmsListener(destination = "#{echoQueueParameters.name}", concurrency = "10")
    public void processMessage(Message<String> message){
        log.info(message.getPayload());
    }
}
