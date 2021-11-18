package com.lab3.moviequotesapi.Controllers;

import com.lab3.moviequotesapi.Dtos.QuoteDto;
import com.lab3.moviequotesapi.Models.Quote;
import com.lab3.moviequotesapi.Services.QuotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class QuotesController {
    @Autowired
    private QuotesService quotesService;

    @GetMapping("/quotes")
    public ResponseEntity<?> getAllQuotes()
    {
        var response = quotesService.getAllQuotes().stream()
                .map(q -> new QuoteDto(q)).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/quotes")
    public ResponseEntity<?> createQuote(@RequestBody Quote quote)
    {
        return ResponseEntity.ok(new QuoteDto(quotesService.createQuote(quote)));
    }

    @GetMapping("/quotes/random")
    public ResponseEntity<?> getRandomQuote()
    {
        var randomQuote = quotesService.getRandomQuote();
        if(randomQuote == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new QuoteDto(randomQuote));
    }

    @GetMapping(value = "/quotes/random", params = {"showId"})
    public ResponseEntity<?> getRandomQuoteFromShow(@RequestParam(name = "showId") Long showId)
    {
        var randomQuote = quotesService.getRandomQuoteFromShow(showId);
        if(randomQuote == null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new QuoteDto(randomQuote));
    }
}
