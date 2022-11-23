package com.example.api_example.Models;

public class Manga {
    private int id_Manga;
    private String manga_Name;
    private String manga_Detail;
    private String manga_Img;
    private String student_FID;
    private int student_Score;

    public Manga(int id_Manga, String manga_Name, String manga_Detail, String manga_Img, String student_FID, int student_Score) {
        this.id_Manga = id_Manga;
        this.manga_Name = manga_Name;
        this.manga_Detail = manga_Detail;
        this.manga_Img = manga_Img;
        this.student_FID = student_FID;
        this.student_Score = student_Score;
    }

    public int getId_Manga() {
        return id_Manga;
    }

    public String getManga_Name() {
        return manga_Name;
    }

    public void setId_Manga(int id_Manga) {
        this.id_Manga = id_Manga;
    }

    public void setManga_Name(String manga_Name) {
        this.manga_Name = manga_Name;
    }

    public void setManga_Detail(String manga_Detail) {
        this.manga_Detail = manga_Detail;
    }

    public void setManga_Img(String manga_Img) {
        this.manga_Img = manga_Img;
    }

    public void setStudent_FID(String student_FID) {
        this.student_FID = student_FID;
    }

    public void setStudent_Score(int student_Score) {
        this.student_Score = student_Score;
    }

    public String getManga_Detail() {
        return manga_Detail;
    }

    public String getManga_Img() {
        return manga_Img;
    }

    public String getStudent_FID() {
        return student_FID;
    }

    public int getStudent_Score() {
        return student_Score;
    }
}
