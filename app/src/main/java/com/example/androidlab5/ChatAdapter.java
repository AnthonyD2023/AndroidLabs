package com.example.androidlab5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatAdapter extends BaseAdapter {

    private ArrayList<Message> messages;

    public ChatAdapter(ArrayList<Message> messages) { this.messages = messages; }

    @Override
    public int getCount() { return messages.size(); }

    @Override
    public Message getItem(int position) { return messages.get(position); }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View currentView = inflater.inflate(R.layout.row_layout, parent, false);
        TextView send = currentView.findViewById(R.id.send_text),
                 receive = currentView.findViewById(R.id.receive_text);

        // Set text for view
        if (messages.get(position).isSent()) {
            send.setText(messages.get(position).text());
            receive.setText("");
        }
        else {
            receive.setText(messages.get(position).text());
            send.setText("");
        }

        return currentView;
    }
}
