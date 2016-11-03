package com.sport.mvc.dao.impl.database;

import com.sport.mvc.dao.RoleDao;
import com.sport.mvc.dao.impl.database.HibernateAbstractDao;
import com.sport.mvc.models.Role;
import org.springframework.stereotype.Repository;

@Repository(value = "roleDatabaseDao")
public class RoleDatabaseDao extends HibernateAbstractDao<Role> implements RoleDao {

    public RoleDatabaseDao() {
    }

}
