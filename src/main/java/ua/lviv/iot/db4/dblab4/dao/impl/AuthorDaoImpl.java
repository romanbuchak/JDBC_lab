package ua.lviv.iot.db4.dblab4.dao.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ua.lviv.iot.db4.dblab4.dao.AuthorDao;
import ua.lviv.iot.db4.dblab4.domain.Author;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class AuthorDaoImpl implements AuthorDao {
    private static final String FIND_ALL = "SELECT * FROM author";
    private static final String CREATE = "INSERT author(name, surname, gender, email, Song_id) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE author SET name=?, surname=?, gender=?, email=?, Song_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM author WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM author WHERE id=?";
    private static final String FIND_BY_AUTHOR_NAME = "SELECT * FROM author WHERE name=?";
    private static final String FIND_BY_AUTHOR_EMAIL = "SELECT * FROM author WHERE email=?";

    private final JdbcTemplate jdbcTemplate;

    public AuthorDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Author> findByAuthorName(String name) {
        Optional<Author> author;
        try {
            author = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_AUTHOR_NAME,
                    BeanPropertyRowMapper.newInstance(Author.class), name));
        } catch (EmptyResultDataAccessException e) {
            author = Optional.empty();
        }
        return author;
    }

    @Override
    public Optional<Author> findByAuthorEmail(String email) {
        Optional<Author> author;
        try {
            author = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_AUTHOR_EMAIL,
                    BeanPropertyRowMapper.newInstance(Author.class), email));
        } catch (EmptyResultDataAccessException e) {
            author = Optional.empty();
        }
        return author;
    }

    @Override
    public List<Author> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(Author.class));
    }

    @Override
    public Optional<Author> findById(Integer id) {
        Optional<Author> author;
        try {
            author = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(Author.class), id));
        } catch (EmptyResultDataAccessException e) {
            author = Optional.empty();
        }
        return author;
    }

    @Override
    public int create(Author author) {
        return jdbcTemplate.update(CREATE, author.getName(), author.getEmail(), author.getSongId(), author.getSurname(),
                author.getGender());
    }

    @Override
    public int update(Integer id, Author author) {
        return jdbcTemplate.update(UPDATE, author.getName(), author.getEmail(), author.getSongId(), author.getSurname(),
                author.getGender(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
