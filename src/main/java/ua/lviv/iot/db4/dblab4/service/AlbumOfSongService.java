package ua.lviv.iot.db4.dblab4.service;

import ua.lviv.iot.db4.dblab4.domain.AlbumOfSong;
import java.util.Optional;

public interface AlbumOfSongService extends GeneralService<AlbumOfSong, Integer>{
    Optional<AlbumOfSong> findByAlbumName(String name);
}
