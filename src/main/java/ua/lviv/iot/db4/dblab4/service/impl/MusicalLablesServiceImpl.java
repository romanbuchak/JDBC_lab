package ua.lviv.iot.db4.dblab4.service.impl;

import org.springframework.stereotype.Service;
import ua.lviv.iot.db4.dblab4.dao.MusicalLablesDao;
import ua.lviv.iot.db4.dblab4.domain.MusicalLables;
import ua.lviv.iot.db4.dblab4.service.MusicalLablesService;

import java.util.List;
import java.util.Optional;

@Service
public class MusicalLablesServiceImpl implements MusicalLablesService {
    private final MusicalLablesDao musicalLablesDao;

    public MusicalLablesServiceImpl(MusicalLablesDao musicalLablesDao) {
        this.musicalLablesDao = musicalLablesDao;
    }

    @Override
    public Optional<MusicalLables> findByMusicalLablesName(String name) {
        return musicalLablesDao.findByMusicalLablesName(name);
    }

    @Override
    public List<MusicalLables> findAll() {
        return musicalLablesDao.findAll();
    }

    @Override
    public Optional<MusicalLables> findById(Integer id) {
        return musicalLablesDao.findById(id);
    }

    @Override
    public int create(MusicalLables musicalLables) {
        return musicalLablesDao.create(musicalLables);
    }

    @Override
    public int update(Integer id, MusicalLables musicalLables) {
        return musicalLablesDao.update(id, musicalLables);
    }

    @Override
    public int delete(Integer id) {
        return musicalLablesDao.delete(id);
    }

}
