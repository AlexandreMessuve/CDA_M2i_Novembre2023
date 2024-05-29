import Entity.Electronic;
import Entity.Food;
import Entity.Housing;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Product_JPA");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();


        //Creation des entités
//        Food food = Food.builder().name("Sausage").price(20.30).expiryDate(LocalDate.now()).build();
//        em.persist(food);
//
//        Electronic electronic = Electronic.builder().name("Smartphone").price(299.99).batteryDuration(500).build();
//        em.persist(electronic);
//
//        Housing housing = Housing.builder().name("Villa").price(300000.99).height(5000).width(10000).build();
//        em.persist(housing);
//
//        em.getTransaction().commit();

        Query fQuery = em.createQuery("select f from Food f");
        Query eQuery = em.createQuery("select e from Electronic e");
        Query housingQuery = em.createQuery("select h from Housing h");
        List foods = fQuery.getResultList();
        List electronics = eQuery.getResultList();
        List housings = housingQuery.getResultList();

        System.out.println("Foods: " + foods);
        System.out.println("Electronics: " + electronics);
        System.out.println("Housing: " + housings);
        em.close();
        emf.close();
    }
}