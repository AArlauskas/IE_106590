package com.lab2.moviequotesapi.Controllers;

import com.lab2.moviequotesapi.Dtos.ShowDto;
import com.lab2.moviequotesapi.Models.Show;
import com.lab2.moviequotesapi.Services.ShowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ShowsController {
    @Autowired
    private ShowsService showsService;

    @GetMapping("/shows")
    public ResponseEntity<List<ShowDto>> getListOfShows()
    {
        List<ShowDto> result = showsService.getShowsWithQuotes().stream().map(show -> {
            return new ShowDto(show.getName(), show.getId());
        }).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }
}
