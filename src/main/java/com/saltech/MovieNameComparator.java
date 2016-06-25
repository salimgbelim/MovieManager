package com.saltech;

import java.util.Comparator;

public class MovieNameComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie movie1, Movie movie2) {

        String firstMovieName = movie1.getName();
        String secondMovieName = movie2.getName();

        return firstMovieName.compareTo(secondMovieName);
    }
}
