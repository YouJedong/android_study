package com.example.roomtest.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.roomtest.VO.ImageUrl;

@Dao
public interface ImageDao {

    @Insert
    void insert(ImageUrl imageUrl);

    @Query("SELECT imgUrl FROM IMAGEURL WHERE imgId = :num")
    ImageUrl getImageUrl(int num);
}
