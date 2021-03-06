package com.saltech;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

    public void sortUsing(Comparator<Movie> movieComparator) {
        Collections.sort(movies, movieComparator);
    }

    public void sortUsingV1() {

        Comparator<Movie> ratingComparator = (Movie m1, Movie m2) -> m2.getRawRating().compareTo(m1.getRawRating());
        Comparator<Movie> nameComparator = (Movie m1, Movie m2) -> m1.getName().compareTo(m2.getName());

        movies.sort(ratingComparator.thenComparing(nameComparator));

    }

    public static MovieList readFrom(Reader reader) throws IOException {

        MovieList movieList = new MovieList();

        BufferedReader bufferedReader = new BufferedReader(reader);

        for (Movie newMovie = Movie.readFrom(bufferedReader); newMovie != null; newMovie = Movie.readFrom(bufferedReader)) {
            if (newMovie != null) {
                movieList.add(newMovie);
            }
        }

        return movieList;
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
