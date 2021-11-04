package com.lab2.moviequotesapi.Controllers;

import com.lab2.moviequotesapi.Dtos.QuoteDto;
import com.lab2.moviequotesapi.Models.Quote;
import com.lab2.moviequotesapi.Services.QuotesService;
import com.lab2.moviequotesapi.Services.ShowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class QuotesController {
    @Autowired
    private QuotesService quotesService;
    @Autowired
    private ShowsService showsService;

    @GetMapping("/quote")
    public ResponseEntity<QuoteDto> getRandomQuote()
    {
        Quote quote = quotesService.getRandomQuote();
        QuoteDto result = new QuoteDto();
        result.setShow(showsService.getShowNameById(quote.getShowId()));
        result.setQuote(quote.getQuote());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/quotes")
    public ResponseEntity<?> getRandomQuoteFromShow(@RequestParam(name = "show", required = true) int showId)
    {
        Quote quote = quotesService.getRandomQuoteFromTvShow(showId);
        if(quote == null) return ResponseEntity.badRequest().body("Tv show not found");
        QuoteDto result = new QuoteDto();
        result.setQuote(quote.getQuote());
        result.setShow(showsService.getShowNameById(showId));
        return ResponseEntity.ok(result);
    }
}
