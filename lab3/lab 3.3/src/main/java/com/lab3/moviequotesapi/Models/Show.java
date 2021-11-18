package com.lab3.moviequotesapi.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Show {

    public Show(Long id, String name, int year, List<Quote> quotes)
    {
        this.id = id;
        this.name = name;
        this.year = year;
        this.quotes = quotes;
    }

    public Show(String name, int year, List<Quote> quotes)
    {
        this.name = name;
        this.year = year;
        quotes.forEach(q -> {
            q.setShow(this);
        });
        this.quotes = quotes;
    }

    public Show(String name, int year)
    {
        this.name = name;
        this.year = year;
    }

    public Show() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private int year;

    @OneToMany(mappedBy = "show")
    private List<Quote> quotes = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
