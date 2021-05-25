package com.example.lbycpd2_test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText emailEditText;
    private Button resetPasswordButton;
    private ProgressBar progressBar;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        setTitle("Password Reset ");

        emailEditText = (EditText) findViewById(R.id.email);
        resetPasswordButton = (Button) findViewById(R.id.resetPassword);
        resetPasswordButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                resetPassword();
            }
        });
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        auth = FirebaseAuth.getInstance();

    }

    private void resetPassword(){
        String email = emailEditText.getText().toString().trim();

        //check missed input email
        if(email.isEmpty()){
            emailEditText.setError("Email is required");
            emailEditText.requestFocus();
            return;
        }

        //if the email doesn't match the format
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailEditText.setError("Please provide valid email");
            emailEditText.requestFocus();
            return;
        }

        //show loading animation
        progressBar.setVisibility(View.VISIBLE);
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task){
                if (task.isSuccessful()) {

                    Toast.makeText(ForgotPasswordActivity.this, "Check your email!", Toast.LENGTH_LONG).show();

                    //stop loading animation
                    progressBar.setVisibility(View.GONE);

                }
                else {
                    Toast.makeText(ForgotPasswordActivity.this, "Email does not exist in Firebase", Toast.LENGTH_LONG).show();

                    //stop loading animation
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }
}
