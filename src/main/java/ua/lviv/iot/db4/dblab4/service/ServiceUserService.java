package ua.lviv.iot.db4.dblab4.service;

import ua.lviv.iot.db4.dblab4.domain.ServiceUser;

import java.util.Optional;

public interface ServiceUserService extends GeneralService<ServiceUser, Integer>{
    Optional<ServiceUser> findByServiceUserName(String nameOfProfile);
}
