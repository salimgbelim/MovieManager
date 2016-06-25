package com.saltech;

import java.util.Comparator;

public class MovieRatingAndNameComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie movie1, Movie movie2) {

        String firstMovieName = movie1.getName();
        String secondMovieName = movie2.getName();

        Integer firstMovieRating = movie1.getRawRating();
        Integer secondMovieRating = movie2.getRawRating();

        int ratingComparison = secondMovieRating.compareTo(firstMovieRating);

        if(ratingComparison == 0) {
           return firstMovieName.compareTo(secondMovieName);
        }

        return ratingComparison;
    }
}
