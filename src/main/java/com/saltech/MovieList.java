package com.saltech;

import java.util.ArrayList;
import java.util.List;

public class MovieList {

    private List<Movie> movies = new ArrayList<Movie>();

    public int size() {
        return movies.size();
    }

    public void add(Movie movie) {
        movies.add(movie);
    }

    public boolean contains(Movie movie) {
        return movies.contains(movie);
    }
}
