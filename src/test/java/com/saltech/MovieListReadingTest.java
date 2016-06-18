package com.saltech;

import com.saltech.builders.MovieBuilder;
import org.junit.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

public class MovieListReadingTest {

    @Test
    public void should_return_zero_movies_when_read_from_empty_file() throws IOException {

        //Arrange
        StringReader reader = new StringReader("");

        // Act
        MovieList movieList = MovieList.readFrom(reader);

        // Assert
        assertThat(movieList.size()).isZero();
    }


    @Test
    public void should_return_one_movie_when_the_reader_has_one_movie() throws IOException {

        // Arrange
        StringReader reader = new StringReader("Star Trek | Science Fiction | 3 |\n");

        // Act
        MovieList movieList = MovieList.readFrom(reader);

        //Assert
        assertThat(movieList.size()).isEqualTo(1);
    }

    @Test
    public void should_read_multiple_movies() throws IOException {

        // Arrange
        StringReader reader = new StringReader("Star Trek | Science Fiction | 3 |\n" +
                "The Shining | Horror | 2 |\n" +
                "The Fellowship of the Ring | Fantasy | 5 |\n");


        // Act
        MovieList movieList = MovieList.readFrom(reader);

        //Assert
        assertThat(movieList.size()).isEqualTo(3);
    }

    @Test
    public void should_write_to_file_and_read_from_it() throws IOException {

        // Arrange
        File file = new File(String.valueOf("movieList.txt"));
        FileWriter destination = new FileWriter(file);

        FileReader fileReader = new FileReader(file);

        MovieList movieList = new MovieList();
        movieList.add(new MovieBuilder().withName("Star Trek").withCategory(Category.SCIFI).withRating(3).build());
        movieList.add(new MovieBuilder().withName("The Shining").withCategory(Category.HORROR).withRating(2).build());
        movieList.add(new MovieBuilder().withName("The Fellowship of the Ring").withCategory(Category.FANTASY).withRating(5).build());

        // Act
        movieList.writeTo(destination);
        MovieList actualMovieList = MovieList.readFrom(fileReader);

        //Assert
        assertThat(actualMovieList.size()).isEqualTo(movieList.size());
    }
}
