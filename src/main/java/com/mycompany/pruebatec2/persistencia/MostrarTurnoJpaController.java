package com.mycompany.pruebatec2.persistencia;


import com.mycompany.pruebatec2.logica.MostrarTurno;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class MostrarTurnoJpaController {

    // Factor�a de EntityManager para gestionar la persistencia
    private final EntityManagerFactory emf;

    // Constructor que inicializa la factor�a de EntityManager
    public MostrarTurnoJpaController() {
        emf = Persistence.createEntityManagerFactory("galeriaartePU");
    }

    // M�todo para encontrar todas las entidades MostrarTurno
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

    // M�todo privado para obtener un EntityManager
    private javax.persistence.EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}