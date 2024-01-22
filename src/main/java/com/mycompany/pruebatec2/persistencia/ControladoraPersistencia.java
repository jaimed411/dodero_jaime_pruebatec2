package com.mycompany.pruebatec2.persistencia;


import com.mycompany.pruebatec2.logica.Ciudadano;
import com.mycompany.pruebatec2.logica.Turno;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class ControladoraPersistencia {

    // Factor�a de EntityManager para gestionar la persistencia
    private final EntityManagerFactory emf;

    // Constructor que inicializa la factor�a de EntityManager
    public ControladoraPersistencia() {
        emf = Persistence.createEntityManagerFactory("galeriaartePU"); // Ajusta el nombre de la unidad de persistencia seg�n tu configuraci�n
    }

    // M�todo para agregar un Ciudadano a la base de datos mediante JPA
    public void agregarCiudadano(Ciudadano ciudadano) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(ciudadano);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // M�todo para verificar la existencia de un Ciudadano por DNI mediante JPA
    public boolean existeCiudadanoPorDNI(String dni) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Long> query = em.createQuery("SELECT COUNT(c) FROM Ciudadano c WHERE c.dni = :dni", Long.class);
            query.setParameter("dni", dni);
            return query.getSingleResult() > 0;
        } finally {
            em.close();
        }
    }

    // M�todo para cerrar la factor�a de EntityManager
    public void cerrarEntityManagerFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }

    // M�todo para agregar un Turno a la base de datos mediante SQL
    public void agregarTurno(Turno turno) {
        try (Connection conn = obtenerConexion()) {
            String sql = "INSERT INTO turnos (numero, fecha, descripcionTramite, estado, ciudadano_dni, hora) VALUES (?, ?, ?, ?, ?, ?)";

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                int numeroAleatorio = generarNumeroAleatorio();

                stmt.setInt(1, numeroAleatorio);
                stmt.setDate(2, new java.sql.Date(turno.getFecha().getTime()));
                stmt.setString(3, turno.getDescripcionTramite());
                stmt.setString(4, turno.getEstado());
                stmt.setString(5, turno.getCiudadano().getDni());
                stmt.setString(6, turno.getHora());

                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Manejo de errores, ajusta seg�n tus necesidades
        }
    }

    // M�todo para generar un n�mero aleatorio del 1 al 100
    private int generarNumeroAleatorio() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }

    // M�todo para obtener una conexi�n a la base de datos
    private Connection obtenerConexion() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/tu_basede_datos";
        String usuario = "tu_usuario";
        String contrase�a = "tu_contrase�a";

        try {
            return DriverManager.getConnection(url, usuario, contrase�a);
        } catch (SQLException e) {
            throw new SQLException("Error al obtener la conexi�n a la base de datos", e);
        }
    }

    // M�todo para buscar un Ciudadano por DNI mediante JPA
    public Ciudadano buscarCiudadanoPorDNI(String dniStr) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Ciudadano> query = em.createQuery("SELECT c FROM Ciudadano c WHERE c.dni = :dni", Ciudadano.class);
            query.setParameter("dni", dniStr);

            List<Ciudadano> resultados = query.getResultList();
            if (!resultados.isEmpty()) {
                return resultados.get(0);
            } else {
                return null; // Retorna null si no se encuentra el ciudadano con el DNI dado
            }
        } finally {
            em.close();
        }
    }

    // M�todo para obtener una lista de Turnos por fecha mediante JPA
    public List<Turno> obtenerTurnosPorFecha(Date fecha) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Turno> query = em.createQuery("SELECT t FROM Turno t WHERE t.fecha = :fecha", Turno.class);
            query.setParameter("fecha", fecha);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    // Nuevo m�todo para filtrar Turnos por fecha mediante JPA
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
}