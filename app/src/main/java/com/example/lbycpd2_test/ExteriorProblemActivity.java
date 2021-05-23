package com.example.lbycpd2_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ExteriorProblemActivity extends AppCompatActivity {

    private TextView usernameTextView;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exteriorproblem);
        setTitle("Category: Exterior");
    }

    //log out
    public void logOut(View v) {
        //launch a new activity
        Intent i = new Intent(this, LoginActivity.class);
        i.putExtra("Alert", "Logging out...");
        startActivity(i);
    }

    //launch Scratches Activity
    public void launchScratchesActivity(View v) {

        Intent i = new Intent(this, ScratchesActivity.class);
        i.putExtra("Alert", "Logging out...");
        startActivity(i);

    }

    //launch Headlight Crack Activity
    public void launchHeadlightCrackActivity(View v) {

        Intent i = new Intent(this, HeadlightCrackActivity.class);
        i.putExtra("Alert", "Logging out...");
        startActivity(i);

    }

    //launch Tire Leak Activity
    public void launchTireLeakActivity(View v) {

        Intent i = new Intent(this, TireLeakActivity.class);
        i.putExtra("Alert", "Logging out...");
        startActivity(i);

    }

    //launch Car Accident Activity
    public void launchCarAccidentActivity(View v) {

        Intent i = new Intent(this, CarAccidentActivity.class);
        i.putExtra("Alert", "Logging out...");
        startActivity(i);

    }

    //launch Lost Wheel/s Activity
    public void launchLostWheelActivity(View v) {

        Intent i = new Intent(this, LostWheelActivity.class);
        i.putExtra("Alert", "Logging out...");
        startActivity(i);

    }
}


