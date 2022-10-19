package ua.lviv.iot.db4.dblab4.service;

import ua.lviv.iot.db4.dblab4.domain.Author;
import java.util.Optional;

public interface AuthorService extends GeneralService<Author, Integer>{
    Optional<Author> findByAuthorName(String name);
    Optional<Author> findByAuthorEmail(String email);
}
