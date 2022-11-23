package com.example.api_example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.api_example.Models.Game;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddGameActivity extends AppCompatActivity {

    ApiInterface apiInterface;
    Button button;
    TextView editGameName, editGameDescription,
        editGameImg, editFIOStudent, editstudentScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_game);

        editGameName = findViewById(R.id.editGameName);
        editGameDescription = findViewById(R.id.editGameDescription);
        editGameImg = findViewById(R.id.editGameImage);
        editFIOStudent = findViewById(R.id.editFIOStudent);
        editstudentScore = findViewById(R.id.editScoreStudent);

        button = findViewById(R.id.buttonAddGame);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addGameFromApi();

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                getApplicationContext().startActivity(intent);
            }
        });
    }

    public void addGameFromApi(){
        apiInterface = RequestBuilder.buildRequest().create(ApiInterface.class);

        String game_Name = editGameName.getText().toString();
        String game_Detail = editGameDescription.getText().toString();
        String game_Img = editGameImg.getText().toString();
        String student_FIO = editstudentScore.getText().toString();
        String student_Score = editstudentScore.getText().toString();

        if(game_Name.equals("") | game_Detail.equals("") | game_Img.equals("")
                | student_FIO.equals("") | student_Score.equals("")){
            Toast.makeText(getApplicationContext(), "Все поля должны быть заполнены", Toast.LENGTH_LONG).show();
        }
        else {
            Game game = new Game(0, game_Img, game_Name, game_Detail, student_FIO, Integer.parseInt(student_Score));

            Call<Game> addGame = apiInterface.addGame(game);

            addGame.enqueue(new Callback<Game>() {
                @Override
                public void onResponse(Call<Game> call, Response<Game> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Игра "+game.getGame_Name()+" успешно добавлена", Toast.LENGTH_LONG).show();
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
}