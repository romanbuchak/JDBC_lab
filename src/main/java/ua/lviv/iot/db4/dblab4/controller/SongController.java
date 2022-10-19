package ua.lviv.iot.db4.dblab4.controller;

import ua.lviv.iot.db4.dblab4.domain.Song;
import java.util.Optional;

public interface SongController extends GeneralController<Song, Integer>{
    Optional<Song> findBySongName(String name);
}
