package com.lab2.moviequotesapi.Services;

import com.lab2.moviequotesapi.Models.Show;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class ShowsService {
    @Autowired
    private QuotesService quotesService;
    private final AtomicInteger counter = new AtomicInteger();
    private List<Show> shows;

    public ShowsService()
    {
        shows = new ArrayList<>();
        shows.add(new Show(counter.incrementAndGet(), "Lord of the rings"));
        shows.add(new Show(counter.incrementAndGet(), "Spider-man"));
        shows.add(new Show(counter.incrementAndGet(), "Breaking bad"));
        shows.add(new Show(counter.incrementAndGet(), "Game of thrones"));
        shows.add(new Show(counter.incrementAndGet(), "Simpsons"));
        shows.add(new Show(counter.incrementAndGet(), "Dark"));
    }

    public String getShowNameById(int id)
    {
        try
        {
            Show show = shows.get(id);
            return show.getName();
        }
        catch (IndexOutOfBoundsException e)
        {
            return null;
        }
    }

    public List<Show> getShowsWithQuotes()
    {
        return shows.stream()
                .filter(s -> quotesService.showQuoteExists(s.getId()))
                .collect(Collectors.toList());
    }
}
