package com.example.lab1_1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    public static RecyclerView recyclerView;
    static AppDatabase db;
    public static List<Words> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.getDatabase(getApplicationContext());

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        updateRV();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                Intent intent = new Intent(context, InputText.class);
                context.startActivity(intent);
                updateRV();
            }
        });
    }

    public static void updateRV () {
        list = db.wordsDao().getAll();
        recyclerView.setAdapter(new WordsAdapter(list));
    }
}