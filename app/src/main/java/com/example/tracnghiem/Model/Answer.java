package com.example.tracnghiem.Model;

import java.util.List;

public class Answer {
    String key;
    List<SubAnswer> subAnswers;

    public Answer(String key,  List<SubAnswer> fakeAnswer) {
        this.key = key;
        this.subAnswers = fakeAnswer;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setFakeAnswer( List<SubAnswer> subAnswers) {
        this.subAnswers = subAnswers;
    }

    public String getKey() {
        return key;
    }

    public List<SubAnswer> getSubAnswers() {
        return subAnswers;
    }

    public void setSubAnswers(List<SubAnswer> subAnswers) {
        this.subAnswers = subAnswers;
    }
}
