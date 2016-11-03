package com.sport.mvc.services.impl;

import com.sport.mvc.dao.PhoneDao;
import com.sport.mvc.models.Phone;
import com.sport.mvc.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "phoneService")
public class PhoneServiceImpl implements PhoneService {

    @Qualifier("phoneDatabaseDao")
    @Autowired
    private PhoneDao phoneDao;

    public PhoneServiceImpl() {
    }

    @Transactional
    @Override
    public List<Phone> getAll() {
        return phoneDao.getAll();
    }

    @Transactional
    @Override
    public void addPhone(Phone phone) {

    }
}
