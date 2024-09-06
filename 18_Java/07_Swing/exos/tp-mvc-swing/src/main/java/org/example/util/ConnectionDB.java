package org.example.util;

import lombok.Data;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

@Data
public class ConnectionDB {
    private StandardServiceRegistry registre;

    private SessionFactory sessionFactory;

    public ConnectionDB(){
        registre = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();
    }

    public void close() {
        StandardServiceRegistryBuilder.destroy(registre);
    }
}
