package ua.lviv.iot.db4.dblab4.dao;

import ua.lviv.iot.db4.dblab4.domain.Genre;
import java.util.Optional;

public interface GenreDao extends GeneralDao<Genre, Integer>{
    Optional<Genre> findByGenreType(String type);
}
