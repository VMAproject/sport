package com.sport.mvc.dao.impl.file;

import com.sport.mvc.dao.PhoneDao;
import com.sport.mvc.dao.impl.file.FileAbstractDao;
import com.sport.mvc.models.Phone;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "phoneFileDao")
public class PhoneFileDao extends FileAbstractDao<Phone> implements PhoneDao {

    public PhoneFileDao() {
    }

    @Override
    public String getDataSourceName() {
        return null;
    }

    @Override
    public List<Phone> getAll() {
        return null;
    }

    @Override
    public Phone getById(Long id) {
        return null;
    }


}
