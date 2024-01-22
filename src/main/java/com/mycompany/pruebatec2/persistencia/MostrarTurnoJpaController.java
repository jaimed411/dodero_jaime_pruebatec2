/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebatec2.persistencia;


import com.mycompany.pruebatec2.logica.MostrarTurno;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class MostrarTurnoJpaController {

    private final EntityManagerFactory emf;

    public MostrarTurnoJpaController() {
        emf = Persistence.createEntityManagerFactory("galeriaartePU");
    }

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

    private javax.persistence.EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
