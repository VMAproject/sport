package com.sport.mvc.dao.impl.database;

import com.sport.mvc.dao.PhoneTypeDao;
import com.sport.mvc.dao.impl.database.HibernateAbstractDao;
import com.sport.mvc.models.PhoneType;
import org.springframework.stereotype.Repository;

@Repository(value = "phoneTypeDatabaseDao")
public class PhoneTypeDatabaseDao extends HibernateAbstractDao<PhoneType> implements PhoneTypeDao {

    public PhoneTypeDatabaseDao() {
    }

}
