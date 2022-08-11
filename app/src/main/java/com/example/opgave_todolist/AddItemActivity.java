package com.example.opgave_todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        Button addButton = (Button) findViewById(R.id.addBtn);
        Button goBackButton = (Button) findViewById(R.id.goBackBtn);
        EditText NewItem = (EditText) findViewById(R.id.newItemText);
        Intent returnIntent = new Intent();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NewItem.getText().length() > 0) {
                    returnIntent.putExtra("newItem", NewItem.getText().toString());
                    setResult(RESULT_OK, returnIntent);
                    finish();
                }

            }
        });

        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    returnIntent.putExtra("newItem", "");
                    setResult(RESULT_OK, returnIntent);
                    finish();
            }
        });
    }
}