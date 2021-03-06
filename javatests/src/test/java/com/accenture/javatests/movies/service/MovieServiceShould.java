package com.accenture.javatests.movies.service;

import com.accenture.javatests.movies.data.MovieRepository;
import com.accenture.javatests.movies.model.Genre;
import com.accenture.javatests.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MovieServiceShould {

    private MovieService movieService;

    @Before
    public void setUp() throws Exception {

        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);

        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, Genre.ACTION,"Juanito Banana"),
                        new Movie(2, "Memento", 113, Genre.THRILLER, "Tom Holland"),
                        new Movie(3, "There's Something About Mary", 119, Genre.COMEDY, "Hugh Jackman"),
                        new Movie(4, "Super 8", 112, Genre.THRILLER, "Perejilo"),
                        new Movie(5, "Scream", 111, Genre.HORROR,"Spilver"),
                        new Movie(6, "Home Alone", 103, Genre.COMEDY,"Dana Paola"),
                        new Movie(7, "Matrix", 136, Genre.ACTION,"Keeano Reebs")
                )
        );

        movieService = new MovieService(movieRepository);
    }

    @Test
    public void return_movies_by_genre() {

        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);
        assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(3, 6)) );
    }

    @Test
    public void return_movies_by_length() {

        Collection<Movie> movies = movieService.findMoviesByLength(119);
        assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(2, 3, 4, 5, 6)) );
    }

    private List<Integer> getMovieIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }

    @Test
    public void returnMovieByName(){
        Collection<Movie> movies = movieService.findMoviesByName("matrix");
        assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(7, 9, 10)));
    }

    @Test
    public void returnMovieByDirector(){
        Collection<Movie> movies = movieService.findMoviesByDirector("nolan");
        assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(1, 2, 8)));
    }
    
}