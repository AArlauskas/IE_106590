package com.lab3.moviequotesapi.Services;

import com.lab3.moviequotesapi.Models.Quote;
import com.lab3.moviequotesapi.Repositories.QuotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuotesService {
    @Autowired
    private QuotesRepository quotesRepository;

    public List<Quote> getAllQuotes()
    {
        return quotesRepository.findAll();
    }

    public Quote getRandomQuote()
    {
        try
        {
            var quotes = quotesRepository.findAll();
            Collections.shuffle(quotes);
            return quotes.get(0);
        }
        catch (IndexOutOfBoundsException e)
        {
            return null;
        }
    }

    public Quote getRandomQuoteFromShow(Long showId)
    {
        try
        {
            var quotes = quotesRepository.findAll().stream()
                    .filter(q -> q.getShow().getId().equals(showId))
                    .collect(Collectors.toList());
            Collections.shuffle(quotes);
            return quotes.get(0);
        }
        catch (IndexOutOfBoundsException e)
        {
            return null;
        }
    }

    public Quote createQuote(Quote quote)
    {
        return quotesRepository.save(quote);
    }
}
