package ua.lviv.iot.db4.dblab4.controller.impl;


import org.springframework.stereotype.Service;
import ua.lviv.iot.db4.dblab4.controller.AlbumOfSongController;
import ua.lviv.iot.db4.dblab4.domain.AlbumOfSong;
import ua.lviv.iot.db4.dblab4.service.AlbumOfSongService;
import java.util.List;
import java.util.Optional;

@Service
public class AlbumOfSongControllerImpl implements AlbumOfSongController {
    private final AlbumOfSongService albumOfSongService;

    public AlbumOfSongControllerImpl(AlbumOfSongService albumOfSongService) {
        this.albumOfSongService = albumOfSongService;
    }

    @Override
    public Optional<AlbumOfSong> findByAlbumName(String name) {
        return albumOfSongService.findByAlbumName(name);
    }

    @Override
    public List<AlbumOfSong> findAll() {
        return albumOfSongService.findAll();
    }

    @Override
    public Optional<AlbumOfSong> findById(Integer id) {
        return albumOfSongService.findById(id);
    }

    @Override
    public int create(AlbumOfSong albumOfSong) {
        return albumOfSongService.create(albumOfSong);
    }

    @Override
    public int update(Integer id, AlbumOfSong albumOfSong) {
        return albumOfSongService.update(id, albumOfSong);
    }

    @Override
    public int delete(Integer id) {
        return albumOfSongService.delete(id);
    }
}
