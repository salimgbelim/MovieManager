package com.saltech;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MovieListTest //extends TestCase
{
    private MovieList movieList;
    private Movie starWars;
    private Movie starTrek;

    @Before
    public void SetUp() {

        movieList = new MovieList();
        starWars = new Movie("Star Wars");
        starTrek = new Movie("Star Trek");
    }

    @Test
    public void should_return_zero_movies() {

        assertThat(movieList.size()).isZero();
    }


    @Test
    public void should_return_appropriate_size_after_adding_one_movie() {
        // Act
        movieList.add(starWars);

        // Assert
        assertThat(movieList.size()).isEqualTo(1);
    }

    @Test
    public void should_return_two_after_adding_two_movies() {
        // Arrange
        movieList.add(starWars);
        movieList.add(starTrek);

        // Assert
        assertThat(movieList.size()).isEqualTo(2);
    }

    @Test
    public void should_contain_movie_that_is_added(){
        // Arrange
        movieList.add(starWars);
        movieList.add(starTrek);

        // Assert
        assertThat(movieList.contains(starWars)).isTrue();
        assertThat(movieList.contains(starTrek)).isTrue();
    }

/*
    public static void main(String[] args){
        TestRunner.run(MovieListTest.class);
    }*/
}
