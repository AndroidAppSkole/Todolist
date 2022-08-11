package com.example.opgave_todolist;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> TodoList;
    ArrayAdapter<String> TodoAdapter;
    ListView TodoListView;
    Button AddTodoButton;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TodoList = new ArrayList<String>();
        TodoListView = (ListView) findViewById(R.id.todo_list);
        TodoAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, TodoList);
        AddTodoButton  = (Button) findViewById(R.id.todo_listButton);
        TodoListView.setAdapter(TodoAdapter);

        AddTodoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 intent = new Intent(MainActivity.this, AddItemActivity.class);
                 launchAddActivity.launch(intent);
            }
        });

    }

    ActivityResultLauncher<Intent> launchAddActivity = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    intent = result.getData();
                    assert intent != null;
                    String newItem = intent.getStringExtra("newItem").toString();
                    if(newItem.length() > 0) {
                        TodoAdapter.add(newItem);

                    }
                }
            }

    );


}