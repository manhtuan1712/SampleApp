package com.example.manhtuan.sampleapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response {

    @SerializedName("error_message")
    private String errorMessage;

    @SerializedName("next_page_token")
    private String nextPageToken;

    @SerializedName("status")
    private String status;

    @SerializedName("results")
    private List<Result> resultList;

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Result> getResultList() {
        return resultList;
    }

    public void setResultList(List<Result> resultList) {
        this.resultList = resultList;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
