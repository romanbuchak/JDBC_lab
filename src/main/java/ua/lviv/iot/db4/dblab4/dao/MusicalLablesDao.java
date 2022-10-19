package ua.lviv.iot.db4.dblab4.dao;

import ua.lviv.iot.db4.dblab4.domain.MusicalLables;
import java.util.Optional;

public interface MusicalLablesDao extends GeneralDao<MusicalLables, Integer>{
    Optional<MusicalLables> findByMusicalLablesName(String name);
}
