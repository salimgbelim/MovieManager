package com.saltech;

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

        starWars = new Movie("Star Wars", 5, Category.SCIFI);
        starTrek = new Movie("Star Trek", 3 , Category.SCIFI);

        starGate = new Movie("Star Gate", -1, Category.SCIFI);
        theShining = new Movie("The Shining", 2, Category.HORROR);
        carrie = new Movie("Carrie", 3, Category.HORROR);
        fotr = new Movie("The Fellowship of the Ring", 5, Category.FANTASY);
        redOctober = new Movie("The Hunt for Red October", 3, Category.THRILLER);
        congo = new Movie("Congo", 3, Category.THRILLER);
        princessBride = new Movie("The Princess Bride", 5, Category.FANTASY);
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
    public void should_return_requested_subset_movie_list(){

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
    public void should_return_all_movies_when_filtered_by_category_ALL(){

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
