package com.saltech.builders;

import com.saltech.Category;
import com.saltech.Movie;

public class MovieBuilder {

    private Category category;
    private Integer rating;
    private String name;

    public MovieBuilder withName(String name){
        this.name = name;
        return this;
    }

    public MovieBuilder withRating(Integer rating){
        this.rating = rating;
        return this;
    }

    public MovieBuilder withCategory(Category category){
        this.category = category;
        return this;
    }

    public Movie build(){

        Movie movie = new Movie(name,rating,category);

        return movie;
    }
}
