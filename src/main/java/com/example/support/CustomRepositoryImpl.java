package com.example.support;

import com.example.specs.CustomerSpecs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * ${DESCRIPTION}
 * Created by hanqunfeng on 2016/10/23 22:45.
 */


public class CustomRepositoryImpl<T,ID extends Serializable> extends SimpleJpaRepository<T,ID> implements CustomRepository<T,ID> {
    private final EntityManager entityManager;

    public CustomRepositoryImpl(Class<T> domainClass,EntityManager entityManager){
        super(domainClass,entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Page<T> findByAuto(T example, Pageable pageable) {
        return findAll(CustomerSpecs.byAuto(entityManager,example),pageable);
    }
}
