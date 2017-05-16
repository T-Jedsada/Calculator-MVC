package com.pondthaitay.calculator.mvc;

class Calculator {

    private static Calculator instance;

    static Calculator getInstance() {
        if (instance == null)
            instance = new Calculator();
        return instance;
    }

    int plus(int x, int y) {
        return x + y;
    }

    int minus(int x, int y) {
        return x - y;
    }

    int multiply(int x, int y) {
        return x * y;
    }

    int divide(int x, int y) {
        if (y == 0) {
            throw new DividedByZeroException();
        }
        return x / y;
    }
}
