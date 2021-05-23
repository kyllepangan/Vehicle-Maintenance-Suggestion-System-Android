package com.example.lbycpd2_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity {

    private TextView usernameTextView;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle("Home");

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

    //launch "Maintenance Instruction" Activity
    public void launchMaintenanceInstruction(View v){

        Intent i = new Intent(this, InstructionActivity.class);
        i.putExtra("Alert","Logging out...");
        startActivity(i);

    }
    //launch "Provide Instruction" Activity
    public void launchDisplayProblemActivity(View v){

        Intent i = new Intent(this, DisplayProblemActivity.class);
        i.putExtra("Alert","Logging out...");
        startActivity(i);

    }

    //launch Message Activity
    public void launchMessageMechanics(View v){

        Intent i = new Intent(this, MessageActivity.class);
        i.putExtra("Alert","Logging out...");
        startActivity(i);

    }

    //launch About Us Activity
    public void launchAboutUsActivity(View v){

        Intent i = new Intent(this, AboutUsActivity.class);
        i.putExtra("Alert","Logging out...");
        startActivity(i);

    }


}