package com.pondthaitay.calculator.mvc;

import java.lang.ref.WeakReference;

class MainController {

    private Calculator calculator;
    private WeakReference<MainView> view;

    MainController(MainView view, Calculator calculator) {
        this.view = new WeakReference<>(view);
        this.calculator = calculator;
    }

    void plus(int x, int y) {
        if (view != null) {
            view.get().setResultCalculate(String.valueOf(calculator.plus(x, y)));
        }
    }

    void minus(int x, int y) {
        if (view != null) {
            view.get().setResultCalculate(String.valueOf(calculator.minus(x, y)));
        }
    }

    void multiply(int x, int y) {
        if (view != null) {
            view.get().setResultCalculate(String.valueOf(calculator.multiply(x, y)));
        }
    }

    void divide(int x, int y) {
        if (view != null) {
            try {
                view.get().setResultCalculate(String.valueOf(calculator.divide(x, y)));
            } catch (DividedByZeroException e) {
                view.get().setResultCalculate(e.getMessage());
            }
        }
    }

    void destroy() {
        view = null;
    }

    WeakReference<MainView> getView() {
        return view;
    }
}
