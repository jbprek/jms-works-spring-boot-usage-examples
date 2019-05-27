package com.foo.jms.p2p.requestresponse;

import org.springframework.stereotype.Component;
import net.objecthunter.exp4j.*;
/**
 * Evaluate an arithmetic expression, based on  <a href="https://www.objecthunter.net/exp4j/">EXP4J</a>
 */
public class Calculator {

    private Calculator() {
    }

    public static String calculate(String expression) {
        try {
            Expression e = new ExpressionBuilder(expression).build();
            return String.format("%.3f", e.evaluate());
        } catch (ArithmeticException e) {
            return e.getMessage();
        }
    }
}
