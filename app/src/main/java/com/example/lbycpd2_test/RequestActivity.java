package com.example.lbycpd2_test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RequestActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner problemSpinner, mechanicSpinner;
    private EditText dateEditText;
    private TextView timeTextView;
    private Button confirmButton;

    private int year, month, day;
    private int tHour, tMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        setTitle("Request");

        problemSpinner = findViewById(R.id.problemSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.PROBLEM, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        problemSpinner.setAdapter(adapter);
        problemSpinner.setOnItemSelectedListener(this);


        dateEditText = findViewById(R.id.dateEditText);
        Calendar calendar = Calendar.getInstance();
        dateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(RequestActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month += 1;
                        String date = dayOfMonth+"/"+month+"/"+year;
                        dateEditText.setText(date);

                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });


        timeTextView = findViewById(R.id.timeTextView);
        timeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        RequestActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                tHour = hourOfDay;
                                tMinute = minute;

                                String time = tHour+":"+tMinute;
                                SimpleDateFormat f24hours = new SimpleDateFormat(
                                        "HH:mm"
                                );
                                try {
                                    Date date = f24hours.parse(time);
                                    SimpleDateFormat f12Hours = new SimpleDateFormat(
                                            "hh:mm aa"
                                    );

                                    timeTextView.setText(f12Hours.format(date));
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }
                        },12,0, false
                );
                //timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                timePickerDialog.updateTime(tHour, tMinute);
                timePickerDialog.show();
            }
        });

        mechanicSpinner = findViewById(R.id.mechanicSpinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.MECHANIC, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mechanicSpinner.setAdapter(adapter2);
        mechanicSpinner.setOnItemSelectedListener(this);


        confirmButton = findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RequestActivity.this, Message2Activity.class);
                intent.putExtra("PROBLEM",problemSpinner.getSelectedItem().toString());
                intent.putExtra("DATE", dateEditText.getText().toString());
                intent.putExtra("TIME",timeTextView.getText().toString());
                intent.putExtra("MECHANIC",mechanicSpinner.getSelectedItem().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String choice = parent.getItemAtPosition(position).toString();
        Toast.makeText(getApplicationContext(), choice, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}