package ua.lviv.iot.db4.dblab4.controller;

import ua.lviv.iot.db4.dblab4.domain.MusicalLables;
import java.util.Optional;

public interface MusicalLablesController extends GeneralController<MusicalLables, Integer>{
    Optional<MusicalLables> findByMusicalLablesName(String name);
}
