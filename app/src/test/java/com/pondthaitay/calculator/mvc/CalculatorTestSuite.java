package com.pondthaitay.calculator.mvc;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CalculatorDivideMetricTest.class,
        CalculatorMultiplyMetricTest.class,
        CalculatorMinusMetricTest.class,
        CalculatorPlusMetricTest.class,
        CalculatorTest.class
})
public class CalculatorTestSuite {
}
