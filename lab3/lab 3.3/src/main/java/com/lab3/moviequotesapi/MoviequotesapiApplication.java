package com.lab3.moviequotesapi;

import com.lab3.moviequotesapi.Models.Quote;
import com.lab3.moviequotesapi.Models.Show;
import com.lab3.moviequotesapi.Repositories.QuotesRepository;
import com.lab3.moviequotesapi.Repositories.ShowsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MoviequotesapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoviequotesapiApplication.class, args);
    }

    @Autowired
    private ShowsRepository showsRepository;

    @Autowired
    private QuotesRepository quotesRepository;

    @PostConstruct
    public void init()
    {
        if(showsRepository.findAll().size() != 0) return;
        var show = showsRepository.save(new Show("Back to the future", 1974));
        quotesRepository.save(new Quote("Great Scott!", show));

        show = showsRepository.save(new Show("Star wars", 1980));
        quotesRepository.save(new Quote("It's over Anakin, I have the high ground", show));
        quotesRepository.save(new Quote("Hello there!", show));
        quotesRepository.save(new Quote("Do or do not, there is no try", show));

        show = showsRepository.save(new Show("Lord of the rings", 2001));
        quotesRepository.save(new Quote("Fool of the took", show));

        show = showsRepository.save(new Show("Shrek", 2002));
        quotesRepository.save(new Quote("Somebody once told me the world is gonna roll me", show));
    }
}
