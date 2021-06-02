package com.example.lbycpd2_test.search_problem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.lbycpd2_test.search_problem.interior.CupholderStuckActivity;
import com.example.lbycpd2_test.search_problem.interior.DamagedDoorHandleActivity;
import com.example.lbycpd2_test.search_problem.interior.DashboardMeltingActivity;
import com.example.lbycpd2_test.search_problem.interior.LeatherCrackActivity;
import com.example.lbycpd2_test.LoginActivity;
import com.example.lbycpd2_test.R;
import com.example.lbycpd2_test.search_problem.interior.SmellyInteriorActivity;
import com.google.firebase.auth.FirebaseAuth;

public class InteriorProblemActivity extends AppCompatActivity {

    private TextView usernameTextView;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interiorproblem);
        setTitle("Category: Interior");
    }

    //log out
    public void logOut(View v) {
        //launch a new activity
        Intent i = new Intent(this, LoginActivity.class);
        i.putExtra("Alert", "Logging out...");
        startActivity(i);
    }

    //launch Leather Crack Activity
    public void launchLeatherCrackActivity(View v) {

        Intent i = new Intent(this, LeatherCrackActivity.class);
        i.putExtra("Alert", "Logging out...");
        startActivity(i);

    }

    //launch Cupholder Stuck Activity
    public void launchCupholderStuckActivity(View v) {

        Intent i = new Intent(this, CupholderStuckActivity.class);
        i.putExtra("Alert", "Logging out...");
        startActivity(i);

    }

    //launch Smelly Interior Activity
    public void launchSmellyInteriorActivity(View v) {

        Intent i = new Intent(this, SmellyInteriorActivity.class);
        i.putExtra("Alert", "Logging out...");
        startActivity(i);

    }

    //launch Dashboard Melting Activity
    public void launchDashboardMeltingActivity(View v) {

        Intent i = new Intent(this, DashboardMeltingActivity.class);
        i.putExtra("Alert", "Logging out...");
        startActivity(i);

    }

    //launch Damaged Door Handle Activity
    public void launchDamagedDoorHandleActivity(View v) {

        Intent i = new Intent(this, DamagedDoorHandleActivity.class);
        i.putExtra("Alert", "Logging out...");
        startActivity(i);

    }
}


