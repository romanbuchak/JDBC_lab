package ua.lviv.iot.db4.dblab4.service;

import ua.lviv.iot.db4.dblab4.domain.MusicalLables;
import java.util.Optional;

public interface MusicalLablesService extends GeneralService<MusicalLables, Integer>{
    Optional<MusicalLables> findByMusicalLablesName(String name);
}
