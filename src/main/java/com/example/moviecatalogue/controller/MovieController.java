package com.example.moviecatalogue.controller;

import com.example.moviecatalogue.model.Movie;
import com.example.moviecatalogue.model.MovieResponse;
import com.example.moviecatalogue.service.TmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller for handling movie-related API endpoints.
 */
@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private TmdbService tmdbService;

    /**
     * GET endpoint to fetch popular movies from TMDb.
     * @return MovieResponse containing a list of popular movies
     */
    @GetMapping("/popular")
    public MovieResponse getPopularMovies() {
        return tmdbService.getPopularMovies();
    }

    /**
     * GET endpoint to fetch trending movies from TMDb.
     * @return MovieResponse containing a list of trending movies
     */
    @GetMapping("/trending")
    public MovieResponse getTrendingMovies() {
        return tmdbService.getTrendingMovies();
    }

    /**
     * GET endpoint to search movies based on query.
     * @param query The search string
     * @return MovieResponse containing matched movies
     */
    @GetMapping("/search")
    public MovieResponse searchMovies(@RequestParam String query) {
        return tmdbService.searchMovies(query);
    }

    /**
     * GET endpoint to fetch detailed info about a specific movie.
     * @param id Movie ID
     * @return Movie object
     */
    @GetMapping("/{id}")
    public Movie getMovieDetails(@PathVariable int id) {
        return tmdbService.getMovieDetails(id);
    }
}


