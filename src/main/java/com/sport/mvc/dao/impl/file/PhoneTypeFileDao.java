package com.sport.mvc.dao.impl.file;

import com.sport.mvc.dao.PhoneTypeDao;
import com.sport.mvc.dao.impl.file.FileAbstractDao;
import com.sport.mvc.models.PhoneType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "phoneTypeFileDao")
public class PhoneTypeFileDao extends FileAbstractDao<PhoneType> implements PhoneTypeDao {

    public PhoneTypeFileDao() {
    }

    @Override
    public String getDataSourceName() {
        return null;
    }

    @Override
    public List<PhoneType> getAll() {
        return null;
    }

    @Override
    public PhoneType getById(Long id) {
        return null;
    }


}
