package com.mycompany.pruebatec2.persistencia;


import com.mycompany.pruebatec2.logica.MostrarTurno;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class MostrarTurnoJpaController {

    // Factoría de EntityManager para gestionar la persistencia
    private final EntityManagerFactory emf;

    // Constructor que inicializa la factoría de EntityManager
    public MostrarTurnoJpaController() {
        emf = Persistence.createEntityManagerFactory("galeriaartePU");
    }

    // Método para encontrar todas las entidades MostrarTurno
    public List<MostrarTurno> findMostrarTurnoEntities() {
        try {
            javax.persistence.EntityManager em = getEntityManager();
            try {
                TypedQuery<MostrarTurno> q = em.createQuery("SELECT t FROM MostrarTurno t", MostrarTurno.class);
                return q.getResultList();
            } finally {
                em.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    // Método privado para obtener un EntityManager
    private javax.persistence.EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}