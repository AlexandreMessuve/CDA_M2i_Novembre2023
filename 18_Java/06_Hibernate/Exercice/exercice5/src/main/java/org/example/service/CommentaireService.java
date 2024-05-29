package org.example.service;

import org.example.entity.Commentaire;
import org.example.interfaces.Repository;

import java.util.List;

public class CommentaireService extends BaseService implements Repository<Commentaire> {
    public CommentaireService() {
        super();
    }
    @Override
    public boolean create(Commentaire commentaire) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(commentaire);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Commentaire commentaire) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(commentaire);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Commentaire commentaire) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(commentaire);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Commentaire findById(int id) {
        session = sessionFactory.openSession();
        Commentaire commentaire = session.get(Commentaire.class, id);
        session.close();
        return commentaire;

    }

    @Override
    public List<Commentaire> findAll() {
        session = sessionFactory.openSession();
        List<Commentaire> commentaires = session.createQuery("from Commentaire").list();
        session.close();
        return commentaires;
    }
}
