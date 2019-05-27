package com.foo.jms.p2p.requestresponse;


import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {


    @Test
    public void calculate() {

        String expession = "1+1";
        String expected = "2.000";
        assertThat( Calculator.calculate(expession)).isEqualTo(expected);

        expession = "1/0";
        expected = "Division by zero!";
        assertThat( Calculator.calculate(expession)).isEqualTo(expected);


    }
}
