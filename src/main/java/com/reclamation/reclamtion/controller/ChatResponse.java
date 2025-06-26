package com.reclamation.reclamtion.controller;

public class ChatResponse {
    private String suggestions;
    private String explanation;

    public ChatResponse(String suggestions, String explanation) {
        this.suggestions = suggestions;
        this.explanation = explanation;
    }

    public String getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(String suggestions) {
        this.suggestions = suggestions;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}