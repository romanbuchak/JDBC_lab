package ua.lviv.iot.db4.dblab4.controller.impl;

import org.springframework.stereotype.Service;
import ua.lviv.iot.db4.dblab4.controller.GenreController;
import ua.lviv.iot.db4.dblab4.domain.Genre;
import ua.lviv.iot.db4.dblab4.service.GenreService;

import java.util.List;
import java.util.Optional;

@Service
public class GenreControllerImpl implements GenreController {
    private final GenreService genreService;

    public GenreControllerImpl(GenreService genreService) {
        this.genreService = genreService;
    }

    @Override
    public Optional<Genre> findByGenreType(String type) {
        return genreService.findByGenreType(type);
    }

    @Override
    public List<Genre> findAll() {
        return genreService.findAll();
    }

    @Override
    public Optional<Genre> findById(Integer id) {
        return genreService.findById(id);
    }

    @Override
    public int create(Genre genre) {
        return genreService.create(genre);
    }

    @Override
    public int update(Integer id, Genre genre) {
        return genreService.update(id, genre);
    }

    @Override
    public int delete(Integer id) {
        return genreService.delete(id);
    }
}
