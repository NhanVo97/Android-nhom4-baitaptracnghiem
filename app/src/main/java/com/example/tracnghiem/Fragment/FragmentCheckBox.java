package com.example.tracnghiem.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tracnghiem.Activity.QuestionActivity;
import com.example.tracnghiem.Model.Question;
import com.example.tracnghiem.Model.SubQuestion;
import com.example.tracnghiem.R;
import com.example.tracnghiem.Utils.Constant;
import com.example.tracnghiem.Utils.GenerateData;

import java.io.Serializable;
import java.util.Map;

public class FragmentCheckBox extends Fragment implements View.OnClickListener {
    View v;
    TextView tvQuestion;
    CheckBox cbA,cbB,cbC,cbD;
    Button btnPrevious,btnResult,btnNext;
    Question question;
    Map<String,Question> questionMap;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_radio,container,false);
        // Anh Xa
        question = GenerateData.initQuestTion(Constant.CHECKBOX_ANSWER);
        Bundle bundle = getArguments();
        questionMap = (Map<String, Question>) bundle.getSerializable("Map");
        questionMap.put("QuestionTwo",question);
        cbA = v.findViewById(R.id.cbOne);
        cbB = v.findViewById(R.id.cbTwo);
        cbC = v.findViewById(R.id.cbThree);
        cbD = v.findViewById(R.id.cbFour);
        btnPrevious = v.findViewById(R.id.btnPreviousCB);
        btnNext = v.findViewById(R.id.btnNextCB);
        btnResult = v.findViewById(R.id.btnResultCB);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = getValueCheckBox();
                for(SubQuestion subQuestion : question.getQuestion())
                {
                    if(result.equals(subQuestion.getKey()))
                    {
                        question.setCountCorrect(1);
                    }
                }
                FragmentManager fragmentManager = getFragmentManager();
                FragmentSpinner fragmentSpinner = new FragmentSpinner();
                Bundle bundle = new Bundle();
                bundle.putSerializable("Map", (Serializable) questionMap);
                fragmentSpinner.setArguments(bundle);
                fragmentManager.beginTransaction().replace(R.id.fragmentCheckBox,fragmentSpinner);
            }
        });
        btnResult.setOnClickListener(this);
        initData();
        return v;
    }
    private String getValueCheckBox() {
        String value = "";
        if(cbA.isChecked())
        {
           value+="A,";
        }
        if(cbB.isChecked())
        {
            value+="B,";
        }
        if(cbC.isChecked())
        {
            value+="C,";
        }
        if(cbD.isChecked())
        {
            value+="D,";
        }
        return value;
    }
    private void initData() {
        tvQuestion.setText(question.getQuestion().get(0).getQuestion());
        cbA.setText(question.getListAnswer().get(0).getSubAnswers().get(0).getFakeAnswer());
        cbB.setText(question.getListAnswer().get(0).getSubAnswers().get(1).getFakeAnswer());
        cbC.setText(question.getListAnswer().get(0).getSubAnswers().get(2).getFakeAnswer());
        cbD.setText(question.getListAnswer().get(0).getSubAnswers().get(3).getFakeAnswer());
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        String result = getValueCheckBox();
        if(!result.isEmpty())
        {
            switch (id)
            {


                case R.id.btnResultCB:
                    boolean check = false;
                    for(SubQuestion subQuestion : question.getQuestion()) {
                        if(result.equals(subQuestion.getKey()))
                        {
                            check = true;
                        }
                    }
                    if(!check) {
                        Toast.makeText(getContext(), "Bạn chưa trả lời chính xác", Toast.LENGTH_SHORT).show();
                    }  else {
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
