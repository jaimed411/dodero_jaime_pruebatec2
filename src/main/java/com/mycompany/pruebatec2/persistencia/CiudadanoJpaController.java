package com.mycompany.pruebatec2.persistencia;


import com.mycompany.pruebatec2.exceptions.NonexistentEntityException;
import com.mycompany.pruebatec2.exceptions.PreexistingEntityException;
import com.mycompany.pruebatec2.logica.Ciudadano;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class CiudadanoJpaController implements Serializable {

    // Factoría de EntityManager para gestionar la persistencia
    private EntityManagerFactory emf = null;

    // Constructor que recibe la factoría de EntityManager
    public CiudadanoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    // Obtiene un EntityManager
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    // Crea un nuevo registro de Ciudadano
    public void create(Ciudadano ciudadano) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(ciudadano);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCiudadano(ciudadano.getDni()) != null) {
                throw new PreexistingEntityException("Ciudadano " + ciudadano + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Actualiza un registro de Ciudadano
    public void edit(Ciudadano ciudadano) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ciudadano = em.merge(ciudadano);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = ciudadano.getDni();
                if (findCiudadano(id) == null) {
                    throw new NonexistentEntityException("The ciudadano with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Elimina un registro de Ciudadano
    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ciudadano ciudadano;
            try {
                ciudadano = em.getReference(Ciudadano.class, id);
                ciudadano.getDni();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ciudadano with id " + id + " no longer exists.", enfe);
            }
            em.remove(ciudadano);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Obtiene una lista de todos los registros de Ciudadano
    public List<Ciudadano> findCiudadanoEntities() {
        return findCiudadanoEntities(true, -1, -1);
    }

    // Obtiene una lista de registros de Ciudadano con paginación
    public List<Ciudadano> findCiudadanoEntities(int maxResults, int firstResult) {
        return findCiudadanoEntities(false, maxResults, firstResult);
    }

    // Método privado para obtener la lista de registros de Ciudadano con o sin paginación
    private List<Ciudadano> findCiudadanoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ciudadano.class));
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

    // Obtiene un registro de Ciudadano por su ID
    public Ciudadano findCiudadano(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ciudadano.class, id);
        } finally {
            em.close();
        }
    }

    // Obtiene la cantidad total de registros de Ciudadano
    public int getCiudadanoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ciudadano> rt = cq.from(Ciudadano.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    // Constructor sin parámetros que inicializa la factoría de EntityManager
    public CiudadanoJpaController() {
        emf = Persistence.createEntityManagerFactory("jpaPU");
    }
}