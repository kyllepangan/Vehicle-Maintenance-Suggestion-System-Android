package com.example.lbycpd2_test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    //attributes of the LoginActivity
    private ImageView imageViewLogo;
    private EditText editTextEmail, editTextPassword;
    private ProgressBar progressBar;
    private Button buttonLogin;
    private TextView textViewSignup, textViewForgotPassword;
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");

        //instantiation of the component of LoginActivity
        imageViewLogo = (ImageView) findViewById(R.id.imageViewLogo);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        textViewSignup = (TextView) findViewById(R.id.textViewSignup);
        textViewSignup.setOnClickListener(this);
        textViewForgotPassword = (TextView) findViewById(R.id.textViewForgotPassword);
        textViewForgotPassword.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){

            //launch Home Activity
            case R.id.buttonLogin:
                userLogin();
                break;

            //launch Register Activity
            case R.id.textViewSignup:
                startActivity(new Intent(this, RegisterActivity.class));
                break;

            //launch Forgot Password Activity
            case R.id.textViewForgotPassword:
                startActivity(new Intent(this, ForgotPasswordActivity.class));
                break;
        }
    }

    private void userLogin() {

        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        //check missed input email
        if(email.isEmpty()){
            editTextEmail.setError("Email is required!");
            editTextEmail.requestFocus();
            return;
        }

        //validation of email
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Please enter a valid email");
            editTextEmail.requestFocus();
            return;
        }

        //check missed input password
        if(password.isEmpty()){
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
            return;
        }

        //check if password length is met
        if(password.length() < 8){
            editTextPassword.setError("Min password length is 8 character!");
            editTextPassword.requestFocus();
            return;
        }

        //loading bar animation
        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                    //check email verification before login
                    if(user.isEmailVerified()){
                        //launch HomeActivity
                        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                    }

                    //ask user to verify their email
                    else{
                        user.sendEmailVerification();
                        Toast.makeText(LoginActivity.this, "Check your email to verify your account", Toast.LENGTH_LONG).show();

                    }

                }

                //Fail to login
                else{
                    Toast.makeText(LoginActivity.this, "Failed to login! Please check your credentials", Toast.LENGTH_LONG).show();
                }
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}
