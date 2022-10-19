package ua.lviv.iot.db4.dblab4.service;

import ua.lviv.iot.db4.dblab4.domain.Song;
import java.util.Optional;

public interface SongService extends GeneralService<Song, Integer> {
    Optional<Song> findBySongName(String name);
}
