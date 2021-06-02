package com.example.lbycpd2_test.preventive_maintenance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.lbycpd2_test.HomeActivity;
import com.example.lbycpd2_test.R;

public class FuelFilterReplacementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuelfilter);
        setTitle("Fuel Filter Maintenance");
    }

    //launch "Solution" Activity
    public void launchHomepage(View v){

        Intent i = new Intent(this, HomeActivity.class);
        i.putExtra("Alert","Logging out...");
        startActivity(i);

    }
}