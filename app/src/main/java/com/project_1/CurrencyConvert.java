package com.project_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class CurrencyConvert extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView mExchangeRate_tv;
    private EditText mAmount_edtv;
    private Spinner mInput_CS, mOutput_CS;

    private String[] currencies = {"USD", "EUR", "GBP", "JPY", "CAD", "AUD", "CNY", "INR"};
    private double[] exchange_Rate = {82.35, 88.79, 100.69, 109.28, 59.66, 54.78, 11.99, 1.00};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_convert);

        mExchangeRate_tv = findViewById(R.id.exchange_rate_tv);
        mAmount_edtv = findViewById(R.id.amount_edt);
        mInput_CS = findViewById(R.id.input_curr_spinner);
        mOutput_CS = findViewById(R.id.output_currency_spinner);

        ArrayAdapter<String> currencyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, currencies);
        currencyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mInput_CS.setAdapter(currencyAdapter);
        mOutput_CS.setAdapter(currencyAdapter);

        mInput_CS.setOnItemSelectedListener(this);
        mOutput_CS.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(mAmount_edtv.getText().toString().isEmpty()) {
            return;
        }
        double input_amt = Double.parseDouble(mAmount_edtv.getText().toString());
        double inputExchangeRate = exchange_Rate[mInput_CS.getSelectedItemPosition()];
        double outputExchangeRate = exchange_Rate[mOutput_CS.getSelectedItemPosition()];
        double outputAmt = input_amt * inputExchangeRate / outputExchangeRate;

        mExchangeRate_tv.setText(String.format("1 %s = %.2f %s", currencies[mInput_CS.getSelectedItemPosition()], inputExchangeRate / outputExchangeRate, currencies[mOutput_CS.getSelectedItemPosition()]));

        TextView convertedAmt_tv = findViewById(R.id.converted_amount_tv);

        convertedAmt_tv.setText(String.format("%.2f", outputAmt));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //Do Nothing
    }
}