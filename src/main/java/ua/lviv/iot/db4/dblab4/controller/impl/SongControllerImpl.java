package ua.lviv.iot.db4.dblab4.controller.impl;

import org.springframework.stereotype.Service;
import ua.lviv.iot.db4.dblab4.controller.SongController;
import ua.lviv.iot.db4.dblab4.domain.AlbumOfSong;
import ua.lviv.iot.db4.dblab4.domain.Song;
import ua.lviv.iot.db4.dblab4.service.AlbumOfSongService;
import ua.lviv.iot.db4.dblab4.service.SongService;

import java.util.List;
import java.util.Optional;

@Service
public class SongControllerImpl implements SongController {
    private final SongService songService;

    public SongControllerImpl(SongService songService) {
        this.songService = songService;
    }

    @Override
    public Optional<Song> findBySongName(String name) {
        return songService.findBySongName(name);
    }

    @Override
    public List<Song> findAll() {
        return songService.findAll();
    }

    @Override
    public Optional<Song> findById(Integer id) {
        return songService.findById(id);
    }

    @Override
    public int create(Song song) {
        return songService.create(song);
    }

    @Override
    public int update(Integer id, Song song) {
        return songService.update(id, song);
    }

    @Override
    public int delete(Integer id) {
        return songService.delete(id);
    }
}
