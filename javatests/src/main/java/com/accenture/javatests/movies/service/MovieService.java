package com.accenture.javatests.movies.service;

import com.accenture.javatests.movies.data.MovieRepository;
import com.accenture.javatests.movies.model.Genre;
import com.accenture.javatests.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre) {

        return movieRepository.findAll().stream()
                .filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByLength(int length) {

        return movieRepository.findAll().stream()
                .filter(movie -> movie.getMinutes() <= length).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByName(String name){
        return movieRepository.findAll().stream().filter(movie -> movie.getName().toLowerCase().contains(name)).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByDirector(String director) {
        return movieRepository.findAll().stream().filter(movie -> movie.getDirector().toLowerCase().contains((director))).collect(Collectors.toList());
    }

}