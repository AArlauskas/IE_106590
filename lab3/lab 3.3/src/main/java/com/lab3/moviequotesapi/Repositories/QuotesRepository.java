package com.lab3.moviequotesapi.Repositories;

import com.lab3.moviequotesapi.Models.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuotesRepository extends JpaRepository<Quote, Long> {
}
