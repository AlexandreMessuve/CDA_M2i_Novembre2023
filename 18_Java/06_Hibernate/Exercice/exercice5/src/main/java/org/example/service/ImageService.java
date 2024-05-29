package org.example.service;

import org.example.entity.Image;
import org.example.interfaces.Repository;

import java.util.List;

public class ImageService extends BaseService implements Repository<Image> {
    public ImageService() {
        super();
    }
    @Override
    public boolean create(Image image) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(image);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Image image) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(image);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Image image) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(image);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Image findById(int id) {
        session = sessionFactory.openSession();
        Image image = session.get(Image.class, id);
        session.close();
        return image;
    }

    @Override
    public List<Image> findAll() {
        session = sessionFactory.openSession();
        List<Image> images = session.createQuery("from Image").list();
        session.close();
        return images;
    }
}
