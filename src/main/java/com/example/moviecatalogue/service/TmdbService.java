package com.example.moviecatalogue.service;

import com.example.moviecatalogue.model.Movie;
import com.example.moviecatalogue.model.MovieResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Service class responsible for interacting with The Movie Database (TMDb) API.
 */
@Service
public class TmdbService {

    // Inject the API key from application.properties
    @Value("${tmdb.api.key}")
    private String apiKey;

    // Base URL for TMDb API
    @Value("${tmdb.api.base-url}")
    private String baseUrl;

    // RestTemplate used to make HTTP requests
    private final RestTemplate restTemplate = new RestTemplate();

    /**
     * Fetches popular movies from TMDb.
     * @return MovieResponse object containing a list of movies
     */
    public MovieResponse getPopularMovies() {
        String uri = UriComponentsBuilder.fromHttpUrl(baseUrl + "/movie/popular")
                .queryParam("api_key", apiKey)
                .toUriString();
        return restTemplate.getForObject(uri, MovieResponse.class);
    }

    /**
     * Fetches trending movies from TMDb (weekly).
     * @return MovieResponse object containing a list of trending movies
     */
    public MovieResponse getTrendingMovies() {
        String uri = UriComponentsBuilder.fromHttpUrl(baseUrl + "/trending/movie/week")
                .queryParam("api_key", apiKey)
                .toUriString();
        return restTemplate.getForObject(uri, MovieResponse.class);
    }

    /**
     * Searches for movies by title.
     * @param query Movie title or keyword
     * @return MovieResponse object containing matched movies
     */
    public MovieResponse searchMovies(String query) {
        String uri = UriComponentsBuilder.fromHttpUrl(baseUrl + "/search/movie")
                .queryParam("api_key", apiKey)
                .queryParam("query", query)
                .toUriString();
        return restTemplate.getForObject(uri, MovieResponse.class);
    }

    /**
     * Retrieves detailed information for a specific movie.
     * @param movieId TMDb movie ID
     * @return Movie object with full details
     */
    public Movie getMovieDetails(int movieId) {
        String uri = UriComponentsBuilder.fromHttpUrl(baseUrl + "/movie/" + movieId)
                .queryParam("api_key", apiKey)
                .toUriString();
        return restTemplate.getForObject(uri, Movie.class);
    }
}
