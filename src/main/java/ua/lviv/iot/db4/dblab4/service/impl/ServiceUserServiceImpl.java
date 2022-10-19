package ua.lviv.iot.db4.dblab4.service.impl;

import org.springframework.stereotype.Service;
import ua.lviv.iot.db4.dblab4.dao.ServiceUserDao;
import ua.lviv.iot.db4.dblab4.domain.ServiceUser;
import ua.lviv.iot.db4.dblab4.service.ServiceUserService;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceUserServiceImpl implements ServiceUserService {
    private final ServiceUserDao serviceUserDao;

    public ServiceUserServiceImpl(ServiceUserDao serviceUserDao) {
        this.serviceUserDao = serviceUserDao;
    }

    @Override
    public Optional<ServiceUser> findByServiceUserName(String name) {
        return serviceUserDao.findByServiceUserName(name);
    }

    @Override
    public List<ServiceUser> findAll() {
        return serviceUserDao.findAll();
    }

    @Override
    public Optional<ServiceUser> findById(Integer id) {
        return serviceUserDao.findById(id);
    }

    @Override
    public int create(ServiceUser serviceUser) {
        return serviceUserDao.create(serviceUser);
    }

    @Override
    public int update(Integer id, ServiceUser serviceUser) {
        return serviceUserDao.update(id, serviceUser);
    }

    @Override
    public int delete(Integer id) {
        return serviceUserDao.delete(id);
    }
}
