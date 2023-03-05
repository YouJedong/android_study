package com.example.roomtest.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.roomtest.VO.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<User> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(User user);

    @Query("DELETE FROM User where name = :name")
    void delete(String name);

}

