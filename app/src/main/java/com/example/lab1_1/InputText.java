package com.example.lab1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

public class InputText extends AppCompatActivity {

    EditText inputText;
    Button saveWord;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_text);

        inputText = (EditText) findViewById(R.id.inputText);
        saveWord = (Button) findViewById(R.id.saveButton);

        db = AppDatabase.getDatabase(getApplicationContext());


        saveWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Words words = new Words();
                words.word = String.valueOf(inputText.getText());
                db.wordsDao().insert(words);
                closeActivity();
            }
        });

    }

    private void closeActivity() {
        this.finish();
    }
}