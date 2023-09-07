package com.nhnacademy.app;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class ApacheCommonsCsvMovieParser implements MovieParser {

    @Override
    public List<Movie> parse(String fileName) throws IOException {
        List<Movie> list = new ArrayList<>();

        Reader in = new InputStreamReader(getMovieFileAsStream());
        for (CSVRecord record : CSVFormat.DEFAULT.parse(in)) {
            String[] line = record.values();
            if (line[0].equals("movieId")) {
                continue;
            }
            String[] genresString = line[2].split("\\|");
            Set<String> genres = new HashSet<>();
            for (int i = 0; i < genresString.length; i++) {
                genres.add(genresString[i]);
            }
            Movie m = new Movie(Long.parseLong(line[0]), line[1], genres);
            list.add(m);
        }
        return list;
    }
}
