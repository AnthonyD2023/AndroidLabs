package com.example.androidlab5;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Message> messages = new ArrayList<>();
        ChatAdapter adapter = new ChatAdapter(messages);
        ListView listView = findViewById(R.id.list);
        EditText textInput = findViewById(R.id.text_input);

        listView.setAdapter(adapter);

        ((Button) findViewById(R.id.send_button)).setOnClickListener(clk -> {
            if (!textInput.getText().toString().equals("")) {
                messages.add(new Message(textInput.getText().toString(), true));
                textInput.setText("");
                adapter.notifyDataSetChanged();
            }
        });

        ((Button) findViewById(R.id.receive_button)).setOnClickListener(clk -> {
            if (!textInput.getText().toString().equals("")) {
                messages.add(new Message(textInput.getText().toString(), false));
                textInput.setText("");
                adapter.notifyDataSetChanged();
            }
        });

        listView.setOnItemLongClickListener((parent, view, position, id) -> {
                AlertDialog alert = new AlertDialog.Builder(MainActivity.this).create();
                alert.setTitle((String) getText(R.string.message_edit_label) + id);
                alert.setMessage(getText(R.string.dialog_option_label));

                // Add buttons
                alert.setButton(Dialog.BUTTON_POSITIVE, getText(R.string.positive_button),
                    (dialog, which) -> {
                        messages.remove((int) id);
                        adapter.notifyDataSetChanged();
                });
                alert.setButton(Dialog.BUTTON_NEGATIVE, getText(R.string.negative_button),
                        (dialog, which) -> {
                            alert.dismiss();
                });
                alert.show();
                return true;
            }
        );
    }
}