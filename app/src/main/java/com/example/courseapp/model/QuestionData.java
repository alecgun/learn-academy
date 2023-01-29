package com.example.courseapp.model;

public class QuestionData {

    private String dataTitleAsk;
    private String dataDesceAsk;
    private String dataImageAsk;
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDataTitleAsk() {
        return dataTitleAsk;
    }

    public String getDataDesceAsk() {
        return dataDesceAsk;
    }

    public String getDataImageAsk() {
        return dataImageAsk;
    }

    public QuestionData(String dataTitleAsk, String dataDesceAsk, String dataImageAsk) {
        this.dataTitleAsk = dataTitleAsk;
        this.dataDesceAsk = dataDesceAsk;
        this.dataImageAsk = dataImageAsk;
    }

    public QuestionData(){}
}
