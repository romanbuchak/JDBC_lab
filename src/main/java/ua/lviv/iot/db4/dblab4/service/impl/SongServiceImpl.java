package ua.lviv.iot.db4.dblab4.service.impl;

import org.springframework.stereotype.Service;
import ua.lviv.iot.db4.dblab4.dao.SongDao;
import ua.lviv.iot.db4.dblab4.domain.Song;
import ua.lviv.iot.db4.dblab4.service.SongService;
import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {
    private final SongDao songDao;

    public SongServiceImpl(SongDao songDao) {
        this.songDao = songDao;
    }

    @Override
    public Optional<Song> findBySongName(String name) {
        return songDao.findBySongName(name);
    }

    @Override
    public List<Song> findAll() {
        return songDao.findAll();
    }

    @Override
    public Optional<Song> findById(Integer id) {
        return songDao.findById(id);
    }

    @Override
    public int create(Song song) {
        return songDao.create(song);
    }

    @Override
    public int update(Integer id, Song song) {
        return songDao.update(id, song);
    }

    @Override
    public int delete(Integer id) {
        return songDao.delete(id);
    }
}
