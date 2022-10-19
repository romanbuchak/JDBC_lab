package ua.lviv.iot.db4.dblab4.controller;

import ua.lviv.iot.db4.dblab4.domain.ServiceUser;
import java.util.Optional;

public interface ServiceUserController extends GeneralController<ServiceUser, Integer>{
    Optional<ServiceUser> findByServiceUserName(String nameOfProfile);
}
