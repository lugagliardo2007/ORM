package org.example;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class Control {
    private static EntityManagerFactory fem = Persistence.createEntityManagerFactory("miUnidad");


    public static void guardar(Object objeto) {
        EntityManager em = fem.createEntityManager();
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
        em.close();
    }


    public static Pou buscarPou(int id) {
        EntityManager em = fem.createEntityManager();
        Pou pou = em.find(Pou.class, id);
        em.close();
        return pou;
    }


    public static List<Alimento> obtenerAlimentos() {
        EntityManager em = fem.createEntityManager();
        List<Alimento> alimentos = em.createQuery("FROM Alimento", Alimento.class).getResultList();
        em.close();
        return alimentos;
    }


    public static void cerrarFactory() {
        if (fem != null && fem.isOpen()) {
            fem.close();
        }
    }
}
