package com.spring.database.dao.common;

import com.spring.database.domain.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    private final Class<T> entityClass;

    public BaseDaoImpl() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        entityClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }

    @Override
    public void save(T entity) {
        //Close and manage session/transaction do TransactionManager in Spring
        Session session = sessionFactory.getCurrentSession();
        //Transaction transaction = session.beginTransaction();
        session.save(entity);
        //transaction.commit();
        //session.close();

    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        T found = findById(id);
        session.delete(found);
    }

    @Override
    public void update(T entity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(entity);
    }

    @Override
    public List<T> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from " + entityClass.getName())
                .list();
    }

    @Override
    public T findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(entityClass, id);
    }

    protected SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
