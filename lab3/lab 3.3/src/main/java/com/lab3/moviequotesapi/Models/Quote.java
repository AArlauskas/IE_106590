package com.lab3.moviequotesapi.Models;

import javax.persistence.*;

@Entity
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String quote;

    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;

    public Quote() {}

    public Quote(Long id, String quote, Show show)
    {
        this.id = id;
        this.quote = quote;
        this.show = show;
    }

    public Quote(String quote, Show show)
    {
        this.quote = quote;
        this.show = show;
    }

    public Quote(String quote)
    {
        this.quote = quote;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }
}
