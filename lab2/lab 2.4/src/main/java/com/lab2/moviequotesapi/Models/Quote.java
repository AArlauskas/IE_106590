package com.lab2.moviequotesapi.Models;

public class Quote {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    private int id;
    private String quote;
    private int showId;

    public Quote(int id, String quote, int showId)
    {
        this.id = id;
        this.quote = quote;
        this.showId = showId;
    }
}
