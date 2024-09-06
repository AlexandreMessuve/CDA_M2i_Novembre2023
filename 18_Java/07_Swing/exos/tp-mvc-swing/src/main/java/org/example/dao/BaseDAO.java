package org.example.dao;

import org.example.util.ConnectionDB;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public abstract class BaseDAO<T> extends ConnectionDB {

    private final Class<T> entityClass;

    protected BaseDAO(Class<T> entityClass) {
        super();
        this.entityClass = entityClass;
    }

    public boolean create(T entity) {
        Transaction transaction = null;
        session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            System.out.println(transaction.getStatus());
            session.merge(entity);
            transaction.commit();
            System.out.println(entityClass.getSimpleName() + " created successfully");
            session.close();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                System.out.println(transaction.getStatus());
                transaction.rollback();
                session.close();
            }
            System.out.println(e.getMessage());
            return false;
        }
    }

    public T read(Long id) {
        session = sessionFactory.openSession();
        try {
            T entity = session.get(entityClass, id);
            session.close();
            return entity;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.close();
            return null;
        }
    }

    public boolean update(T entity) {
        Transaction transaction = null;
        session = sessionFactory.openSession();
        try {
            transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
            System.out.println(entityClass.getSimpleName() + " updated successfully");
            session.close();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                session.close();
            }
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean delete(Long id) {
        Transaction transaction = null;
        session = sessionFactory.openSession();
        try{
            transaction = session.beginTransaction();
            T entity = session.get(entityClass, id);
            if (entity != null) {
                session.remove(entity);
                transaction.commit();
                System.out.println(entityClass.getSimpleName() + " deleted successfully");
                session.close();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                session.close();
            }
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<T> findAll() {
        session = sessionFactory.openSession();
        try{
            List<T> list = session.createQuery("from " + entityClass.getSimpleName(), entityClass).list();
            session.close();
            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.close();
            return null;
        }
    }
}