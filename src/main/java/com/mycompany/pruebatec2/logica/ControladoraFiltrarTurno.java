package com.mycompany.pruebatec2.logica;




import com.mycompany.pruebatec2.logica.Turno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ControladoraFiltrarTurno {

    private final EntityManagerFactory emf;

    public ControladoraFiltrarTurno() {
        emf = Persistence.createEntityManagerFactory("galeriaartePU");
    }

    public List<Turno> filtrarTurnosPorFecha(Date fecha) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Turno> query = em.createQuery("SELECT t FROM Turno t WHERE t.fecha = :fecha", Turno.class);
            query.setParameter("fecha", fecha);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
    public List<Turno> filtrarTurnosPorEstado(Date estado) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Turno> query = em.createQuery("SELECT t FROM Turno t WHERE t.estado = :estado", Turno.class);
            query.setParameter("estado", estado);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
    public List<Turno> filtrarTurnosPorFechaYEstado(Date fecha, String estado) {
    EntityManager em = emf.createEntityManager();
    try {
        TypedQuery<Turno> query = em.createQuery("SELECT t FROM Turno t WHERE t.fecha = :fecha AND t.estado = :estado", Turno.class);
        query.setParameter("fecha", fecha);
        query.setParameter("estado", estado);
        return query.getResultList();
    } finally {
        em.close();
    }
}


    public void cerrarEntityManagerFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
    
    
}
