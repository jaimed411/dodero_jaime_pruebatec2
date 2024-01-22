package com.mycompany.pruebatec2.persistencia;


import com.mycompany.pruebatec2.exceptions.NonexistentEntityException;
import com.mycompany.pruebatec2.logica.Turno;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class TurnoJpaController implements Serializable {

    // Factoría de EntityManager para gestionar la persistencia
    private EntityManagerFactory emf = null;

    // Constructor que inicializa la factoría de EntityManager
    public TurnoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    // Método para obtener un EntityManager
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Método para crear un nuevo Turno
    public void create(Turno turno) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(turno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Método para editar un Turno existente
    public void edit(Turno turno) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            turno = em.merge(turno);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = turno.getId();
                if (findTurno(id) == null) {
                    throw new NonexistentEntityException("The turno with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Método para eliminar un Turno por su ID
    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Turno turno;
            try {
                turno = em.getReference(Turno.class, id);
                turno.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The turno with id " + id + " no longer exists.", enfe);
            }
            em.remove(turno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Método para encontrar todos los Turnos
    public List<Turno> findTurnoEntities() {
        return findTurnoEntities(true, -1, -1);
    }

    // Método para encontrar una cantidad específica de Turnos
    public List<Turno> findTurnoEntities(int maxResults, int firstResult) {
        return findTurnoEntities(false, maxResults, firstResult);
    }

    // Método privado para encontrar Turnos con opciones de paginación
    private List<Turno> findTurnoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Turno.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    // Método para encontrar un Turno por su ID
    public Turno findTurno(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Turno.class, id);
        } finally {
            em.close();
        }
    }

    // Método para obtener la cantidad total de Turnos
    public int getTurnoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Turno> rt = cq.from(Turno.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    // Método para consultar Turnos por fecha y estado
    public List<Turno> consultarTurnosPorFechaYEstado(Date fecha, String estado) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Turno> query = em.createQuery("SELECT t FROM Turno t WHERE t.fecha = :fecha AND t.estado = :estado", Turno.class);
            query.setParameter("fecha", fecha);
            query.setParameter("estado", estado);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}