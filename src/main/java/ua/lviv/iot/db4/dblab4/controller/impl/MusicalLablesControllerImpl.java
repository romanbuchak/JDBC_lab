package ua.lviv.iot.db4.dblab4.controller.impl;

import org.springframework.stereotype.Service;
import ua.lviv.iot.db4.dblab4.controller.MusicalLablesController;
import ua.lviv.iot.db4.dblab4.domain.AlbumOfSong;
import ua.lviv.iot.db4.dblab4.domain.MusicalLables;
import ua.lviv.iot.db4.dblab4.service.AlbumOfSongService;
import ua.lviv.iot.db4.dblab4.service.MusicalLablesService;

import java.util.List;
import java.util.Optional;

@Service
public class MusicalLablesControllerImpl implements MusicalLablesController {
    private final MusicalLablesService musicalLablesService;

    public MusicalLablesControllerImpl(MusicalLablesService musicalLablesService) {
        this.musicalLablesService = musicalLablesService;
    }

    @Override
    public Optional<MusicalLables> findByMusicalLablesName(String name) {
        return musicalLablesService.findByMusicalLablesName(name);
    }

    @Override
    public List<MusicalLables> findAll() {
        return musicalLablesService.findAll();
    }

    @Override
    public Optional<MusicalLables> findById(Integer id) {
        return musicalLablesService.findById(id);
    }

    @Override
    public int create(MusicalLables musicalLables) {
        return musicalLablesService.create(musicalLables);
    }

    @Override
    public int update(Integer id, MusicalLables musicalLables) {
        return musicalLablesService.update(id, musicalLables);
    }

    @Override
    public int delete(Integer id) {
        return musicalLablesService.delete(id);
    }
}
