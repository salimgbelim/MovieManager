package com.saltech;

public class Movie {

    private String category = null;
    private Integer rating = -1;
    private String name;

    public Movie(String name, Integer rating, String category) {
        nullName(name);
        emptyName(name);
        this.name = name;
        this.rating = rating == null ? -1 : rating;
        this.category = (category == null) ? "UnCategorised" : category;
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

    public String getCategory() {
        return category;
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
