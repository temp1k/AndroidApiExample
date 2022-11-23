package com.example.api_example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.api_example.Adapters.GameAdapter;
import com.example.api_example.Models.Game;
import com.example.api_example.Models.Manga;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    RecyclerView gameRecycler;
    ApiInterface apiInterface;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddGameActivity.class);

                getApplicationContext().startActivity(intent);
            }
        });

        gameRecycler = findViewById(R.id.gamesRecycler);

        apiInterface = RequestBuilder.buildRequest().create(ApiInterface.class);

        Call<ArrayList<Game>> getGameList = apiInterface.getGameList();

        getGameList.enqueue(new Callback<ArrayList<Game>>() {
            @Override
            public void onResponse(Call<ArrayList<Game>> call, Response<ArrayList<Game>> response) {
                if (response.isSuccessful()){
                    gameRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    gameRecycler.setHasFixedSize(true);

                    ArrayList<Game> listGame = response.body();
                    GameAdapter adapter = new GameAdapter(getApplicationContext(), listGame);
                    gameRecycler.setAdapter(adapter);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Ошибка со стороны клиента", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Game>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}