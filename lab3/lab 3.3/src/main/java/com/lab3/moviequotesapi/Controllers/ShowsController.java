package com.lab3.moviequotesapi.Controllers;

import com.lab3.moviequotesapi.Dtos.ShowDto;
import com.lab3.moviequotesapi.Models.Show;
import com.lab3.moviequotesapi.Services.ShowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ShowsController {
    @Autowired
    private ShowsService showsService;

    @GetMapping("/shows")
    public ResponseEntity<?> getAllShows()
    {
        var shows = showsService.getAllShows()
                .stream().map(s -> new ShowDto(s))
                .collect(Collectors.toList());
        return ResponseEntity.ok(shows);
    }

    @PostMapping("/shows")
    public ResponseEntity<?> createShow(@RequestBody Show show)
    {
        return ResponseEntity.ok(showsService.createShow(show));
    }
}
