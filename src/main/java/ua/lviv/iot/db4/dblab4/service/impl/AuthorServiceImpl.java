package ua.lviv.iot.db4.dblab4.service.impl;

import org.springframework.stereotype.Service;
import ua.lviv.iot.db4.dblab4.dao.AuthorDao;
import ua.lviv.iot.db4.dblab4.domain.Author;
import ua.lviv.iot.db4.dblab4.service.AuthorService;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorDao authorDao;

    public AuthorServiceImpl(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public Optional<Author> findByAuthorName(String name) {
        return authorDao.findByAuthorName(name);
    }

    @Override
    public Optional<Author> findByAuthorEmail(String email) {
        return authorDao.findByAuthorEmail(email);
    }

    @Override
    public List<Author> findAll() {
        return authorDao.findAll();
    }

    @Override
    public Optional<Author> findById(Integer id) {
        return authorDao.findById(id);
    }

    @Override
    public int create(Author author) {
        return authorDao.create(author);
    }

    @Override
    public int update(Integer id, Author author) {
        return authorDao.update(id, author);
    }

    @Override
    public int delete(Integer id) {
        return authorDao.delete(id);
    }
}
