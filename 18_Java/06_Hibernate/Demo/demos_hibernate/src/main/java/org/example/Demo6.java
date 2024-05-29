package org.example;

import org.example.entities.Entreprise;
import org.example.entities.Personne;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class Demo6 {

    public static void main(String[] args) {
        StandardServiceRegistry registre = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();


        Transaction transaction = session.getTransaction();
        transaction.begin();

        // Création d'entreprise
        Entreprise entreprise = new Entreprise();
        entreprise.setNom("utopios");
        session.save(entreprise);

        Personne personne = new Personne();
        personne.setNom("Toto");
        personne.setPrenom("Titi");
        personne.setAge(35);
        personne.setEntreprise(entreprise);

        session.save(personne);

        transaction.commit();

        // Recuperation des personnes
        Query<Personne> personneQuery = session.createQuery("from Personne ");
        List<Personne> personnes = personneQuery.list();
        for (Personne p: personnes) {
            Entreprise e = p.getEntreprise();
            if(e != null){
                System.out.println(e.getNom());
            }
        }

        session.close();
        sessionFactory.close();


    }
}
