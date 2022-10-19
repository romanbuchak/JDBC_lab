package ua.lviv.iot.db4.dblab4.dao.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ua.lviv.iot.db4.dblab4.dao.SongDao;
import ua.lviv.iot.db4.dblab4.domain.Song;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class SongDaoImpl implements SongDao {
    private static final String FIND_ALL = "SELECT * FROM song";
    private static final String CREATE = "INSERT song(name, Genre_id) VALUES (?)";
    private static final String UPDATE = "UPDATE song SET name=?, Genre_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM song WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM song WHERE id=?";
    private static final String FIND_BY_SONG_NAME = "SELECT * FROM song WHERE name=?";

    private final JdbcTemplate jdbcTemplate;

    public SongDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Song> findBySongName(String name) {
        Optional<Song> song;
        try {
            song = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_SONG_NAME,
                    BeanPropertyRowMapper.newInstance(Song.class), name));
        } catch (EmptyResultDataAccessException e) {
            song = Optional.empty();
        }
        return song;
    }

    @Override
    public List<Song> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Song.class));
    }

    @Override
    public Optional<Song> findById(Integer id) {
        Optional<Song> song;
        try {
            song = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Song.class), id));
        } catch (EmptyResultDataAccessException e) {
            song = Optional.empty();
        }
        return song;
    }

    @Override
    public int create(Song song) {
        return jdbcTemplate.update(CREATE, song.getName());
    }

    @Override
    public int update(Integer id, Song song) {
        return jdbcTemplate.update(UPDATE, song.getName(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
