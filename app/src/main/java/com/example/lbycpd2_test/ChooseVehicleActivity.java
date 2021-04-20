package com.example.lbycpd2_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ChooseVehicleActivity extends AppCompatActivity {

    private EditText makeInputField, modelInputField, variantInputField, yearInputField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosevehicle);
        setTitle("Choose Vehicle");


        //instantiation of the component of ChooseVehicle
        makeInputField = (EditText) findViewById(R.id.makeInputField);
        modelInputField = (EditText) findViewById(R.id.modelInputField);
        variantInputField = (EditText) findViewById(R.id.variantInputField);
        yearInputField = (EditText) findViewById(R.id.yearInputField);
    }

    //launch "Solution" Activity
    public void launchProvideSolution(View v){
        String make = makeInputField.getText().toString().trim();
        String model = modelInputField.getText().toString().trim();
        String variant = variantInputField.getText().toString().trim();
        String year = yearInputField.getText().toString().trim();

        //check missed input make
            if(make.isEmpty()){
            makeInputField.setError("Make is required!");
            makeInputField.requestFocus();
            return;
        }

        //check missed input model
            if(model.isEmpty()){
            modelInputField.setError("Model is required");
            modelInputField.requestFocus();
            return;
        }

        //check missed input year
            if(year.isEmpty()){
            yearInputField.setError("Year is required");
            yearInputField.requestFocus();
            return;
        }

        //check if year length is met
            if(year.length() < 4 || year.length() > 4){
            yearInputField.setError("Incorrect year");
            yearInputField.requestFocus();
            return;
        }

        //check if year input contains letters
        if (year.matches(".*[a-z].*")) {
            yearInputField.setError("Incorrect year");
            yearInputField.requestFocus();
            return;
        }
        Intent i = new Intent(this, ProvideActivity.class);
        i.putExtra("Alert","Logging out...");
        startActivity(i);

    }
}