package com.example.lbycpd2_test.search_problem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.lbycpd2_test.search_problem.engine.LeakingFluidActivity;
import com.example.lbycpd2_test.LoginActivity;
import com.example.lbycpd2_test.search_problem.engine.OverheatActivity;
import com.example.lbycpd2_test.R;
import com.example.lbycpd2_test.search_problem.engine.TurboWhistleActivity;
import com.example.lbycpd2_test.search_problem.engine.CarDoesntStartActivity;
import com.example.lbycpd2_test.search_problem.engine.RoughIdleActivity;
import com.google.firebase.auth.FirebaseAuth;

public class EngineProblemActivity extends AppCompatActivity {

    private TextView usernameTextView;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engineproblem);
        setTitle("Category: Engine");
    }

    //log out
    public void logOut(View v) {
        //launch a new activity
        Intent i = new Intent(this, LoginActivity.class);
        i.putExtra("Alert", "Logging out...");
        startActivity(i);
    }

    //launch Rough Idle Activity
    public void launchRoughIdleActivity(View v) {

        Intent i = new Intent(this, RoughIdleActivity.class);
        i.putExtra("Alert", "Logging out...");
        startActivity(i);

    }

    //launch Car Doesnt Start Activity
    public void launchCarDoesntStartActivity(View v) {

        Intent i = new Intent(this, CarDoesntStartActivity.class);
        i.putExtra("Alert", "Logging out...");
        startActivity(i);

    }

    //launch Overheat Activity
    public void launchOverheatActivity(View v) {

        Intent i = new Intent(this, OverheatActivity.class);
        i.putExtra("Alert", "Logging out...");
        startActivity(i);

    }

    //launch Leaking Fluid Activity
    public void launchLeakingFluidActivity(View v) {

        Intent i = new Intent(this, LeakingFluidActivity.class);
        i.putExtra("Alert", "Logging out...");
        startActivity(i);

    }

    //launch Turbo Whistle Activity
    public void launchTurboWhistleActivity(View v) {

        Intent i = new Intent(this, TurboWhistleActivity.class);
        i.putExtra("Alert", "Logging out...");
        startActivity(i);

    }
}


