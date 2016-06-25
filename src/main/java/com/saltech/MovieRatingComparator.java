package com.saltech;

import java.util.Comparator;

public class MovieRatingComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie movie1, Movie movie2) {

        Integer firstMovieRating = movie1.getRawRating();
        Integer secondMovieRating = movie2.getRawRating();

        return secondMovieRating - firstMovieRating;
    }
}
