package com.example.lbycpd2_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Message2Activity extends AppCompatActivity implements CustomDialog.DialogListener{

    private EditText email2, subject, message;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        setTitle("Message");

        email2 = findViewById(R.id.email);
        subject = findViewById(R.id.subject);
        message = findViewById(R.id.message);
        button = findViewById(R.id.btn);

        openDialog();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
        String userID = user.getUid();

        final TextView usernameTextView = (TextView) findViewById(R.id.usernameTextView);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);

                if (userProfile != null) {
                    email2.setText(getIntent().getStringExtra("MECHANIC"));
                    subject.setText("Service Request for "+getIntent().getStringExtra("PROBLEM"));
                    String userName = userProfile.username;
                    email2.setText(getIntent().getStringExtra("MECHANIC"));
                    subject.setText("Service Request for "+getIntent().getStringExtra("PROBLEM"));
                    String body = "Good day sir mechanic!\n\n"+userName+" would like to request a service for my problem: "+getIntent().getStringExtra("PROBLEM")+
                            " to be done at "+getIntent().getStringExtra("TIME")+" on "+getIntent().getStringExtra("DATE")+". Please confirm to " +
                            "whether you accept the request.\n\nThank you very much.\n\nSincerely,\n"+userName+"\nc/o Vehicle Maintenance Suggestion System";
                    message.setText(body);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Message2Activity.this, "Something wrong happened!", Toast.LENGTH_LONG).show();
            }
        });

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
        String mEmail = email2.getText().toString();
        String mSubject = subject.getText().toString();
        String mMessage = message.getText().toString();

        //check missed input email
        if(mEmail.isEmpty()){
            email2.setError("Email is required");
            email2.requestFocus();
            return;
        }

        //check email's valid format
        if(!Patterns.EMAIL_ADDRESS.matcher(mEmail).matches()){
            email2.setError("Please provide a valid email");
            email2.requestFocus();
            return;
        }

        //check missed input subject
        if(mSubject.isEmpty()){
            subject.setError("Subject is required");
            subject.requestFocus();
            return;
        }

        //check missed input message
        if(mMessage.isEmpty()){
            message.setError("Password is required");
            message.requestFocus();
            return;
        }

        if(mSubject != null && !mSubject.trim().isEmpty()) {
            if(mEmail != null && !mEmail.trim().isEmpty()) {
                if(mMessage != null && !mMessage.trim().isEmpty()) {
                    JavaMailAPI javaMailAPI = new JavaMailAPI(this, mEmail, mSubject, mMessage);

                    javaMailAPI.execute();

                    Toast.makeText(Message2Activity.this, "Email Sent!", Toast.LENGTH_LONG).show();
                }
            }
        }
    }


}