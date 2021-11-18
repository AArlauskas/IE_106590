package com.lab3.moviequotesapi.Repositories;

import com.lab3.moviequotesapi.Models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowsRepository extends JpaRepository<Show, Long> {
}
