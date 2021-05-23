package com.example.lbycpd2_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ElectricalProblemActivity extends AppCompatActivity {

    private TextView usernameTextView;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electricalproblem);
        setTitle("Category: Electricals");
    }

    //log out
    public void logOut(View v) {
        //launch a new activity
        Intent i = new Intent(this, LoginActivity.class);
        i.putExtra("Alert", "Logging out...");
        startActivity(i);
    }

    //launch Radio Not Working Activity
    public void launchRadioNotWorkingActivity(View v) {

        Intent i = new Intent(this, RadioNotWorkingActivity.class);
        i.putExtra("Alert", "Logging out...");
        startActivity(i);

    }

    //launch Indicator Showing Activity
    public void launchIndicatorShowingActivity(View v) {

        Intent i = new Intent(this, IndicatorShowingActivity.class);
        i.putExtra("Alert", "Logging out...");
        startActivity(i);

    }

    //launch Electrical Upgrade Activity
    public void launchElectricalUpgradeActivity(View v) {

        Intent i = new Intent(this, ElectricalUpgradeActivity.class);
        i.putExtra("Alert", "Logging out...");
        startActivity(i);

    }

    //launch Headlight Not Working Activity
    public void launchHeadlightNotWorkingActivity(View v) {

        Intent i = new Intent(this, HeadlightNotWorkingActivity.class);
        i.putExtra("Alert", "Logging out...");
        startActivity(i);

    }
}


