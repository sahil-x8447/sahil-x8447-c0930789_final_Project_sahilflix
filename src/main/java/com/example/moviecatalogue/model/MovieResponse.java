package com.example.moviecatalogue.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * Wrapper class for the TMDb API response when fetching lists of movies.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieResponse {
    private int page;
    private List<Movie> results;

    public int getPage() {
        return page;
    }

    public List<Movie> getResults() {
        return results;
    }
}
