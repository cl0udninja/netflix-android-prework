package com.jelohazi.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    String todoText;
    int todoPos;
    EditText etEditItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        todoText = getIntent().getStringExtra("todoText");
        todoPos = getIntent().getIntExtra("todoPos", -1);
        etEditItem = (EditText)findViewById(R.id.etEditItem);
        etEditItem.setText(todoText);
    }

    public void onSave(View v) {
        todoText = etEditItem.getText().toString();
        Intent data = new Intent();
        data.putExtra("todoText", todoText);
        data.putExtra("todoPos", todoPos);
        data.putExtra("action", "save");
        setResult(RESULT_OK, data);
        finish();
    }

    public void onDelete(View v) {
        Intent data = new Intent();
        data.putExtra("todoPos", todoPos);
        data.putExtra("action", "delete");
        setResult(RESULT_OK, data);
        finish();
    }
}
