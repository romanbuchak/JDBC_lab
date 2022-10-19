package ua.lviv.iot.db4.dblab4.dao.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ua.lviv.iot.db4.dblab4.dao.ServiceUserDao;
import ua.lviv.iot.db4.dblab4.domain.ServiceUser;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("SqlResolve")
@Service
public class ServiceUserDaoImpl implements ServiceUserDao {
    private static final String FIND_ALL = "SELECT * FROM service_user";
    private static final String CREATE = "INSERT service_user(name_of_profile, Download_id) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE service_user SET name_of_profile=?, Download_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM service_user WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM service_user WHERE id=?";
    private static final String FIND_BY_SERVICE_USER_NAME = "SELECT * FROM service_user WHERE name_of_profile=?";

    private final JdbcTemplate jdbcTemplate;

    public ServiceUserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<ServiceUser> findByServiceUserName(String nameOfProfile) {
        Optional<ServiceUser> serviceUser;
        try {
            serviceUser = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_SERVICE_USER_NAME,
                    BeanPropertyRowMapper.newInstance(ServiceUser.class), nameOfProfile));
        } catch (EmptyResultDataAccessException e) {
            serviceUser = Optional.empty();
        }
        return serviceUser;
    }

    @Override
    public List<ServiceUser> findAll() {
        return jdbcTemplate.query(FIND_ALL, BeanPropertyRowMapper.newInstance(ServiceUser.class));
    }

    @Override
    public Optional<ServiceUser> findById(Integer id) {
        Optional<ServiceUser> serviceUser;
        try {
            serviceUser = Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID,
                    BeanPropertyRowMapper.newInstance(ServiceUser.class), id));
        } catch (EmptyResultDataAccessException e) {
            serviceUser = Optional.empty();
        }
        return serviceUser;
    }

    @Override
    public int create(ServiceUser serviceUser) {
        return jdbcTemplate.update(CREATE, serviceUser.getNameOfProfile());
    }

    @Override
    public int update(Integer id, ServiceUser serviceUser) {
        return jdbcTemplate.update(UPDATE, serviceUser.getNameOfProfile(), id);
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update(DELETE, id);
    }
}
