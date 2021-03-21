package com.example.lab1_1;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Words {

    @PrimaryKey(autoGenerate = true)
    public long id;

    public String word;
}
