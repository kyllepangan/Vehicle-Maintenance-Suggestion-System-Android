package com.example.lbycpd2_test.search_problem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.lbycpd2_test.search_problem.others.AcActuatorActivity;
import com.example.lbycpd2_test.LoginActivity;
import com.example.lbycpd2_test.R;
import com.example.lbycpd2_test.search_problem.others.RideQualityActivity;
import com.example.lbycpd2_test.search_problem.others.UpgradingWarrantyActivity;
import com.example.lbycpd2_test.search_problem.others.WeakHeadlightsActivity;
import com.example.lbycpd2_test.search_problem.others.WeakHornActivity;
import com.google.firebase.auth.FirebaseAuth;

public class OthersProblemActivity extends AppCompatActivity {

    private TextView usernameTextView;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_othersproblem);
        setTitle("Category: Others");
    }

    //log out
    public void logOut(View v) {
        //launch a new activity
        Intent i = new Intent(this, LoginActivity.class);
        i.putExtra("Alert", "Logging out...");
        startActivity(i);
    }

    //launch AC Actuator Activity
    public void launchAcActuatorActivity(View v) {

        Intent i = new Intent(this, AcActuatorActivity.class);
        i.putExtra("Alert", "Logging out...");
        startActivity(i);

    }

    //launch Weak Horn Activity
    public void launchWeakHornActivity(View v) {

        Intent i = new Intent(this, WeakHornActivity.class);
        i.putExtra("Alert", "Logging out...");
        startActivity(i);

    }

    //launch Weak Headlights Activity
    public void launchWeakHeadlightsActivity(View v) {

        Intent i = new Intent(this, WeakHeadlightsActivity.class);
        i.putExtra("Alert", "Logging out...");
        startActivity(i);

    }

    //launch Poor Ride Quality Activity
    public void launchRideQualityActivity(View v) {

        Intent i = new Intent(this, RideQualityActivity.class);
        i.putExtra("Alert", "Logging out...");
        startActivity(i);

    }

    //launch Upgrading Warranty Activity
    public void launchUpgradeWarrantyActivity(View v) {

        Intent i = new Intent(this, UpgradingWarrantyActivity.class);
        i.putExtra("Alert", "Logging out...");
        startActivity(i);

    }
}


