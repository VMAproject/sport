package com.sport.mvc.dao.impl.database;

import com.sport.mvc.dao.GroupDao;
import com.sport.mvc.models.Group;
import org.springframework.stereotype.Repository;

@Repository(value = "groupDatabaseDao")
public class GroupDatabaseDao extends HibernateAbstractDao<Group> implements GroupDao {


    public GroupDatabaseDao() {
    }


}
