package com.example.moviecatalogue.controller;

import com.example.moviecatalogue.model.MovieResponse;
import com.example.moviecatalogue.service.TmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.moviecatalogue.model.Movie;



/**
 * Controller for rendering Thymeleaf views like welcome, home, etc.
 */
@Controller
public class ViewController {

    @Autowired
    private TmdbService tmdbService;

    /**
     * Redirects the root URL ("/") to the main homepage.
     */
    @GetMapping("/")
    public String redirectToHome() {
        return "redirect:/home";
    }

    /**
     * Renders the main SahilFlix movie homepage using Thymeleaf.
     * Supports trending (default) and search (if query is present).
     */
    @GetMapping("/home")
    public String showHomePage(@RequestParam(value = "query", required = false) String query, Model model) {
        MovieResponse movieResponse;

        if (query != null && !query.isBlank()) {
            movieResponse = tmdbService.searchMovies(query);
        } else {
            movieResponse = tmdbService.getTrendingMovies();
        }

        model.addAttribute("movies", movieResponse.getResults());
        return "index";
    }

    /**
     * Renders the welcome page using Thymeleaf.
     */
    @GetMapping("/welcome")
    public String showWelcomePage(Model model) {
        model.addAttribute("name", "Sahil Sharma");
        return "welcome";
    }

    @GetMapping("/movie/{id}")
    public String showMovieDetails(@PathVariable int id, Model model) {
        Movie movie = tmdbService.getMovieDetails(id);
        model.addAttribute("movie", movie);
        return "details"; // Loads details.html
    }

}
