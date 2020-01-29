package com.example.mitchellwolkow.bmicalculator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    float intPounds;
    float intInches;
    float decInterest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        final EditText years = (EditText)findViewById(R.id.txtYears);
        final EditText loan = (EditText)findViewById(R.id.txtLoan);
        //final EditText interest = (EditText)findViewById(R.id.txtInterest);
        Button button = (Button)findViewById(R.id.btnPayment);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intPounds = Integer.parseInt(years.getText().toString());
                intInches = Integer.parseInt(loan.getText().toString());
                //decInterest = Float.parseFloat(interest.getText().toString());
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putFloat("key1", intPounds);
                editor.putFloat("key2", intInches);
                editor.putFloat("key3", decInterest);
                editor.commit();

                startActivity(new Intent(MainActivity.this, Calculations.class));

            }
        });
    }
}
