package com.example.tracnghiem.Model;

public class SubQuestion {
    String key;
    String question;

    public SubQuestion(String key, String fakeAnswer) {
        this.key = key;
        this.question = fakeAnswer;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setFakeAnswer(String fakeAnswer) {
        this.question = fakeAnswer;
    }

    public String getKey() {
        return key;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
