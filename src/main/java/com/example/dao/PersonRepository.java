package com.example.dao;

import com.example.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * ${DESCRIPTION}
 * Created by hanqunfeng on 2016/10/23 21:06.
 */


public interface PersonRepository extends JpaRepository<Person,Long> {

    List<Person> findByAddress(String address);

    Person findByNameAndAddress(String name,String address);

    @Query("select p from Person p where p.name = :name and p.address = :address")
    Person withNameAndAddressQuery(@Param("name")String name,@Param("address")String address);


    Person withNameAndAddressNameQuery(String name,String address);
}
