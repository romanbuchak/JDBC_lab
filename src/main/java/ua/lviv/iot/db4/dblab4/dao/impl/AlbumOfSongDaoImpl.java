package ua.lviv.iot.db4.dblab4.dao.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ua.lviv.iot.db4.dblab4.dao.AlbumOfSongDao;
import ua.lviv.iot.db4.dblab4.domain.AlbumOfSong;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class AlbumOfSongDaoImpl implements AlbumOfSongDao {
    private static final String FIND_ALL = "SELECT * FROM album_of_song";
    private static final String CREATE = "INSERT album_of_song(quantity, Song_id, name) VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE album_of_song SET quantity=?, Song_id=?, name=? WHERE id=?";
    private static final String DELETE = "DELETE FROM album_of_song WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM album_of_song WHERE id=?";
    private static final String FIND_BY_ALBUM_NAME = "SELECT * FROM album_of_song WHERE name=?";

    private final JdbcTemplate jdbcTemplate;

    public AlbumOfSongDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<AlbumOfSong> findByAlbumName(String name) {
        Optional<AlbumOfSong> albumOfSong;
        try {
            albumOfSong = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ALBUM_NAME,
                    BeanPropertyRowMapper.newInstance(AlbumOfSong.class), name));
        } catch (EmptyResultDataAccessException e) {
            albumOfSong = Optional.empty();
        }
        return albumOfSong;
    }

    @Override
    public List<AlbumOfSong> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(AlbumOfSong.class));
    }

    @Override
    public Optional<AlbumOfSong> findById(Integer id) {
        Optional<AlbumOfSong> albumOfSong;
        try {
            albumOfSong = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(AlbumOfSong.class), id));
        } catch (EmptyResultDataAccessException e) {
            albumOfSong = Optional.empty();
        }
        return albumOfSong;
    }

    @Override
    public int create(AlbumOfSong albumOfSong) {
        return jdbcTemplate.update(CREATE, albumOfSong.getName());
    }

    @Override
    public int update(Integer id, AlbumOfSong albumOfSong) {
        return jdbcTemplate.update(UPDATE, albumOfSong.getName(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
