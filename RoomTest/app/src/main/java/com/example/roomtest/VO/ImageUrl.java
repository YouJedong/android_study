package com.example.roomtest.VO;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ImageUrl {

    @PrimaryKey(autoGenerate = true)
    public int imgId;

    @ColumnInfo(name = "imgUrl")
    public String imgUrl;

}
