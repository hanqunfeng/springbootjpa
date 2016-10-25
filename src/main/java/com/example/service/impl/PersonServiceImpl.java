package com.example.service.impl;

import com.example.dao.PersonRepository;
import com.example.domain.Person;
import com.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * ${DESCRIPTION}
 * Created by hanqunfeng on 2016/10/24 10:38.
 */

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    @CachePut(value = "person", key = "#person.id")
    public Person save(Person person) {
        Person p = personRepository.save(person);
        System.out.println("为id_ker为：" + p.getId() + "数据做了缓存");
        return p;
    }

    @Override
    @CacheEvict(value = "person", key = "#id")
    public void remove(Long id) {
        System.out.println("删除了id为：" + id + "的数据缓存");
        personRepository.delete(id);
    }

    @Override
    @Cacheable(value = "person", key = "#person.id")
    public Person findone(Person person) {
        Person p = personRepository.findOne(person.getId());
        System.out.println("为id_key为：" + person.getId() + "的数据做了缓存");
        return p;
    }
}
