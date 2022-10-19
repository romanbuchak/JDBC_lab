package ua.lviv.iot.db4.dblab4.controller.impl;

import org.springframework.stereotype.Service;
import ua.lviv.iot.db4.dblab4.controller.AuthorController;
import ua.lviv.iot.db4.dblab4.domain.Author;
import ua.lviv.iot.db4.dblab4.service.AuthorService;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorControllerImpl implements AuthorController {
    private final AuthorService authorService;

    public AuthorControllerImpl(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Override
    public Optional<Author> findByAuthorName(String name) {
        return authorService.findByAuthorName(name);
    }

    @Override
    public Optional<Author> findByAuthorEmail(String email) {
        return authorService.findByAuthorEmail(email);
    }

    @Override
    public List<Author> findAll() {
        return authorService.findAll();
    }

    @Override
    public Optional<Author> findById(Integer id) {
        return authorService.findById(id);
    }

    @Override
    public int create(Author author) {
        return authorService.create(author);
    }

    @Override
    public int update(Integer id, Author author) {
        return authorService.update(id, author);
    }

    @Override
    public int delete(Integer id) {
        return authorService.delete(id);
    }
}
