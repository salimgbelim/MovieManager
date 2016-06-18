package com.saltech;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MovieTest {

    @Test
    public void should_return_movie_name() {

        // Arrange
        Movie movie = new Movie("Star Wars", null, null);

        //Assert
        assertThat(movie.getName()).isEqualTo("Star Wars");
    }

    @Test
    public void should_return_valid_to_string_on_movie_name() {

        // Arrange
        Movie movie = new Movie("Star Wars", null, null);

        //Assert
        assertThat(movie.toString()).isEqualTo("Movie{name='Star Wars'}");
    }

    @Test
    public void should_test_equality() {
        //Arrange
        Movie movie1 = new Movie("Star Wars", null, null);
        Movie movie2 = new Movie("Star Wars", null, null);

        //Assert
        assertThat(movie1).isEqualTo(movie2);
    }

    @Test
    public void should_rename_the_movie() {

        // Arrange
        String newName = "Star Trek";
        Movie movie = new Movie("Star Wars", null, null);

        // Act
        movie.rename(newName);

        // Assert
        assertThat(movie.getName()).isEqualTo(newName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_not_allow_to_create_movie_with_null_name() {

        // Act
        new Movie(null, null, null);

    }

    @Test(expected = IllegalArgumentException.class)
    public void should_not_allow_to_create_movie_with_empty_name() {

        // Act
        new Movie("", null, null);

    }

    @Test(expected = IllegalArgumentException.class)
    public void should_not_allow_to_rename_a_movie_with_null_name() {

        // Act
        Movie movie = new Movie("Star Wars", null, null);
        movie.rename(null);

    }

    @Test(expected = IllegalArgumentException.class)
    public void should_not_allow_to_rename_a_movie_with_empty_name() {

        // Act
        Movie movie = new Movie("Star Wars", null, null);
        movie.rename("");

    }

    @Test
    public void should_return_false_if_unrated() {

        // Arrange
        Movie movie = new Movie("Star Wars", null, null);

        // Assert
        assertThat(movie.hasRating()).isFalse();
    }

    @Test
    public void should_return_true_if_movie_is_rated() {

        // Act
        Movie movie = new Movie("Star Wars", 5, null);

        // Assert
        assertThat(movie.hasRating()).isTrue();
    }

    @Test
    public void should_return_return_the_ratings() {

        // Act
        Movie movie = new Movie("Star Wars", 5, null);

        // Assert
        assertThat(movie.getRating()).isEqualTo(5);
    }

    @Test(expected = UnRatedException.class)
    public void should_return_UnRatedException_when_movie_is_not_rated() {

        // Assert
        Movie movie = new Movie("Star Wars", null, null);

        // Act
        movie.getRating();
    }

    @Test
    public void should_return_uncatorised_when_asked_if_the_movie_is_not_categorised() {

        // Act
        Movie movie = new Movie("Star Wars", null, null);

        // Assert
        assertThat(movie.getCategory()).isEqualTo(Category.UNCATEGORISED);

    }

    @Test
    public void should_return_the_movie_category_when_asked() {

        // Act
        Movie movie = new Movie("Star Wars", null, Category.SCIFI);

        // Assert
        assertThat(movie.getCategory()).isEqualTo(Category.SCIFI);
    }

}
