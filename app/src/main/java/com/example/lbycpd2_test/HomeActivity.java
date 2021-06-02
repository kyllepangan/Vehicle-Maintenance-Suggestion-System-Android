package com.example.lbycpd2_test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeActivity extends AppCompatActivity {

    private TextView usernameTextView;
    private FirebaseAuth mAuth;

    private FirebaseUser user;
    private DatabaseReference reference;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle("Home");

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();

        final TextView usernameTextView = (TextView) findViewById(R.id.usernameTextView);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);

                if(userProfile !=  null){
                    String userName = userProfile.username;

                    usernameTextView.setText(" "+userName+"!");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(HomeActivity.this, "Something wrong happened!", Toast.LENGTH_LONG).show();
            }
        });

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