package com.saltech;

import com.saltech.builders.MovieBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class MovieListTest {
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

    @Test
    public void should_have_not_affect_if_sorting_an_empty_list() {

        // Act
        MovieList emptyList = new MovieList();
        MovieNameComparator nameComparator = new MovieNameComparator();
        emptyList.sortUsing(nameComparator);

        // Assert
        assertThat(emptyList.size()).isZero();
    }

    @Test
    public void should_have_no_affect_when_sorting_a_sorted_list() {

        List<Movie> expectedMovieList = new ArrayList<>();
        expectedMovieList.add(new MovieBuilder().withName("A").withCategory(Category.SCIFI).withRating(5).build());
        expectedMovieList.add(new MovieBuilder().withName("B").withCategory(Category.SCIFI).withRating(5).build());
        expectedMovieList.add(new MovieBuilder().withName("C").withCategory(Category.SCIFI).withRating(5).build());
        expectedMovieList.add(new MovieBuilder().withName("D").withCategory(Category.SCIFI).withRating(5).build());
        expectedMovieList.add(new MovieBuilder().withName("E").withCategory(Category.SCIFI).withRating(5).build());
        expectedMovieList.add(new MovieBuilder().withName("F").withCategory(Category.SCIFI).withRating(5).build());
        expectedMovieList.add(new MovieBuilder().withName("G").withCategory(Category.SCIFI).withRating(5).build());

        MovieList movieList = new MovieList();
        expectedMovieList.forEach(movieList::add);

        // Act
        movieList.sortUsing(new MovieNameComparator());

        // Assert
        assertThat(movieList.size()).isEqualTo(expectedMovieList.size());

        Integer count = 0;
        for (Movie actualMovie : movieList.getMovies()) {
            assertThat(actualMovie).isEqualTo(expectedMovieList.get(count));
            count = count + 1;
        }

    }

    @Test
    public void should_sort_by_movie_name() {

        List<Movie> expectedMovieList = new ArrayList<>();
        expectedMovieList.add(new MovieBuilder().withName("G").withCategory(Category.SCIFI).withRating(5).build());
        expectedMovieList.add(new MovieBuilder().withName("F").withCategory(Category.SCIFI).withRating(5).build());
        expectedMovieList.add(new MovieBuilder().withName("E").withCategory(Category.SCIFI).withRating(5).build());
        expectedMovieList.add(new MovieBuilder().withName("D").withCategory(Category.SCIFI).withRating(5).build());
        expectedMovieList.add(new MovieBuilder().withName("C").withCategory(Category.SCIFI).withRating(5).build());
        expectedMovieList.add(new MovieBuilder().withName("B").withCategory(Category.SCIFI).withRating(5).build());
        expectedMovieList.add(new MovieBuilder().withName("A").withCategory(Category.SCIFI).withRating(5).build());

        MovieList movieList = new MovieList();
        expectedMovieList.forEach(movieList::add);

        // Act
        movieList.sortUsing(new MovieNameComparator());

        // Assert
        assertThat(movieList.size()).isEqualTo(expectedMovieList.size());

        Integer count = movieList.size() - 1;
        for (Movie actualMovie : movieList.getMovies()) {
            assertThat(actualMovie).isEqualTo(expectedMovieList.get(count));
            count = count - 1;
        }

    }

    @Test
    public void should_have_no_affect_when_sorting_a_sorted_list_by_rating() {

        List<Movie> expectedMovieList = new ArrayList<>();
        expectedMovieList.add(new MovieBuilder().withName("A").withCategory(Category.SCIFI).withRating(1).build());
        expectedMovieList.add(new MovieBuilder().withName("B").withCategory(Category.SCIFI).withRating(2).build());
        expectedMovieList.add(new MovieBuilder().withName("C").withCategory(Category.SCIFI).withRating(3).build());
        expectedMovieList.add(new MovieBuilder().withName("D").withCategory(Category.SCIFI).withRating(4).build());
        expectedMovieList.add(new MovieBuilder().withName("E").withCategory(Category.SCIFI).withRating(5).build());
        expectedMovieList.add(new MovieBuilder().withName("F").withCategory(Category.SCIFI).withRating(6).build());
        expectedMovieList.add(new MovieBuilder().withName("G").withCategory(Category.SCIFI).withRating(7).build());

        MovieList movieList = new MovieList();
        expectedMovieList.forEach(movieList::add);

        // Act
        movieList.sortUsing(new MovieRatingComparator());

        // Assert
        assertThat(movieList.size()).isEqualTo(expectedMovieList.size());

        Integer count = movieList.size() - 1;
        for (Movie actualMovie : movieList.getMovies()) {
            assertThat(actualMovie).isEqualTo(expectedMovieList.get(count));
            count = count - 1;
        }

    }

    @Test
    public void should_sort_by_ratings_and_then_name(){

        List<Movie> expectedMovieList = new ArrayList<>();
        expectedMovieList.add(new MovieBuilder().withName("A").withCategory(Category.SCIFI).withRating(4).build());
        expectedMovieList.add(new MovieBuilder().withName("B").withCategory(Category.SCIFI).withRating(6).build());

        expectedMovieList.add(new MovieBuilder().withName("CD").withCategory(Category.SCIFI).withRating(8).build());
        expectedMovieList.add(new MovieBuilder().withName("CB").withCategory(Category.SCIFI).withRating(8).build());
        expectedMovieList.add(new MovieBuilder().withName("CA").withCategory(Category.SCIFI).withRating(8).build());

        expectedMovieList.add(new MovieBuilder().withName("D").withCategory(Category.SCIFI).withRating(9).build());

        expectedMovieList.add(new MovieBuilder().withName("E").withCategory(Category.SCIFI).withRating(1).build());
        expectedMovieList.add(new MovieBuilder().withName("Z").withCategory(Category.SCIFI).withRating(1).build());

        expectedMovieList.add(new MovieBuilder().withName("F").withCategory(Category.SCIFI).withRating(2).build());
        expectedMovieList.add(new MovieBuilder().withName("Z").withCategory(Category.SCIFI).withRating(2).build());

        expectedMovieList.add(new MovieBuilder().withName("G").withCategory(Category.SCIFI).withRating(3).build());

        MovieList movieList = new MovieList();
        expectedMovieList.forEach(movieList::add);


        movieList.sortUsing(new MovieRatingAndNameComparator());

        assertThat(movieList.size()).isEqualTo(expectedMovieList.size());




    }

    @Test
    public void should_sort_by_ratings_and_then_name_using_v1(){

        List<Movie> expectedMovieList = new ArrayList<>();
        expectedMovieList.add(new MovieBuilder().withName("A").withCategory(Category.SCIFI).withRating(4).build());
        expectedMovieList.add(new MovieBuilder().withName("B").withCategory(Category.SCIFI).withRating(6).build());

        expectedMovieList.add(new MovieBuilder().withName("CD").withCategory(Category.SCIFI).withRating(8).build());
        expectedMovieList.add(new MovieBuilder().withName("CB").withCategory(Category.SCIFI).withRating(8).build());
        expectedMovieList.add(new MovieBuilder().withName("CA").withCategory(Category.SCIFI).withRating(8).build());

        expectedMovieList.add(new MovieBuilder().withName("D").withCategory(Category.SCIFI).withRating(9).build());

        expectedMovieList.add(new MovieBuilder().withName("E").withCategory(Category.SCIFI).withRating(1).build());
        expectedMovieList.add(new MovieBuilder().withName("Z").withCategory(Category.SCIFI).withRating(1).build());

        expectedMovieList.add(new MovieBuilder().withName("F").withCategory(Category.SCIFI).withRating(2).build());
        expectedMovieList.add(new MovieBuilder().withName("Z").withCategory(Category.SCIFI).withRating(2).build());

        expectedMovieList.add(new MovieBuilder().withName("G").withCategory(Category.SCIFI).withRating(3).build());

        MovieList movieList = new MovieList();
        expectedMovieList.forEach(movieList::add);


        movieList.sortUsingV1();

        assertThat(movieList.size()).isEqualTo(expectedMovieList.size());




    }
}
