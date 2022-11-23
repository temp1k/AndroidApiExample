package com.example.api_example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.api_example.Models.Game;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GamePage extends AppCompatActivity {
    int id_Game;
    AppCompatButton button;
    ImageView gamePageImage;
    TextView gameTitle;
    TextView textGame;
    ApiInterface apiInterface;
    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);

        gamePageImage = findViewById(R.id.imageGame);
        gameTitle = findViewById(R.id.gamePageTitle);
        textGame = findViewById(R.id.gameText);

        id_Game = getIntent().getIntExtra("idGame", 0);

        apiInterface = RequestBuilder.buildRequest().create(ApiInterface.class);

        Call<Game> getGameItem = apiInterface.getGameItem(id_Game);

        getGameItem.enqueue(new Callback<Game>() {
            @Override
            public void onResponse(Call<Game> call, Response<Game> response) {
                if (response.isSuccessful()){
                    game = response.body();

                    //Выгрузка изображения
                    Picasso.with(getApplicationContext())
                            .load(game.getGame_Img())
                            .placeholder(R.drawable.placeholder_error_foreground)
                            .error(R.drawable.placeholder_error_foreground)
                            .into(gamePageImage);

                    gameTitle.setText(game.getGame_Name());
                    textGame.setText(game.getGame_Detail());
                }
            }

            @Override
            public void onFailure(Call<Game> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Ошибка со стороны клиента", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void deleteGame(View view) {
        apiInterface = RequestBuilder.buildRequest().create(ApiInterface.class);

        Call<Game> deleteGame = apiInterface.deleteGame(id_Game);

        deleteGame.enqueue(new Callback<Game>() {
            @Override
            public void onResponse(Call<Game> call, Response<Game> response) {
                if (response.isSuccessful()) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Ошибка со стороны клиента", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Game> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}