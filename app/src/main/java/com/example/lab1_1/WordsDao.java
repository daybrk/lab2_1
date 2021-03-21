package com.example.lab1_1;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface WordsDao {

    @Query("SELECT * FROM Words")
    List<Words> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Words words);

    @Update
    void update(Words words);

    @Delete
    void delete(Words words);

}
