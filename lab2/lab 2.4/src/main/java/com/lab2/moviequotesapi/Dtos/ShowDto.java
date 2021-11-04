package com.lab2.moviequotesapi.Dtos;

public class ShowDto {

    private String show;
    private int id;

    public ShowDto(String show, int id)
    {
        this.show = show;
        this.id = id;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
