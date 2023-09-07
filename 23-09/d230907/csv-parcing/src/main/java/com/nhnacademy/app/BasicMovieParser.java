package com.nhnacademy.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BasicMovieParser implements MovieParser {

    @Override
    public List<Movie> parse(String fileName) throws IOException {
        List<Movie> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getMovieFileAsStream()));

        try {
            String line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] elements = line.split(",");
                String[] genresString = elements[2].split("\\|");
                Set<String> genres = new HashSet<>(Arrays.asList(genresString));
                Movie m = new Movie(Long.parseLong(elements[0]), elements[1], genres);
                list.add(m);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return list;
    }

}
