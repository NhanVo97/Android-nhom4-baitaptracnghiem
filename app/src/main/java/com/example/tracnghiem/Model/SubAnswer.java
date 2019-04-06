package com.example.tracnghiem.Model;

import java.util.List;

public class SubAnswer {
    String key;
    String fakeAnswer;

    public SubAnswer(String key, String fakeAnswer) {
        this.key = key;
        this.fakeAnswer = fakeAnswer;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setFakeAnswer(String fakeAnswer) {
        this.fakeAnswer = fakeAnswer;
    }

    public String getKey() {
        return key;
    }

    public String getFakeAnswer() {
        return fakeAnswer;
    }
}
