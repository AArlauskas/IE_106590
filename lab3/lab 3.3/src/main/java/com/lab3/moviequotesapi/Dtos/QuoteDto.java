package com.lab3.moviequotesapi.Dtos;

import com.lab3.moviequotesapi.Models.Quote;

public class QuoteDto {
    public Long id;
    public String quote;
    public ShowDto show;

    public QuoteDto() {}

    public QuoteDto(Quote quote)
    {
        this.id = quote.getId();
        this.quote = quote.getQuote();
        this.show = new ShowDto(quote.getShow());
    }
}
