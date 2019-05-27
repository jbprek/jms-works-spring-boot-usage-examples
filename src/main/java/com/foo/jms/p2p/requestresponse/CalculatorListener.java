package com.foo.jms.p2p.requestresponse;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.Destination;

@Slf4j
@Service
public class CalculatorListener {

    private CalculatorQueueParameters calculatorQueueParameters;

    JmsTemplate jmsTemplate;

    public CalculatorListener(CalculatorQueueParameters calculatorQueueParameters, JmsTemplate jmsTemplate) {
        this.calculatorQueueParameters = calculatorQueueParameters;
        this.jmsTemplate = jmsTemplate;
    }

    @JmsListener(destination = "#{calculatorQueueParameters.name}", concurrency = "10")
    public void processMessage(Message<String> inputMessage) {
        log.info(inputMessage.getPayload());
        inputMessage.getHeaders().getReplyChannel();
//        String replyTo = inputMessage.getHeaders().get("REPLY_TO", String.class);
//        MessageHeaders headers = inputMessage.getHeaders();
//        Object jmsRreplyTo =  headers.get("jms_replyTo");
//        String expression = inputMessage.getPayload();
        jmsTemplate.send(replyTo, (session -> session.createTextMessage(Calculator.calculate(expression))));

    }
}
