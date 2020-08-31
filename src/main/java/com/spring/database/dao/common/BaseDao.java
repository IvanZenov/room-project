package com.spring.database.dao.common;

import com.spring.database.domain.BaseEntity;

import java.util.List;

public interface BaseDao<T extends BaseEntity> {

    void save(T entity);

    void delete(Long id);

    void update(T entity);

    List<T> findAll();

    T findById(Long id);

}
