package com.example.androidlab5;

public class Message {

    private String text;
    private boolean sent;

    public Message(String text, boolean sent) {
        this.text = text;
        this.sent = sent;
    }

    public String text() { return text; }

    public boolean isSent() { return sent; }
}
