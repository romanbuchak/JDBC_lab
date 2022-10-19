package ua.lviv.iot.db4.dblab4.dao;

import ua.lviv.iot.db4.dblab4.domain.AlbumOfSong;
import java.util.Optional;

public interface AlbumOfSongDao extends GeneralDao<AlbumOfSong, Integer>{
    Optional<AlbumOfSong> findByAlbumName(String name);
}
