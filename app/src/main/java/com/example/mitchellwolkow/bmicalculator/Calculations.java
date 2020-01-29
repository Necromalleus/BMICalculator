package com.example.mitchellwolkow.bmicalculator;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Calculations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculations);

        TextView monthlyPayment = (TextView)findViewById(R.id.txtMonthlyPayments);
        ImageView image = (ImageView)findViewById(R.id.imgYears);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        float intPounds = sharedPref.getFloat("key1", 0);
        float intInches = sharedPref.getFloat("key2", 0);
        float decInterest = sharedPref.getFloat("key3", 0);
        float decMonthlyPayment;

        decMonthlyPayment = ((intPounds * 703) / (intInches * intInches));
        DecimalFormat currency = new DecimalFormat("##.#");
        monthlyPayment.setText("Your Body Mass Index is " + currency.format(decMonthlyPayment));

        /*if (intPounds == 3) {
            image.setImageResource(R.drawable.three);
        }
        else if (intPounds == 4) {
            image.setImageResource(R.drawable.four);
        }
        else if (intPounds == 5) {
            image.setImageResource(R.drawable.five);
        }
        else {
            monthlyPayment.setText("Enter 3, 4, or 5 Years");
        }*/
    }
}
