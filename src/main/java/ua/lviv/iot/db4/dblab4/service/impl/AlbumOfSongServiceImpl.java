package ua.lviv.iot.db4.dblab4.service.impl;

import org.springframework.stereotype.Service;
import ua.lviv.iot.db4.dblab4.dao.AlbumOfSongDao;
import ua.lviv.iot.db4.dblab4.domain.AlbumOfSong;
import ua.lviv.iot.db4.dblab4.service.AlbumOfSongService;
import java.util.List;
import java.util.Optional;

@Service
public class AlbumOfSongServiceImpl implements AlbumOfSongService {
    private final AlbumOfSongDao albumOfSongDao;

    public AlbumOfSongServiceImpl(AlbumOfSongDao albumOfSongDao) {
        this.albumOfSongDao = albumOfSongDao;
    }

    @Override
    public Optional<AlbumOfSong> findByAlbumName(String name) {
        return albumOfSongDao.findByAlbumName(name);
    }

    @Override
    public List<AlbumOfSong> findAll() {
        return albumOfSongDao.findAll();
    }

    @Override
    public Optional<AlbumOfSong> findById(Integer id) {
        return albumOfSongDao.findById(id);
    }

    @Override
    public int create(AlbumOfSong albumOfSong) {
        return albumOfSongDao.create(albumOfSong);
    }

    @Override
    public int update(Integer id, AlbumOfSong albumOfSong) {
        return albumOfSongDao.update(id, albumOfSong);
    }

    @Override
    public int delete(Integer id) {
        return albumOfSongDao.delete(id);
    }
}
