package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.example.*;

import java.util.List;

public class PersistenceApp {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Cliente cliente = new Cliente("Tomás", "Camacho", 45719267);
            Domicilio domicilio = new Domicilio("Tucuman", 76);

            cliente.setDomicilio(domicilio);
            domicilio.setCliente(cliente);

            em.persist(cliente);

            Domicilio dom = em.find(Domicilio.class, 1L);
            Cliente cli = em.find(Cliente.class, 1L);

            System.out.println("Cliente de domicilio: " + dom.getCliente().getDni());
            System.out.println("Domicilio de cliente: " + cli.getDomicilio().getNombreCalle());

            em.flush();
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
        }

        em.close();
        emf.close();

    }
}
