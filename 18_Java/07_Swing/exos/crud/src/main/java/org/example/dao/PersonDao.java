package org.example.dao;

import lombok.Data;
import org.example.entity.Person;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

@Data
public class PersonDao {
    public void savePerson(Person person) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(person);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Person saved successfully");
        }
    }

    public List<Person> getAllPersons() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Person", Person.class).list();
        }
    }

    public Person getPersonById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Person.class, id);
        }
    }
}