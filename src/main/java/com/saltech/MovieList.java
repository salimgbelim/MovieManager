package com.saltech;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieList {

    private List<Movie> movies = new ArrayList<>();

    public int size() {
        return movies.size();
    }

    public void add(Movie movie) {

        if (this.contains(movie)) {
            throw new DuplicateMovieException(movie.getName());
        }
        movies.add(movie);
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public boolean contains(Movie movie) {
        return movies.contains(movie);
    }

    public void rename(Movie movie, String newName) {

        if (this.contains(new Movie(newName, null, null))) {
            throw new DuplicateMovieException(newName);
        }

        movie.rename(newName);
    }

    public List<Movie> categorySubList(Category category) {

        if (Category.ALL.equals(category)) {
            return movies;
        }

        return movies.stream()
                .filter(movie -> movie.getCategory().equals(category))
                .collect(Collectors.toList());

    }

    public void writeTo(Writer destination) throws IOException {

        if (size() <= 0) {
            throw new NoMovieFoundException("No Movies Found");
        }

        for (Movie movieToWrite : movies) {
            movieToWrite.writeTo(destination, movieToWrite);
            destination.flush();
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieList movieList = (MovieList) o;

        return movies != null ? movies.equals(movieList.movies) : movieList.movies == null;

    }

    @Override
    public int hashCode() {
        return movies != null ? movies.hashCode() : 0;
    }
}
