package com.sport.mvc.services;

import com.sport.mvc.models.Phone;

import java.util.List;

public interface PhoneService {
    List<Phone> getAll();

    void addPhone(Phone phone);
}
