package com.saltech;

import java.security.UnrecoverableEntryException;

public class Movie {

    private Integer rating = -1;
    private String name;

    public Movie(String name) {
        nullName(name);
        emptyName(name);
        this.name = name;
    }

    public Movie(String name, Integer rating){
        this(name);
        this.rating = rating;
    }

    private void nullName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("null or empty movie name");
        }
    }

    private void emptyName(String name) {
        if (name.length() == 0) {
            throw new IllegalArgumentException("null or empty movie name");
        }
    }

    public String getName() {
        return name;
    }

    public void rename(String newName) {
        nullName(newName);
        emptyName(newName);
        this.name = newName;
    }

    public boolean hasRating() {
        return rating > -1;
    }

    public Integer getRating() {
        if(hasRating() == false){
            throw new UnRatedException("Movie" + name + " is not rated");
        }
        return rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        return name != null ? name.equals(movie.name) : movie.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
