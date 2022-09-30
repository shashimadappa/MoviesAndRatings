package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Model.movies;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MoviesRepository extends JpaRepository<movies, String> {

    @Query(value = "SELECT * FROM movies ORDER BY runtime_minutes DESC limit 10;", nativeQuery = true)
    List<movies> getTopTenRunTimeMovies();


}
