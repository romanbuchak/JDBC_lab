package ua.lviv.iot.db4.dblab4.dao;

import ua.lviv.iot.db4.dblab4.domain.Song;
import java.util.Optional;

public interface SongDao extends GeneralDao<Song, Integer>{
    Optional<Song> findBySongName(String name);
}
