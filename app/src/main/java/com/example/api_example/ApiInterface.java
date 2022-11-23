package com.example.api_example;

import com.example.api_example.Models.Game;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("game")
    Call<ArrayList<Game>> getGameList();
    @GET("game/{id_Game}")
    Call<Game> getGameItem(@Path("id_Game") int id);
    @POST("game")
    Call<Game> addGame(@Body Game game);
    @DELETE("game/{id_Game}")
    Call<Game> deleteGame(@Path("id_Game") int id);
}
