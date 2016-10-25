package com.example.service;

import com.example.domain.Person;

/**
 * ${DESCRIPTION}
 * Created by hanqunfeng on 2016/10/24 10:36.
 */


public interface PersonService {

    public Person save(Person person);
    public void remove(Long id);
    public Person findone(Person person);
}
