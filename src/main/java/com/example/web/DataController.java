package com.example.web;

import com.example.dao.NewPersonRepository;
import com.example.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${DESCRIPTION}
 * Created by hanqunfeng on 2016/10/23 23:05.
 */

@RestController
public class DataController {

    @Autowired
    NewPersonRepository newPersonRepository;

    @RequestMapping("/auto")
    public Page<Person> auto(Person person){
        Page<Person> personPage = newPersonRepository.findByAuto(person,new PageRequest(0,10));
        return personPage;
    }
}
