package ua.lviv.iot.db4.dblab4.controller.impl;

import org.springframework.stereotype.Service;
import ua.lviv.iot.db4.dblab4.controller.DownloadController;
import ua.lviv.iot.db4.dblab4.domain.Download;
import ua.lviv.iot.db4.dblab4.service.DownloadService;
import java.util.List;
import java.util.Optional;

@Service
public class DownloadControllerImpl implements DownloadController {
    private final DownloadService downloadService;

    public DownloadControllerImpl(DownloadService downloadService) {
        this.downloadService = downloadService;
    }
    
    @Override
    public List<Download> findAll() {
        return downloadService.findAll();
    }

    @Override
    public Optional<Download> findById(Integer id) {
        return downloadService.findById(id);
    }

    @Override
    public int create(Download download) {
        return downloadService.create(download);
    }

    @Override
    public int update(Integer id, Download download) {
        return downloadService.update(id, download);
    }

    @Override
    public int delete(Integer id) {
        return downloadService.delete(id);
    }
}
