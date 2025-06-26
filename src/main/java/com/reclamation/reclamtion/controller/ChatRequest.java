package com.reclamation.reclamtion.controller;

public class ChatRequest {
    private String text;

    public ChatRequest() {
    }

    public ChatRequest(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}