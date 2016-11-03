package com.sport.mvc.dao.impl.database;

import com.sport.mvc.dao.CommentDao;
import com.sport.mvc.models.Comment;
import org.springframework.stereotype.Repository;

@Repository(value = "commentDatabaseDao")
public class CommentDatabaseDao extends HibernateAbstractDao<Comment> implements CommentDao {

    public CommentDatabaseDao() {
    }

}

