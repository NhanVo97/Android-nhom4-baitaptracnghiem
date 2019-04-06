package com.example.tracnghiem.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tracnghiem.Activity.QuestionActivity;
import com.example.tracnghiem.Model.Question;
import com.example.tracnghiem.Model.SubQuestion;
import com.example.tracnghiem.R;
import com.example.tracnghiem.Utils.Constant;
import com.example.tracnghiem.Utils.GenerateData;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class FragmentRadio extends Fragment implements View.OnClickListener {
    RadioGroup rdGr;
    RadioButton rdOne,rdTwo,rdThree,rdFour;
    TextView tvQuestion;
    Button btnPrevious,btnResult,btnNext;
    Question question;
    Map<String,Question> questionsMap;
    View v;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_radio,container,false);
        // Anh Xa
         questionsMap = new HashMap<>();
        question = GenerateData.initQuestTion(Constant.RADIO_ANSWER);
        questionsMap.put("QuestionOne",question);
        tvQuestion = v.findViewById(R.id.tvCauHoiOne);
        rdGr = v.findViewById(R.id.rdGr);
        rdOne = v.findViewById(R.id.rdAsOne);
        rdTwo = v.findViewById(R.id.rdAsTwo);
        rdThree = v.findViewById(R.id.rdAsThree);
        rdFour = v.findViewById(R.id.rdAsFour);
        btnPrevious = v.findViewById(R.id.btnPreviousRD);
        btnPrevious.setEnabled(false);
        btnNext = v.findViewById(R.id.btnNextRD);
        btnResult = v.findViewById(R.id.btnResultRD);
        btnNext.setOnClickListener(this);
        btnResult.setOnClickListener(this);
        // Init Data
        initData();
        return v;
    }

    private void initData() {
        tvQuestion.setText(question.getQuestion().get(0).getQuestion());
        rdOne.setText(question.getListAnswer().get(0).getSubAnswers().get(0).getFakeAnswer());
        rdTwo.setText(question.getListAnswer().get(0).getSubAnswers().get(1).getFakeAnswer());
        rdThree.setText(question.getListAnswer().get(0).getSubAnswers().get(2).getFakeAnswer());
        rdFour.setText(question.getListAnswer().get(0).getSubAnswers().get(3).getFakeAnswer());
    }

    private String getValueRadio() {
        int idCheck = rdGr.getCheckedRadioButtonId();
        String result = "";
        switch (idCheck) {
            case R.id.rdAsOne:
                result = "A";
                break;
            case R.id.rdAsTwo:
                result = "B";
                break;
            case R.id.rdAsThree:
                result = "C";
                break;
            case R.id.rdAsFour:
                result = "D";
                break;
        }
        return result;
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        String result = getValueRadio();
        if(!result.isEmpty())
        {
            switch (id)
            {
                case R.id.btnNextRD:
                    Log.e("AAA","D");
                    for(SubQuestion subQuestion : question.getQuestion())
                    {
                        if(result.equals(subQuestion.getKey()))
                        {
                            question.setCountCorrect(question.getCountCorrect()+1);
                        }
                    }
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    FragmentCheckBox fragmentCheckBox = new FragmentCheckBox();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Map", (Serializable) questionsMap);
                    fragmentCheckBox.setArguments(bundle);
                    fragmentTransaction.replace(R.id.layout,fragmentCheckBox).addToBackStack("STACK").commit();
                    break;
                case R.id.btnResultRD:
                    boolean check = false;
                    for(SubQuestion subQuestion : question.getQuestion()) {
                    if(result.equals(subQuestion.getKey()))
                    {
                        check = true;
                    }
                }
                    if(!check) {
                        Toast.makeText(getContext(), "Bạn chưa trả lời chính xác", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "Chuẩn hết rồi", Toast.LENGTH_SHORT).show();
                    }

                    break;
            }
        }else
        {
            Toast.makeText(getContext(), "Bạn chưa chọn đáp án mà", Toast.LENGTH_SHORT).show();
        }

    }
}
