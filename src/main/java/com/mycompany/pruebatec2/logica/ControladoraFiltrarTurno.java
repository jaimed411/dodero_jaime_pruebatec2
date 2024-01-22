package com.mycompany.pruebatec2.logica;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

public class ControladoraFiltrarTurno {

    // Factoría de EntityManager para gestionar conexiones a la base de datos
    private final EntityManagerFactory emf;

    // Constructor que inicializa la EntityManagerFactory usando la unidad de persistencia "galeriaartePU"
    public ControladoraFiltrarTurno() {
        emf = Persistence.createEntityManagerFactory("galeriaartePU");
    }

    // Método para filtrar turnos por fecha
    public List<Turno> filtrarTurnosPorFecha(Date fecha) {
        EntityManager em = emf.createEntityManager();
        try {
            // Consulta JPA para obtener los turnos filtrados por fecha
            TypedQuery<Turno> query = em.createQuery("SELECT t FROM Turno t WHERE t.fecha = :fecha", Turno.class);
            query.setParameter("fecha", fecha);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    // Método para filtrar turnos por estado
    public List<Turno> filtrarTurnosPorEstado(String estado) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Turno> query = em.createQuery("SELECT t FROM Turno t WHERE t.estado = :estado", Turno.class);
            query.setParameter("estado", estado);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    // Método para filtrar turnos por fecha y estado
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

    // Método para cerrar la EntityManagerFactory al finalizar
    public void cerrarEntityManagerFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}