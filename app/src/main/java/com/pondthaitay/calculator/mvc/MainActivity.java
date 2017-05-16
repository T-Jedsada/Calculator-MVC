package com.pondthaitay.calculator.mvc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MainView {

    private AppCompatEditText etNumberOne;
    private AppCompatEditText etNumberTwo;
    private AppCompatTextView tvResult;

    private MainController mainController;
    private String resultCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
        setupInstance();
        if (savedInstanceState == null) {
            initialize();
        }
    }

    private void initialize() {
        // TODO : something first time
    }

    private void bindView() {
        etNumberOne = (AppCompatEditText) findViewById(R.id.et_number_1);
        etNumberTwo = (AppCompatEditText) findViewById(R.id.et_number_2);
        tvResult = (AppCompatTextView) findViewById(R.id.tv_result);
    }

    private void setupInstance() {
        mainController = new MainController(this, Calculator.getInstance());
    }

    private int[] getValueFromEditText() {
        int[] numbers = {0, 0};
        numbers[0] = Integer.parseInt(etNumberOne.getText().toString());
        numbers[1] = Integer.parseInt(etNumberTwo.getText().toString());
        return numbers;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_plus:
                mainController.plus(getValueFromEditText()[0], getValueFromEditText()[1]);
                break;
            case R.id.btn_minus:
                mainController.minus(getValueFromEditText()[0], getValueFromEditText()[1]);
                break;
            case R.id.btn_multiply:
                mainController.multiply(getValueFromEditText()[0], getValueFromEditText()[1]);
                break;
            case R.id.btn_divide:
                mainController.divide(getValueFromEditText()[0], getValueFromEditText()[1]);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("result_cal", resultCal);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        resultCal = savedInstanceState.getString("result_cal", "");
        setResultCalculate(resultCal);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainController.destroy();
    }

    @Override
    public void setResultCalculate(String result) {
        resultCal = result;
        tvResult.setText(String.valueOf(resultCal));
    }
}