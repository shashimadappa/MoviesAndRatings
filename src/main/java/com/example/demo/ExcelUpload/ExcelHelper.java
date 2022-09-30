package com.example.demo.ExcelUpload;

import com.example.demo.Model.movies;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.Model.ratings;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import java.io.InputStream;

public class ExcelHelper {

    public static String TYPE = "text/csv";
    static String[] HEADERs = {  "tconst", "titleType", "primaryTitle", "runtimeMinutes", "genres" };

    public static boolean hasCSVFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<movies> csvToTutorials(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<movies> tutorials = new ArrayList<movies>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                movies tutorial = new movies(


                        csvRecord.get("tconst"),
                        csvRecord.get("titleType"),
                        csvRecord.get("primaryTitle"),
                        Long.parseLong(csvRecord.get("runtimeMinutes")),
                        csvRecord.get("genres")
                );
//                csvRecord.get("geners"),
//                        csvRecord.get("tconst"),
//                        csvRecord.get("titleType"),
//                        csvRecord.get("primaryTitle"),
//                        Long.parseLong(csvRecord.get("runtimeMinutes"))

                tutorials.add(tutorial);
            }

            return tutorials;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }





//    public static String TYPE = "text/csv";
////    static String[] HEADERs = { "id", "tconst", "titileType", "primaryTitle", "runtimeMinutes","geners" };
//    static String[] HEADERs = {"id", "tconst", "titletype" };
//
//    public static boolean hasCSVFormat(MultipartFile file) {
//
//        if (!TYPE.equals(file.getContentType())) {
//            return false;
//        }
//
//        return true;
//    }

//    public static List<movies> csvToTutorials(InputStream is) {
//        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
//             CSVParser csvParser = new CSVParser(fileReader,
//                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
//
//            List<movies> tutorials = new ArrayList<movies>();
//
//            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
//
//            for (CSVRecord csvRecord : csvRecords) {
//                movies movies = new movies(
//                        csvRecord.get("tconst"),
//                        csvRecord.get("titiletype")
////                        csvRecord.get("primaryTitle"),
////                       Long.parseLong(csvRecord.get("runtimeMinutes")),
////                        csvRecord.get("geners")
//                );
//
//                tutorials.add(movies);
//            }
//            return tutorials;
//        } catch (IOException e) {
//            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
//        }
//    }
//    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
//    static String[] HEADERs = { "Id", "Title", "Description", "Published", "Title", "Title", };
//    static String SHEET = "Tutorials";
//
//    public static boolean hasExcelFormat(MultipartFile file) {
//
//        if (!TYPE.equals(file.getContentType())) {
//            return false;
//        }
//
//        return true;
//    }
//
//    public static List<movies> excelToTutorials(InputStream is) {
//        try {
//            Workbook workbook = new XSSFWorkbook(is);
//
//            Sheet sheet = workbook.getSheet(SHEET);
//            Iterator<Row> rows = sheet.iterator();
//
//            List<movies> movie = new ArrayList<movies>();
//
//            int rowNumber = 0;
//            while (rows.hasNext()) {
//                Row currentRow = rows.next();
//
//                // skip header
//                if (rowNumber == 0) {
//                    rowNumber++;
//                    continue;
//                }
//
//                Iterator<Cell> cellsInRow = currentRow.iterator();
//
//                movies movies = new movies();
//
//                int cellIdx = 0;
//                while (cellsInRow.hasNext()) {
//                    Cell currentCell = cellsInRow.next();
//
//                    switch (cellIdx) {
//                        case 0:
//                            movies.setId((int) currentCell.getNumericCellValue());
//                            break;
//
//                        case 1:
////                            tutorial.setTitle(currentCell.getStringCellValue());
//                            movies.setTconst(currentCell.getStringCellValue());
//                            break;
//
//                        case 2:
////                            tutorial.setDescription(currentCell.getStringCellValue());
//                            movies.setGeners(currentCell.getStringCellValue());
//                            break;
//
//                        case 3:
//                           movies.setPrimaryTitile(currentCell.getStringCellValue());
//                            break;
//                            case 4:
//                           movies.setTitleType(currentCell.getStringCellValue());
//                            break;
//                            case 5:
//                           movies.setRuntimeMins((int)currentCell.getNumericCellValue());
//                            break;
//                            case 6:
//
//
//                        default:
//                            break;
//                    }
//
//                    cellIdx++;
//                }
//
//                movie.add(movies);
//            }
//
//            workbook.close();
//
//            return movie;
//        } catch (IOException e) {
//            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
//        }
//    }
}
