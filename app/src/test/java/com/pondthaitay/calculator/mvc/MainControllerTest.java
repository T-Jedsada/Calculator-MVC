package com.pondthaitay.calculator.mvc;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.spy;

@RunWith(PowerMockRunner.class)
public class MainControllerTest {

    @Mock
    private MainView mockView;

    private MainController mainController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        Calculator calculator = Calculator.getInstance();
        Calculator spyCalculator = spy(calculator);

        mainController = new MainController(mockView, spyCalculator);
    }

    @After
    public void destroy() {
        mainController.destroy();
    }

    @Test
    public void controllerTestPlus() {
        mainController.plus(5, 5);
        verify(mockView, times(1)).setResultCalculate(eq(String.valueOf(10)));
    }

    @Test
    public void controllerTestMinus() {
        mainController.minus(5, 5);
        verify(mockView, times(1)).setResultCalculate(eq(String.valueOf(0)));
    }

    @Test
    public void controllerTestMultiply() {
        mainController.multiply(5, 5);
        verify(mockView, times(1)).setResultCalculate(eq(String.valueOf(25)));
    }

    @Test
    public void controllerTestDivide() {
        mainController.divide(5, 5);
        verify(mockView, times(1)).setResultCalculate(eq(String.valueOf(1)));
    }

    @Test
    public void controllerTestDivideByZero() {
        mainController.divide(5, 0);
        verify(mockView, times(1)).setResultCalculate(eq(new DividedByZeroException().getMessage()));
    }

    @Test
    public void controllerTestClearView() {
        mainController.destroy();
        Assert.assertNull(mainController.getView());
    }
}