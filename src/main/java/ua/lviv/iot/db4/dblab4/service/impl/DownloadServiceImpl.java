package ua.lviv.iot.db4.dblab4.service.impl;

import org.springframework.stereotype.Service;
import ua.lviv.iot.db4.dblab4.dao.DownloadDao;
import ua.lviv.iot.db4.dblab4.domain.Download;
import ua.lviv.iot.db4.dblab4.service.DownloadService;
import java.util.List;
import java.util.Optional;

@Service
public class DownloadServiceImpl implements DownloadService {
    private final DownloadDao downloadDao;

    public DownloadServiceImpl(DownloadDao downloadDao) {
        this.downloadDao = downloadDao;
    }

    @Override
    public List<Download> findAll() {
        return downloadDao.findAll();
    }

    @Override
    public Optional<Download> findById(Integer id) {
        return downloadDao.findById(id);
    }

    @Override
    public int create(Download download) {
        return downloadDao.create(download);
    }

    @Override
    public int update(Integer id, Download download) {
        return downloadDao.update(id, download);
    }

    @Override
    public int delete(Integer id) {
        return downloadDao.delete(id);
    }
}
