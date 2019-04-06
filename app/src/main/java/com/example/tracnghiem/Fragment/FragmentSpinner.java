package com.example.tracnghiem.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tracnghiem.Model.Question;
import com.example.tracnghiem.Model.SubAnswer;
import com.example.tracnghiem.Model.SubQuestion;
import com.example.tracnghiem.R;
import com.example.tracnghiem.Utils.Constant;
import com.example.tracnghiem.Utils.GenerateData;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class FragmentSpinner extends Fragment implements View.OnClickListener {
    TextView tvQuestionOne,tvQuestionTwo;
    Spinner spAsOne,spAsTwo;
    Button btnPrevious,btnResult,btnNext;
    Question question;
    Map<String,Question> questionsMap;
    View v;
    SubAnswer subAnswer1, subAnswer2;
    boolean check = false;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_spinner,container,false);
        tvQuestionOne = v.findViewById(R.id.tvQuestionOneSp);
        tvQuestionTwo = v.findViewById(R.id.tvQuestionTwoSp);
        Bundle bundle = getArguments();
        questionsMap = (Map<String, Question>) bundle.getSerializable("Map");
        questionsMap.put("QuestionThree",question);
        spAsOne = v.findViewById(R.id.spinnerOne);
        spAsTwo = v.findViewById(R.id.spinnerTwo);
        btnPrevious = v.findViewById(R.id.btnPreviousSP);
        btnNext = v.findViewById(R.id.btnNextSP);
        btnResult = v.findViewById(R.id.btnResultSP);
        btnNext.setOnClickListener(this);
        btnResult.setOnClickListener(this);
        initData();
        spAsOne.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                subAnswer1 = question.getListAnswer().get(0).getSubAnswers().get(position);
                for(SubQuestion subQuestion : question.getQuestion())
                {
                    if(subAnswer1.getKey().equals(subQuestion.getKey()))
                    {
                        question.setCountCorrect(question.getCountCorrect()+1);
                        check = true;
                        break;
                    } else {
                        check = false;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spAsTwo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                subAnswer2 = question.getListAnswer().get(1).getSubAnswers().get(position);
                for (SubQuestion subQuestion : question.getQuestion()) {
                    if (subAnswer2.getKey().equals(subQuestion.getKey())) {
                        question.setCountCorrect(question.getCountCorrect() + 1);
                        check = true;
                        break;
                    } else {
                        check = false;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return v;
    }

    private void initData() {
        tvQuestionOne.setText(question.getQuestion().get(0).getQuestion());
        tvQuestionTwo.setText(question.getQuestion().get(1).getQuestion());
        question = GenerateData.initQuestTion(Constant.SPINNER_ANDSWER);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(subAnswer1!=null && subAnswer2!=null)
        {
            switch (id)
            {
                case R.id.btnNextCB:
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentSpinner fragmentSpinner = new FragmentSpinner();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Map", (Serializable) questionsMap);
                    fragmentSpinner.setArguments(bundle);
                    fragmentManager.beginTransaction().replace(R.id.fragmentCheckBox,fragmentSpinner);
                    break;
                case R.id.btnResultCB:
                    if(!check) {
                        Toast.makeText(getContext(), "Bạn chả lời sai rồi nhé", Toast.LENGTH_SHORT).show();
                    }
                    else {
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
