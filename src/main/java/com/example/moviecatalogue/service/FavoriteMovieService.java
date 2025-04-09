package com.example.moviecatalogue.service;

import com.example.moviecatalogue.model.FavoriteMovie;
import com.example.moviecatalogue.repository.FavoriteMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteMovieService {

    @Autowired
    private FavoriteMovieRepository favoriteMovieRepository;

    public void addToFavorites(FavoriteMovie movie) {
        favoriteMovieRepository.save(movie);
    }

    public List<FavoriteMovie> getAllFavorites() {
        return favoriteMovieRepository.findAll();
    }

    public void removeFromFavorites(int id) {
        favoriteMovieRepository.deleteById(id);
    }
}
