package com.example.lbycpd2_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InstructionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);
        setTitle("Instruction");
    }

    //launch "Air Filter" Activity
    public void launchAirFilter(View v){

        Intent i = new Intent(this, AirFilterActivity.class);
        i.putExtra("Alert","Logging out...");
        startActivity(i);

    }

    //launch "Car Wash" Activity
    public void launchCarWash(View v){

        Intent i = new Intent(this, CarWashActivity.class);
        i.putExtra("Alert","Logging out...");
        startActivity(i);

    }

    //launch "Battery Maintenance" Activity
    public void launchBatteryMaintenanceActivity(View v){

        Intent i = new Intent(this, BatteryMaintenanceActivity.class);
        i.putExtra("Alert","Logging out...");
        startActivity(i);

    }

    //launch "Fuel Filter Replacement" Activity
    public void launchFuelFilterActivity(View v){

        Intent i = new Intent(this, FuelFilterReplacementActivity.class);
        i.putExtra("Alert","Logging out...");
        startActivity(i);

    }

    //launch "Engine Oil" Activity
    public void launchOilActivity(View v){

        Intent i = new Intent(this, OilActivity.class);
        i.putExtra("Alert","Logging out...");
        startActivity(i);

    }

    //launch "Brake Pads Replacement" Activity
    public void launchBrakePadsActivity(View v){

        Intent i = new Intent(this, BrakePadsActivity.class);
        i.putExtra("Alert","Logging out...");
        startActivity(i);

    }
}