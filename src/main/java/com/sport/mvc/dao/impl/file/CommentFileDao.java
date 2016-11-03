package com.sport.mvc.dao.impl.file;

import com.sport.mvc.dao.CommentDao;
import com.sport.mvc.models.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "commentFileDao")
public class CommentFileDao extends FileAbstractDao<Comment> implements CommentDao {

    public CommentFileDao() {
    }

    @Override
    public String getDataSourceName() {
        return null;
    }

    @Override
    public List<Comment> getAll() {
        return null;
    }

    @Override
    public Comment getById(Long id) {
        return null;
    }


}
