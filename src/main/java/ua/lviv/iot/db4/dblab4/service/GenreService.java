package ua.lviv.iot.db4.dblab4.service;

import ua.lviv.iot.db4.dblab4.domain.Genre;
import java.util.Optional;

public interface GenreService extends GeneralService<Genre, Integer>{
    Optional<Genre> findByGenreType(String type);
}
