package com.saltech;

import java.io.*;
import java.util.StringTokenizer;

public class Movie {

    private Category category = Category.UNCATEGORISED;
    private Integer rating = -1;
    private String name;

    public Movie(String name, Integer rating, Category category) {
        nullName(name);
        emptyName(name);
        this.name = name;
        this.rating = rating == null ? -1 : rating;
        this.category = (category == null) ? Category.UNCATEGORISED : category;
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
        if (hasRating() == false) {
            throw new UnRatedException("Movie" + name + " is not rated");
        }
        return rating;
    }

    public Category getCategory() {
        return category;
    }

    public void writeTo(Writer destination, Movie movie) throws IOException {

        destination.write(movie.getName());
        destination.write(" | ");
        destination.write(movie.getCategory().getName().toString());
        destination.write(" | ");

        try {
            destination.write(movie.getRating().toString());
        } catch (UnRatedException ex) {
            destination.write("-1");
        }

        destination.write(" |\n");


    }
    public static Movie readFrom(BufferedReader reader) throws IOException {

        String movieLine = reader.readLine();

        if(movieLine == null) {
            return null;
        }

        StringTokenizer tokenizedLine = new StringTokenizer(movieLine, "|");

        String movieName = tokenizedLine.nextToken();
        Category category = Category.fromString(tokenizedLine.nextToken().trim());
        Integer rating = Integer.valueOf(tokenizedLine.nextToken().trim());

        Movie movie = new Movie(movieName, rating, category);

        return movie;
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

        if (category != null ? !category.equals(movie.category) : movie.category != null) return false;
        if (rating != null ? !rating.equals(movie.rating) : movie.rating != null) return false;
        return name != null ? name.equals(movie.name) : movie.name == null;

    }

    @Override
    public int hashCode() {
        int result = category != null ? category.hashCode() : 0;
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
