package org.example.dao;

import org.example.util.ConnectionDB;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public abstract class BaseDAO<T> {

    private final Class<T> entityClass;
    private final ConnectionDB connectionDB;

    protected BaseDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
        connectionDB = new ConnectionDB();
    }

    public boolean create(T entity) {
        Transaction transaction = null;
        try (Session session = connectionDB.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            System.out.println(transaction.getStatus());
            session.merge(entity);
            transaction.commit();
            System.out.println(entityClass.getSimpleName() + " created successfully");
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                System.out.println(transaction.getStatus());
                transaction.rollback();
            }
            System.out.println(e.getMessage());
            return false;
        }
    }

    public T read(Long id) {
        try (Session session = connectionDB.getSessionFactory().openSession()) {
            return session.get(entityClass, id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean update(T entity) {
        Transaction transaction = null;
        try (Session session = connectionDB.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
            System.out.println(entityClass.getSimpleName() + " updated successfully");
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean delete(Long id) {
        Transaction transaction = null;
        try (Session session = connectionDB.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            T entity = session.get(entityClass, id);
            if (entity != null) {
                session.remove(entity);
                transaction.commit();
                System.out.println(entityClass.getSimpleName() + " deleted successfully");
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<T> findAll() {
        try (Session session = connectionDB.getSessionFactory().openSession()) {
            return session.createQuery("from " + entityClass.getSimpleName(), entityClass).list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}