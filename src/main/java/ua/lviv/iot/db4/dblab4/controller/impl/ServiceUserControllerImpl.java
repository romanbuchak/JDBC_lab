package ua.lviv.iot.db4.dblab4.controller.impl;

import org.springframework.stereotype.Service;
import ua.lviv.iot.db4.dblab4.controller.ServiceUserController;
import ua.lviv.iot.db4.dblab4.domain.ServiceUser;
import ua.lviv.iot.db4.dblab4.service.ServiceUserService;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceUserControllerImpl implements ServiceUserController {
    private final ServiceUserService serviceUserService;

    public ServiceUserControllerImpl(ServiceUserService serviceUserService) {
        this.serviceUserService = serviceUserService;
    }

    @Override
    public Optional<ServiceUser> findByServiceUserName(String name) {
        return serviceUserService.findByServiceUserName(name);
    }

    @Override
    public List<ServiceUser> findAll() {
        return serviceUserService.findAll();
    }

    @Override
    public Optional<ServiceUser> findById(Integer id) {
        return serviceUserService.findById(id);
    }

    @Override
    public int create(ServiceUser serviceUser) {
        return serviceUserService.create(serviceUser);
    }

    @Override
    public int update(Integer id, ServiceUser serviceUser) {
        return serviceUserService.update(id, serviceUser);
    }

    @Override
    public int delete(Integer id) {
        return serviceUserService.delete(id);
    }
}
