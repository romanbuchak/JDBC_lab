package ua.lviv.iot.db4.dblab4.dao;

import ua.lviv.iot.db4.dblab4.domain.Author;
import java.util.Optional;

public interface AuthorDao extends GeneralDao<Author, Integer>{
    Optional<Author> findByAuthorName(String name);
    Optional<Author> findByAuthorEmail(String email);
}
