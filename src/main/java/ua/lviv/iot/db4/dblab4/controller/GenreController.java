package ua.lviv.iot.db4.dblab4.controller;

import ua.lviv.iot.db4.dblab4.domain.Genre;
import java.util.Optional;

public interface GenreController extends GeneralController<Genre, Integer> {
    Optional<Genre> findByGenreType(String type);
}
