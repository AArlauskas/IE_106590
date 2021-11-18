package com.lab3.moviequotesapi.Services;

import com.lab3.moviequotesapi.Models.Show;
import com.lab3.moviequotesapi.Repositories.ShowsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowsService {
    @Autowired
    private ShowsRepository showsRepository;

    public List<Show> getAllShows()
    {
        return showsRepository.findAll();
    }

    public Show createShow(Show show)
    {
        return showsRepository.save(show);
    }
}
