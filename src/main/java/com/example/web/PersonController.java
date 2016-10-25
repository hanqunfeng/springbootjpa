package com.example.web;

import com.example.dao.PersonRepository;
import com.example.domain.Person;
import com.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ${DESCRIPTION}
 * Created by hanqunfeng on 2016/10/23 21:15.
 */

@RestController
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonService personService;

    @RequestMapping("/save")
    public Person save(String name,String address,Integer age){
        Person p = personRepository.save(new Person(null,name,age,address));
        return p;
    }

    @RequestMapping("/q1")
    public List<Person> q1(String address){
        List<Person> list = personRepository.findByAddress(address);
        return list;
    }

    @RequestMapping("/q2")
    public Person q2(String name,String address){
        Person p = personRepository.findByNameAndAddress(name,address);
        return p;
    }
    @RequestMapping("/q3")
    public Person q3(String name,String address){
        Person p = personRepository.withNameAndAddressQuery(name,address);
        return p;
    }
    @RequestMapping("/q4")
    public Person q4(String name,String address){
        Person p = personRepository.withNameAndAddressNameQuery(name,address);
        return p;
    }

    @RequestMapping("/sort")
    public List<Person> sort(){
        List<Person> list = personRepository.findAll(new Sort(Sort.Direction.ASC,"age"));
        return list;
    }

    @RequestMapping("/page")
    public Page<Person> page(){
        Page<Person> pageList = personRepository.findAll(new PageRequest(1,2));
        return pageList;
    }


    @RequestMapping("/put")
    public Person put(Person person){
        return personService.save(person);
    }

    @RequestMapping("/able")
    public Person cacheable(Person person){
        return personService.findone(person);
    }

    @RequestMapping("/evit")
    public String evit(Long id){
        personService.remove(id);
        return "OK";
    }
}
