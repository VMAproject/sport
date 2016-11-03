package com.sport.mvc.dao.impl.database;

import com.sport.mvc.dao.UserDao;
import com.sport.mvc.dao.impl.database.HibernateAbstractDao;
import com.sport.mvc.models.User;
import org.springframework.stereotype.Repository;

@Repository(value = "userDatabaseDao")
public class UserDatabaseDao extends HibernateAbstractDao<User> implements UserDao {

    public UserDatabaseDao() {
    }

}
