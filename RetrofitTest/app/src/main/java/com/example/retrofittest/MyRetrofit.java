package com.example.retrofittest;

import com.example.retrofittest.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MyRetrofit {

    @GET("e-mag/vol-for-app.json")
    Call<List<User>> getList();



}
