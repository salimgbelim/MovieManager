package com.saltech;

import java.util.ArrayList;
import java.util.List;

public class MovieList {

    private List<Movie> movies = new ArrayList<Movie>();

    public int size() {
        return movies.size();
    }

    public void add(Movie movie) {

        if (this.contains(movie)) {
            throw new DuplicateMovieException(movie.getName());
        }
        movies.add(movie);
    }

    public boolean contains(Movie movie) {
        return movies.contains(movie);
    }

    public void rename(Movie movie, String newName) {

     if (this.contains(new Movie(newName))){
         throw new DuplicateMovieException(newName);
     }

        movie.rename(newName);
    }
}
