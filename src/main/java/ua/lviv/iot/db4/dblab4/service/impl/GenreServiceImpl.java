package ua.lviv.iot.db4.dblab4.service.impl;

import org.springframework.stereotype.Service;
import ua.lviv.iot.db4.dblab4.dao.GenreDao;
import ua.lviv.iot.db4.dblab4.domain.Genre;
import ua.lviv.iot.db4.dblab4.service.GenreService;
import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceImpl implements GenreService {
    private final GenreDao genreDao;

    public GenreServiceImpl(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @Override
    public Optional<Genre> findByGenreType(String type) {
        return genreDao.findByGenreType(type);
    }

    @Override
    public List<Genre> findAll() {
        return genreDao.findAll();
    }

    @Override
    public Optional<Genre> findById(Integer id) {
        return genreDao.findById(id);
    }

    @Override
    public int create(Genre genre) {
        return genreDao.create(genre);
    }

    @Override
    public int update(Integer id, Genre genre) {
        return genreDao.update(id, genre);
    }

    @Override
    public int delete(Integer id) {
        return genreDao.delete(id);
    }
}
