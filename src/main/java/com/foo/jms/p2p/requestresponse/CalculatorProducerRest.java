package com.foo.jms.p2p.requestresponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import javax.jms.*;

import java.time.Instant;
import java.util.stream.IntStream;

@Slf4j
@RestController
@RequestMapping(path = "echo")
public class CalculatorProducerRest {

    private JmsTemplate jmsTemplate;
    private CalculatorQueueParameters calculatorQueueParameters;

    public CalculatorProducerRest(JmsTemplate jmsTemplate, CalculatorQueueParameters calculatorQueueParameters) {
        this.jmsTemplate = jmsTemplate;
        this.calculatorQueueParameters = calculatorQueueParameters;
    }


    @GetMapping(path = "calculate/{expression}", consumes = "text/plain", produces = "text/plain")
    @ResponseStatus(HttpStatus.CREATED)
    public String calculator(@PathVariable("expression") String expression) {
        try {
            TextMessage response = (TextMessage) jmsTemplate.sendAndReceive(calculatorQueueParameters.getName(), session -> session.createTextMessage(expression));
            return response.getText();
        } catch (JMSException e) {
            log.error(e.toString());
            e.printStackTrace();
            return e.toString();
        }
    }

}
