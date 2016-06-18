package com.saltech;

import com.saltech.builders.MovieBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class MovieListTest //extends TestCase
{
    private MovieList movieList;
    private Movie starWars;
    private Movie starTrek;
    private Movie starGate;
    private Movie theShining;
    private Movie carrie;
    private Movie fotr;
    private Movie redOctober;
    private Movie congo;
    private Movie princessBride;

    @Before
    public void SetUp() {

        movieList = new MovieList();

        starWars = new MovieBuilder().withName("Star Wars").withCategory(Category.SCIFI).withRating(5).build();
        starTrek = new MovieBuilder().withName("Star Trek").withCategory(Category.SCIFI).withRating(3).build();

        starGate = new MovieBuilder().withName("Star Gate").withCategory(Category.SCIFI).withRating(-1).build();
        theShining = new MovieBuilder().withName("The Shining").withCategory(Category.HORROR).withRating(2).build();
        carrie = new MovieBuilder().withName("Carrie").withCategory(Category.HORROR).withRating(3).build();
        fotr = new MovieBuilder().withName("The Fellowship of the Ring").withCategory(Category.FANTASY).withRating(5).build();
        redOctober = new MovieBuilder().withName("The Hunt for Red October").withCategory(Category.THRILLER).withRating(3).build();
        congo = new MovieBuilder().withName("Congo").withCategory(Category.THRILLER).withRating(3).build();
        princessBride = new MovieBuilder().withName("The Princess Bride").withCategory(Category.FANTASY).withRating(5).build();
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
    public void should_contain_movie_that_is_added() {
        // Arrange
        movieList.add(starWars);
        movieList.add(starTrek);

        // Assert
        assertThat(movieList.contains(starWars)).isTrue();
        assertThat(movieList.contains(starTrek)).isTrue();
    }

    @Test
    public void should_return_requested_subset_movie_list() {

        // Arrange
        movieList.add(starWars);
        movieList.add(starTrek);
        movieList.add(starGate);
        movieList.add(theShining);
        movieList.add(carrie);
        movieList.add(fotr);
        movieList.add(redOctober);
        movieList.add(congo);
        movieList.add(princessBride);

        List<Movie> expectedMovies = asList(fotr, princessBride);

        // Act
        List<Movie> moviesFilteredByCategory = movieList.categorySubList(Category.FANTASY);

        // Assert
        assertThat(moviesFilteredByCategory).isEqualTo(expectedMovies);
    }

    @Test
    public void should_return_all_movies_when_filtered_by_category_ALL() {

        // Arrange
        movieList.add(starWars);
        movieList.add(starTrek);
        movieList.add(starGate);
        movieList.add(theShining);
        movieList.add(carrie);
        movieList.add(fotr);
        movieList.add(redOctober);
        movieList.add(congo);
        movieList.add(princessBride);

        // Act
        List<Movie> moviesFilteredByCategory = movieList.categorySubList(Category.ALL);

        // Assert
        assertThat(moviesFilteredByCategory).isEqualTo(movieList.getMovies());
    }
}
