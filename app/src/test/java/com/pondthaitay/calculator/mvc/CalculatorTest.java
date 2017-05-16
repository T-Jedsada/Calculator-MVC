package com.pondthaitay.calculator.mvc;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CalculatorTest {
    private Calculator calculator = Calculator.getInstance();

    @Test
    public void plus() throws Exception {
        assertThat(calculator.plus(5, 5), is(10));
    }

    @Test
    public void minus() throws Exception {
        assertThat(calculator.minus(5, 5), is(0));
    }

    @Test
    public void multiply() throws Exception {
        assertThat(calculator.multiply(5, 5), is(25));
    }

    @Test
    public void divide() throws Exception {
        assertThat(calculator.divide(5, 5), is(1));
    }
}