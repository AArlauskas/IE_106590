package com.lab2.moviequotesapi.Services;

import com.lab2.moviequotesapi.Models.Quote;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class QuotesService {
    private final AtomicInteger counter = new AtomicInteger();
    private List<Quote> quotes;
    public QuotesService()
    {
        quotes = new ArrayList<>();
        quotes.add(new Quote(counter.incrementAndGet(),"For Frodo", 0));
        quotes.add(new Quote(counter.incrementAndGet(),"Fool of the Took!", 0));
        quotes.add(new Quote(counter.incrementAndGet(),"I am a man of science myself", 1));
        quotes.add(new Quote(counter.incrementAndGet(),"I am the one who knocks", 2));
        quotes.add(new Quote(counter.incrementAndGet(),"You know nothing John Snow", 3));
        quotes.add(new Quote(counter.incrementAndGet(),"Alcohol is both the best solution and the biggest problem", 4));
    }

    public Quote getRandomQuote()
    {
        Collections.shuffle(quotes);
        return quotes.get(0);
    }

    public Quote getRandomQuoteFromTvShow(int showId)
    {
        List<Quote> showQuotes = quotes.stream().filter(q -> q.getShowId() == showId).collect(Collectors.toList());
        if(showQuotes.isEmpty()) return null;
        Collections.shuffle(showQuotes);
        return showQuotes.get(0);
    }

    public boolean showQuoteExists(int showId)
    {
        List<Quote> showQuotes = quotes.stream().filter(q -> q.getShowId() == showId).collect(Collectors.toList());
        return !showQuotes.isEmpty();
    }
}
