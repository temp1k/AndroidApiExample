package com.example.api_example.Models;

public class Game {
    private int id_Game, student_Score;
    private String game_Name, game_Detail,game_Img, student_FIO;

    public Game(int id, String image, String game_Name, String text, String student_FIO, int score) {
        this.id_Game = id;
        this.game_Img = image;
        this.game_Name = game_Name;
        this.game_Detail = text;
        this.student_FIO = student_FIO;
        this.student_Score = score;
    }

    public int getId_Game() {
        return id_Game;
    }

    public int getStudent_Score() {
        return student_Score;
    }

    public String getGame_Name() {
        return game_Name;
    }

    public String getGame_Detail() {
        return game_Detail;
    }

    public String getGame_Img() {
        return game_Img;
    }

    public String getStudent_FIO() {
        return student_FIO;
    }

    public void setId_Game(int id_Game) {
        this.id_Game = id_Game;
    }

    public void setStudent_Score(int student_Score) {
        this.student_Score = student_Score;
    }

    public void setGame_Name(String game_Name) {
        this.game_Name = game_Name;
    }

    public void setGame_Detail(String game_Detail) {
        this.game_Detail = game_Detail;
    }

    public void setGame_Img(String game_Img) {
        this.game_Img = game_Img;
    }

    public void setStudent_FIO(String student_FIO) {
        this.student_FIO = student_FIO;
    }
}
