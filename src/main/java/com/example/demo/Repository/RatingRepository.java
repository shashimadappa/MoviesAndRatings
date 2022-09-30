package com.example.demo.Repository;

import com.example.demo.Model.movies;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Model.ratings;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RatingRepository extends JpaRepository<ratings, String> {

    @Query(value = "SELECT * FROM ratings where avg_rating > 6.0;", nativeQuery = true)
    List<ratings> getMoviesRatingMoreThanSix();
}
