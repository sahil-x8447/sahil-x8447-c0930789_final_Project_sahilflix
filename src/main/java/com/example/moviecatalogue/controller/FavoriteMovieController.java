package com.example.moviecatalogue.controller;

import com.example.moviecatalogue.model.FavoriteMovie;
import com.example.moviecatalogue.service.FavoriteMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/favorites")
public class FavoriteMovieController {

    @Autowired
    private FavoriteMovieService favoriteMovieService;

    @GetMapping
    public String showFavorites(Model model) {
        model.addAttribute("favorites", favoriteMovieService.getAllFavorites());
        return "favorites";
    }

    @PostMapping("/add")
    public String addFavorite(@ModelAttribute FavoriteMovie movie) {
        favoriteMovieService.addToFavorites(movie);
        return "redirect:/favorites";
    }

    @PostMapping("/remove/{id}")
    public String removeFavorite(@PathVariable int id) {
        favoriteMovieService.removeFromFavorites(id);
        return "redirect:/favorites";
    }
}
