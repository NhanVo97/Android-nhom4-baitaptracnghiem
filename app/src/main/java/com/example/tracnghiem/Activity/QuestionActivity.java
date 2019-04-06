package com.example.tracnghiem.Activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tracnghiem.Fragment.FragmentRadio;
import com.example.tracnghiem.Model.Answer;
import com.example.tracnghiem.Model.Question;
import com.example.tracnghiem.Model.SubAnswer;
import com.example.tracnghiem.Model.SubQuestion;
import com.example.tracnghiem.R;
import com.example.tracnghiem.Utils.Constant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static com.example.tracnghiem.Utils.Constant.CHECKBOX_ANSWER;
import static com.example.tracnghiem.Utils.Constant.RADIO_ANSWER;
import static com.example.tracnghiem.Utils.Constant.SPINNER_ANDSWER;
import static com.example.tracnghiem.Utils.Constant.SWITH_ANDSWER;
import static com.example.tracnghiem.Utils.Constant.TOGGLE_ANDSWER;

public class QuestionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_activity);
    }

}
