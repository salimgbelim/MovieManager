package com.saltech;

import com.saltech.builders.MovieBuilder;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MovieListWritingTest {

    @Test(expected = NoMovieFoundException.class)
    public void should_write_empty_file() throws IOException {

        // Arrange
        StringWriter destination = new StringWriter();

        // Act
        MovieList movieList = new MovieList();

        movieList.writeTo(destination);

        // Assert
    }

    @Test
    public void should_write_one_movie_to_file() throws IOException {

        // Arrange
        StringWriter destination = new StringWriter();

        MovieList movieList = new MovieList();
        movieList.add(new MovieBuilder().withName("Star Wars").withCategory(Category.SCIFI).withRating(4).build());

        // Act
        movieList.writeTo(destination);

        //Assert
        assertThat(destination.toString()).isEqualTo("Star Wars | Science Fiction | 4 |\n");
    }

    @Test
    public void should_write_one_movie_to_file_which_is_unrated() throws IOException {

        // Arrange
        StringWriter destination = new StringWriter();

        MovieList movieList = new MovieList();
        movieList.add(new MovieBuilder().withName("Star Wars").withCategory(Category.SCIFI).build());

        // Act
        movieList.writeTo(destination);


        //Assert
        assertThat(destination.toString()).isEqualTo("Star Wars | Science Fiction | -1 |\n");
    }

    @Test
    public void should_call_flush() throws IOException {

        // Arrange
        StringWriter destination = mock(StringWriter.class);

        MovieList movieList = new MovieList();
        movieList.add(new MovieBuilder().withName("Star Wars").withCategory(Category.SCIFI).build());

        // Act
        movieList.writeTo(destination);


        //Assert
        verify(destination).flush();
    }

    @Test(expected = NoMovieFoundException.class)
    public void should_not_write_to_file_if_no_movies() throws IOException {

        // Arrange
        StringWriter destination = new StringWriter();

        MovieList movieList = new MovieList();

        // Act
        movieList.writeTo(destination);

        //Assert

    }

    @Test
    public void should_write_multiple_movie_to_file() throws IOException {

        // Arrange
        String expected = "Star Trek | Science Fiction | 3 |\n" +
                "The Shining | Horror | 2 |\n" +
                "The Fellowship of the Ring | Fantasy | 5 |\n";

        StringWriter destination = new StringWriter();

        MovieList movieList = new MovieList();
        movieList.add(new MovieBuilder().withName("Star Trek").withCategory(Category.SCIFI).withRating(3).build());
        movieList.add(new MovieBuilder().withName("The Shining").withCategory(Category.HORROR).withRating(2).build());
        movieList.add(new MovieBuilder().withName("The Fellowship of the Ring").withCategory(Category.FANTASY).withRating(5).build());

        // Act
        movieList.writeTo(destination);

        //Assert
        assertThat(destination.toString()).isEqualTo(expected);
    }


}
