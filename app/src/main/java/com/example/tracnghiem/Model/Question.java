package com.example.tracnghiem.Model;

import java.util.List;

public class Question {
    private List<SubQuestion> subQuestions;
    private List<Answer> listAnswer;
    private int countCorrect;

    public Question() {
    }

    public Question(List<SubQuestion> subQuestions, List<Answer> listAnswer) {
        this.subQuestions = subQuestions;
        this.listAnswer = listAnswer;
    }

    public List<SubQuestion> getQuestion() {
        return subQuestions;
    }

    public void setQuestion(List<SubQuestion> subQuestions) {
        this.subQuestions = subQuestions;
    }


    public List<Answer> getListAnswer() {
        return listAnswer;
    }

    public void setListAnswer(List<Answer> listAnswer) {
        this.listAnswer = listAnswer;
    }

    public int getCountCorrect() {
        return countCorrect;
    }

    public void setCountCorrect(int countCorrect) {
        this.countCorrect = countCorrect;
    }
}

