package ua.lviv.iot.db4.dblab4.dao.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ua.lviv.iot.db4.dblab4.dao.DownloadDao;
import ua.lviv.iot.db4.dblab4.domain.Download;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class DownloadDaoImpl implements DownloadDao {
    private static final String FIND_ALL = "SELECT * FROM download";
    private static final String CREATE = "INSERT download(Song_id, price, quantity) VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE download SET Song_id=?, price=?, quantity=? WHERE id=?";
    private static final String DELETE = "DELETE FROM download WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM download WHERE id=?";

    private final JdbcTemplate jdbcTemplate;

    public DownloadDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Download> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Download.class));
    }

    @Override
    public Optional<Download> findById(Integer id) {
        Optional<Download> download;
        try {
            download = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Download.class), id));
        } catch (EmptyResultDataAccessException e) {
            download = Optional.empty();
        }
        return download;
    }

    @Override
    public int create(Download download) {
        return jdbcTemplate.update(CREATE, download.getSongId(), download.getPrice(), download.getQuantity());
    }

    @Override
    public int update(Integer id, Download download) {
        return jdbcTemplate.update(UPDATE,  download.getSongId(), download.getPrice(), download.getQuantity(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
