package com.example.demo.Controller;

import com.example.demo.ExcelUpload.ExcelHelper;
import com.example.demo.ExcelUpload.ExcelHelpperForRatings;
import com.example.demo.Message.ResponseMessage;
import com.example.demo.Service.Serviceee;
import com.example.demo.dtos.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Model.movies;
import com.example.demo.Model.ratings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

@RestController
public class Controller {
    @Autowired
    private Serviceee serviceee;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (ExcelHelper.hasCSVFormat(file)) {
            try {
                serviceee.save(file);

                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }

        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }


    @PostMapping("/uploadR")
    public ResponseEntity<ResponseMessage> uploadFileForRatings(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (ExcelHelpperForRatings.hasCSVFormatForRatings(file)) {
            try {
                serviceee.saveForRatings(file);

                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }

        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }

//    @PostMapping("/post")
//    public  movies posting(@RequestBody movies movies){
//        return serviceee.saveName2(movies);
//    }

//    @PostMapping("/postr")
//    public   ResponseEntity<ratings> postingr(@RequestBody ratings rating){
//        return serviceee.saveForRatings(rating);
//    }

    @GetMapping("/getAllInMovies")
    public List<movies> get(){
        return serviceee.getName();
    }

    @GetMapping("/gettopten")
    public ResponseEntity ten(){
        return  serviceee.getTopTen();
    }

    @GetMapping("/getMoviesRatingMoreThanSix")
    public ResponseEntity getMoviesRatingMoreThanSix(){
        return  serviceee.getMoviesRatingMoreThanSix();
    }

    @PostMapping("/post")
    public  ResponseEntity post(@RequestBody DTO dto){
        return  serviceee.post(dto);
    }


}
