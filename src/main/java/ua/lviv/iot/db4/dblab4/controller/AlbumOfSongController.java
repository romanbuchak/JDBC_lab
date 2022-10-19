package ua.lviv.iot.db4.dblab4.controller;

import ua.lviv.iot.db4.dblab4.domain.AlbumOfSong;

import java.util.Optional;

public interface AlbumOfSongController extends GeneralController<AlbumOfSong, Integer>{
    Optional<AlbumOfSong> findByAlbumName(String name);
}
