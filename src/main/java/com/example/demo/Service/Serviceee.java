package com.example.demo.Service;

import com.example.demo.ExcelUpload.ExcelHelper;
import com.example.demo.ExcelUpload.ExcelHelpperForRatings;
import com.example.demo.Repository.MoviesRepository;
import com.example.demo.Repository.RatingRepository;
import com.example.demo.dtos.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.Model.movies;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.Model.ratings;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Serviceee {
    @Autowired
    private MoviesRepository moviesRepository;

    @Autowired
    private RatingRepository ratingRepository;

    public void save(MultipartFile file) {
        try {
            List<movies> tutorials = ExcelHelper.csvToTutorials(file.getInputStream());
            moviesRepository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public void saveForRatings(MultipartFile file) {
        try {
            List<ratings> tutorials = ExcelHelpperForRatings.csvToDBRatings(file.getInputStream());
            ratingRepository.saveAll(tutorials);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public List<movies> getName( ) {
        return moviesRepository.findAll();
    }

    public ResponseEntity getTopTen(){
     List<movies> movies =    moviesRepository.getTopTenRunTimeMovies();
        return ResponseEntity.ok().body(movies);
    }

    public ResponseEntity getMoviesRatingMoreThanSix(){
     List<ratings> movies =    ratingRepository.getMoviesRatingMoreThanSix();
        return ResponseEntity.ok().body(movies);
    }

    public  ResponseEntity post(DTO dto){
//        ArrayList<DTO> dtos = new ArrayList<DTO>();
      movies movies = new movies();
      ratings ratings = new ratings();

      movies.setTconst(dto.getTconst());
      movies.setRuntimeMinutes(dto.getRunTime());
      movies.setTitleType(dto.getTitleType());
      movies.setGeners(dto.getGenres());
      movies.setPrimaryTitle(dto.getPrimaryTitle());


        moviesRepository.save(movies);

      ratings.setAvgRating(dto.getAvgRating());
      ratings.setNumVotes(dto.getNumVotes());
        ratings.setTconst(dto.getTconst());

        ratingRepository.save(ratings);

        return ResponseEntity.ok().body("success");

    }





//    public movies saveName2(@RequestBody movies movies) {
//        return moviesRepository.save(movies);
//    }
//    public  ResponseEntity<ratings> saveForRatings(@RequestBody ratings rating) {
//       ratings rate =  ratingRepository.save(rating);
//        return  ResponseEntity.ok().body(rate);
//    }


}
