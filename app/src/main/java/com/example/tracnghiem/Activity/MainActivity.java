package com.example.tracnghiem.Activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.tracnghiem.Model.User;
import com.example.tracnghiem.R;

import java.util.Calendar;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edName;
    TextView btnSetTime;
    Button btnPlay;
    String time = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Anh Xa
        edName = findViewById(R.id.tvUserName);
        btnSetTime = findViewById(R.id.btnSetTimePlay);
        btnPlay = findViewById(R.id.btnPlay);
        btnSetTime.setOnClickListener(this);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!edName.getText().toString().isEmpty() && !time.isEmpty())
                {
                    Intent intent = new Intent(MainActivity.this,QuestionActivity.class);
                    User user = new User();
                    user.setName(edName.getText().toString());
                    user.setTime(time);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Bạn chưa setup đầy đủ!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id)
        {
            case R.id.btnSetTimePlay:
            {
                TimePickerDialog.OnTimeSetListener dialog = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                    }
                };
                Calendar calendar = Calendar.getInstance();
                final int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String s=hourOfDay +":"+minute;
//                        int hourTam=hourOfDay;
//                        if(hourTam>12)
//                            hourTam=hourTam-12;
                        time = s;
                    }
                }, hour, minute, true);
                timePickerDialog.setTitle("Chọn thời gian");
                timePickerDialog.show();
            }

            }
        }
    }

