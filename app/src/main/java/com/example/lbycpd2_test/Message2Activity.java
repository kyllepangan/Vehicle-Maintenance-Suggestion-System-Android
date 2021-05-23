package com.example.lbycpd2_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Message2Activity extends AppCompatActivity implements CustomDialog.DialogListener{

    private EditText email, subject, message;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        setTitle("Message");

        email = findViewById(R.id.email);
        subject = findViewById(R.id.subject);
        message = findViewById(R.id.message);
        button = findViewById(R.id.btn);

        openDialog();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                senEmail();
            }
        });
    }

    public void openDialog(){
        CustomDialog customDialog = new CustomDialog();
        customDialog.show(getSupportFragmentManager(),"dialog");
    }

    @Override
    public void applyTexts(String email, String password) {
        new Utils(email, password);
    }

    private void senEmail() {
        String mEmail = email.getText().toString();
        String mSubject = subject.getText().toString();
        String mMessage = message.getText().toString();


        JavaMailAPI javaMailAPI = new JavaMailAPI(this, mEmail, mSubject, mMessage);

        javaMailAPI.execute();

        Toast.makeText(Message2Activity.this, "Email Sent!", Toast.LENGTH_LONG).show();
    }


}