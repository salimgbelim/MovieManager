package com.saltech;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MovieTests {

    @Test
    public void should_return_movie_name() {

        // Arrange
        Movie movie = new Movie("Star Wars");

        //Assert
        assertThat(movie.getName()).isEqualTo("Star Wars");
    }

    @Test
    public void should_return_valid_to_string_on_movie_name() {

        // Arrange
        Movie movie = new Movie("Star Wars");

        //Assert
        assertThat(movie.toString()).isEqualTo("Movie{name='Star Wars'}");
    }

    @Test
    public void should_test_equality() {
        //Arrange
        Movie movie1 = new Movie("Star Wars");
        Movie movie2 = new Movie("Star Wars");

        //Assert
        assertThat(movie1).isEqualTo(movie2);
    }
}
