package com.example.tracnghiem.Utils;

import com.example.tracnghiem.Model.Answer;
import com.example.tracnghiem.Model.Question;
import com.example.tracnghiem.Model.SubAnswer;
import com.example.tracnghiem.Model.SubQuestion;

import java.util.ArrayList;
import java.util.List;

import static com.example.tracnghiem.Utils.Constant.CHECKBOX_ANSWER;
import static com.example.tracnghiem.Utils.Constant.RADIO_ANSWER;
import static com.example.tracnghiem.Utils.Constant.SPINNER_ANDSWER;
import static com.example.tracnghiem.Utils.Constant.SWITH_ANDSWER;
import static com.example.tracnghiem.Utils.Constant.TOGGLE_ANDSWER;

public class GenerateData {
    public static Question initQuestTion(int key)
    {
        Question question = new Question();
        List<SubQuestion> subQuestions = new ArrayList<>();
        List<SubAnswer> subAnswers = new ArrayList<>();
        List<Answer> answers = new ArrayList<>();
        switch (key)
        {
            case RADIO_ANSWER :
                subQuestions.add(new SubQuestion("A","Trái đát hình gì?"));
                subAnswers.add(new SubAnswer("A","Hình Tròn"));
                subAnswers.add(new SubAnswer("B","Hình Trụ"));
                subAnswers.add(new SubAnswer("C","Hình Vuông"));
                subAnswers.add(new SubAnswer("D","Hình Tam Giác"));
                answers.add(new Answer("ONE",subAnswers));
                question.setListAnswer(answers);
                question.setQuestion(subQuestions);
                break;
            case CHECKBOX_ANSWER:
                subQuestions.add(new SubQuestion("A,C","Cái gì của mình nhưng không ai dám nhận?"));
                subAnswers.add(new SubAnswer("A","Lông mày"));
                subAnswers.add(new SubAnswer("B","Lông gà"));
                subAnswers.add(new SubAnswer("C","Lông mi"));
                subAnswers.add(new SubAnswer("D","Lông mèo"));
                answers.add(new Answer("ONE",subAnswers));
                question.setListAnswer(answers);
                question.setQuestion(subQuestions);
                break;
            case SPINNER_ANDSWER:
                subQuestions.add(new SubQuestion("B","Con đường dài nhất là đường nào?"));
                subAnswers.add(new SubAnswer("A","Đường quốc lộ"));
                subAnswers.add(new SubAnswer("B","Đường đời"));
                answers.add(new Answer("ONE",subAnswers));
                subQuestions.add(new SubQuestion("A","Quần rộng nhất là quần gì?"));
                subAnswers.add(new SubAnswer("A","Quần đảo"));
                subAnswers.add(new SubAnswer("B","Quần ống to"));
                answers.add(new Answer("TWO",subAnswers));
                question.setListAnswer(answers);
                question.setQuestion(subQuestions);
                break;
            case TOGGLE_ANDSWER:
                subQuestions.add(new SubQuestion("A","4+5 = 9 đúng hay sai"));
                subAnswers.add(new SubAnswer("A","Đúng"));
                subAnswers.add(new SubAnswer("B","Sai"));
                answers.add(new Answer("ONE",subAnswers));
                subQuestions.add(new SubQuestion("B","10 - 5 = 3 đúng hay sai"));
                subAnswers.add(new SubAnswer("A","Đúng"));
                subAnswers.add(new SubAnswer("B","Sai"));
                answers.add(new Answer("TWO",subAnswers));
                question.setListAnswer(answers);
                question.setQuestion(subQuestions);
                break;
            case SWITH_ANDSWER:
                subQuestions.add(new SubQuestion("B","10/5 = 5 đúng hay sai"));
                subAnswers.add(new SubAnswer("A","Đúng"));
                subAnswers.add(new SubAnswer("B","Sai"));
                answers.add(new Answer("ONE",subAnswers));
                subQuestions.add(new SubQuestion("B","6+5 = 13 đúng hay sai"));
                subAnswers.add(new SubAnswer("A","Đúng"));
                subAnswers.add(new SubAnswer("B","Sai"));
                answers.add(new Answer("TWO",subAnswers));
                question.setListAnswer(answers);
                question.setQuestion(subQuestions);
            default:
                break;
        }
        return question;
    }
}
