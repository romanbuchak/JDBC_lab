package ua.lviv.iot.db4.dblab4.dao.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ua.lviv.iot.db4.dblab4.dao.MusicalLablesDao;
import ua.lviv.iot.db4.dblab4.domain.MusicalLables;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class MusicalLablesDaoImpl implements MusicalLablesDao {
    private static final String FIND_ALL = "SELECT * FROM musical_lables";
    private static final String CREATE = "INSERT musical_lables(name, is_avard, Song_id) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE musical_lables SET name=?, is_avard=?, Song_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM musical_lables WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM musical_lables WHERE id=?";
    private static final String FIND_BY_MUSICAL_LABLES_NAME = "SELECT * FROM musical_lables WHERE name=?";

    private final JdbcTemplate jdbcTemplate;

    public MusicalLablesDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<MusicalLables> findByMusicalLablesName(String name) {
        Optional<MusicalLables> musicalLables;
        try {
            musicalLables = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_MUSICAL_LABLES_NAME,
                    BeanPropertyRowMapper.newInstance(MusicalLables.class), name));
        } catch (EmptyResultDataAccessException e) {
            musicalLables = Optional.empty();
        }
        return musicalLables;
    }

    @Override
    public List<MusicalLables> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(MusicalLables.class));
    }

    @Override
    public Optional<MusicalLables> findById(Integer id) {
        Optional<MusicalLables> musicalLables;
        try {
            musicalLables = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(MusicalLables.class), id));
        } catch (EmptyResultDataAccessException e) {
            musicalLables = Optional.empty();
        }
        return musicalLables;
    }

    @Override
    public int create(MusicalLables musicalLables) {
        return jdbcTemplate.update(CREATE, musicalLables.getName());
    }

    @Override
    public int update(Integer id, MusicalLables musicalLables) {
        return jdbcTemplate.update(UPDATE, musicalLables.getName(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
