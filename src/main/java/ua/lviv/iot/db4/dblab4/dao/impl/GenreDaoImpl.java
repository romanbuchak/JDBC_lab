package ua.lviv.iot.db4.dblab4.dao.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ua.lviv.iot.db4.dblab4.dao.GenreDao;
import ua.lviv.iot.db4.dblab4.domain.Genre;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class GenreDaoImpl implements GenreDao {
    private static final String FIND_ALL = "SELECT * FROM genre";
    private static final String CREATE = "INSERT genre(type) VALUES (?)";
    private static final String UPDATE = "UPDATE genre SET type=? WHERE id=?";
    private static final String DELETE = "DELETE FROM genre WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM genre WHERE id=?";
    private static final String FIND_BY_GENRE_TYPE = "SELECT * FROM genre WHERE type=?";

    private final JdbcTemplate jdbcTemplate;

    public GenreDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Genre> findByGenreType(String type) {
        Optional<Genre> genre;
        try {
            genre = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_GENRE_TYPE,
                    BeanPropertyRowMapper.newInstance(Genre.class), type));
        } catch (EmptyResultDataAccessException e) {
            genre = Optional.empty();
        }
        return genre;
    }

    @Override
    public List<Genre> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Genre.class));
    }

    @Override
    public Optional<Genre> findById(Integer id) {
        Optional<Genre> genre;
        try {
            genre = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Genre.class), id));
        } catch (EmptyResultDataAccessException e) {
            genre = Optional.empty();
        }
        return genre;
    }

    @Override
    public int create(Genre genre) {
        return jdbcTemplate.update(CREATE, genre.getType());
    }

    @Override
    public int update(Integer id, Genre genre) {
        return jdbcTemplate.update(UPDATE, genre.getType(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
