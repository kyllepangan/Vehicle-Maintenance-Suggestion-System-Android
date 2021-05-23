package com.example.lbycpd2_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DisplayProblemActivity extends AppCompatActivity {

    private TextView usernameTextView;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displayproblem);
        setTitle("Choose Problem");

//        mAuth = FirebaseAuth.getInstance();
//        FirebaseUser user = mAuth.getCurrentUser();
//
//        usernameTextView = findViewById(R.id.usernameTextView);
//        usernameTextView.setText(user.get+"!");
    }

    //log out
    public void logOut(View v){
        //launch a new activity
        Intent i = new Intent(this, LoginActivity.class);
        i.putExtra("Alert","Logging out...");
        startActivity(i);
    }

    //launch Exterior Problem Activity
    public void launchExteriorProblemActivity(View v){

        Intent i = new Intent(this, ExteriorProblemActivity.class);
        i.putExtra("Alert","Logging out...");
        startActivity(i);

    }

    //launch Exterior Problem Activity
    public void launchElectricalProblemActivity(View v){

        Intent i = new Intent(this, ElectricalProblemActivity.class);
        i.putExtra("Alert","Logging out...");
        startActivity(i);

    }

    //launch Exterior Problem Activity
    public void launchInteriorProblemActivity(View v){

        Intent i = new Intent(this, InteriorProblemActivity.class);
        i.putExtra("Alert","Logging out...");
        startActivity(i);

    }

    //launch Exterior Problem Activity
    public void launchEngineProblemActivity(View v){

        Intent i = new Intent(this, EngineProblemActivity.class);
        i.putExtra("Alert","Logging out...");
        startActivity(i);

    }

    //launch Other Problems Activity
    public void launchOthersProblemActivity(View v){

        Intent i = new Intent(this, OthersProblemActivity.class);
        i.putExtra("Alert","Logging out...");
        startActivity(i);

    }


}