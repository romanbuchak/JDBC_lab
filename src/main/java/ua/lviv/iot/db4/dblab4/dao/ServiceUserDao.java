package ua.lviv.iot.db4.dblab4.dao;

import ua.lviv.iot.db4.dblab4.domain.ServiceUser;
import java.util.Optional;

public interface ServiceUserDao extends GeneralDao<ServiceUser, Integer>{
    Optional<ServiceUser> findByServiceUserName(String nameOfProfile);
}
