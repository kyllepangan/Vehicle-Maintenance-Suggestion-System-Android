package com.example.lbycpd2_test.search_problem.exterior;

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
import com.example.lbycpd2_test.MessageActivity;
import com.example.lbycpd2_test.R;

public class LostWheelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lostwheel);
        setTitle("Lost Wheel/s");
    }

    //launch Message Activity
    public void launchMessageMechanics(View v){

        Intent i = new Intent(this, MessageActivity.class);
        i.putExtra("Alert","Logging out...");
        startActivity(i);

    }

    //launch Home Activity
    public void launchHomepage(View v){

        Intent i = new Intent(this, HomeActivity.class);
        i.putExtra("Alert","Logging out...");
        startActivity(i);

    }
}