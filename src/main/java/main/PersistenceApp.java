package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.example.*;

public class PersistenceApp {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();

            Cliente cliente = new Cliente("Tomás","Camacho", 45719267);
            em.persist(cliente);
            em.flush();
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
        }

        em.close();
        emf.close();

    }
}
