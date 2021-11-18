package com.lab3.moviequotesapi.Dtos;

import com.lab3.moviequotesapi.Models.Show;

import java.util.ArrayList;
import java.util.List;

public class ShowDto {
    public Long id;
    public String name;
    public int year;
    public List<QuoteDto> quotes;

    public ShowDto() {
        quotes = new ArrayList<>();
    }

    public ShowDto(String name)
    {
        this.name = name;
        quotes = new ArrayList<>();
    }

    public ShowDto(Show show)
    {
        this.id = show.getId();
        this.name = show.getName();
        this.quotes = new ArrayList<>();
        this.year = show.getYear();
    }

    public ShowDto(String name, List<QuoteDto> quotes)
    {
        this.name = name;
        this.quotes = quotes;
    }
}
