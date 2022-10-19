package ua.lviv.iot.db4.dblab4.controller;

import ua.lviv.iot.db4.dblab4.domain.Author;
import java.util.Optional;

public interface AuthorController extends GeneralController<Author, Integer> {
    Optional<Author> findByAuthorName(String name);
    Optional<Author> findByAuthorEmail(String email);
}
