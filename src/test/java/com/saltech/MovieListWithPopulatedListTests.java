package com.saltech;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MovieListWithPopulatedListTests {

    private MovieList movieList;
    private Movie starWars;
    private Movie starTrek;
    private Movie starGate;

    @Before
    public void SetUp() throws DuplicateMovieException {

        starWars = new Movie("Star Wars");
        starTrek = new Movie("Star Trek");
        starGate = new Movie("Star Gate");

        movieList = new MovieList();
        movieList.add(starWars);
        movieList.add(starTrek);
        movieList.add(starGate);
    }

    @Test(expected = DuplicateMovieException.class)
    public void should_throw_duplicate_movie_exception() {

        //Act
        movieList.add(starTrek);
        movieList.add(starWars);

        movieList.add(new Movie(starTrek.getName()));

        assertThat(movieList.size()).isEqualTo(2);

    }

    @Test
    public void should_rename_a_movie(){

        // Arrange
        String newName = "StartTrek I";

        // Act
        movieList.rename(starTrek, newName);

        //Assert
        assertThat(starTrek.getName()).isEqualTo(newName);
    }

    @Test(expected = DuplicateMovieException.class)
    public void should_not_rename_a_movie_to_an_existing_name(){

        // Act
        movieList.rename(starTrek, "Star Wars");

    }
}
