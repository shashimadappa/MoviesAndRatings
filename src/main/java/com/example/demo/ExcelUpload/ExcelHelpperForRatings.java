package com.example.demo.ExcelUpload;

import com.example.demo.Model.movies;
import com.example.demo.Model.ratings;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExcelHelpperForRatings {

    public static String TYPE = "text/csv";
    static String[] HEADERs = {  "tconst", "averageRating", "numVotes"};

    public static boolean hasCSVFormatForRatings(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<ratings> csvToDBRatings(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<ratings> tutorials = new ArrayList<ratings>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                ratings tutorial = new ratings(
                        csvRecord.get("tconst"),
                        Double.parseDouble(csvRecord.get("averageRating")),
                        Long.parseLong(csvRecord.get("numVotes"))

                );

                tutorials.add(tutorial);
            }

            return tutorials;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
