package com.mycompany.pruebatec2.logica;


import com.mycompany.pruebatec2.persistencia.TurnoJpaController;
import java.util.ArrayList;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class ControladoraTurno {

    // Controlador JPA para acceder a la capa de persistencia
    private TurnoJpaController turnoJpaController;

    // Constructor que inicializa el controlador JPA
    public ControladoraTurno() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("galeriaartePU");
        turnoJpaController = new TurnoJpaController(emf);
    }

    // M�todo para agregar un nuevo turno
    public void agregarTurno(int numero, Date fecha, String descripcionTramite, String estado, Ciudadano ciudadano) {
        Turno nuevoTurno = new Turno(numero, fecha, descripcionTramite, estado, ciudadano);
        turnoJpaController.create(nuevoTurno);
    }

    // M�todo para obtener turnos seg�n fecha y estado
    public List<Turno> obtenerTurnosPorFechaYEstado(Date fecha, String estado) {
        return turnoJpaController.consultarTurnosPorFechaYEstado(fecha, estado);
    }

    // M�todo para obtener todos los turnos
    public List<Turno> obtenerTodosLosTurnos() {
        return turnoJpaController.findTurnoEntities();
    }

    // M�todo para buscar un turno por su ID
    public Turno buscarTurnoPorId(Long id) {
        return turnoJpaController.findTurno(id);
    }

    // M�todo para actualizar un turno
    public void actualizarTurno(Turno turno) {
        try {
            turnoJpaController.edit(turno);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // M�todo para eliminar un turno por su ID
    public void eliminarTurno(Long id) {
        try {
            turnoJpaController.destroy(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // M�todo para consultar turnos seg�n fecha y estado
    public List<Turno> consultarTurnosPorFechaYEstado(Date fecha, String estado) {
        List<Turno> turnos = turnoJpaController.findTurnoEntities();
        return filtrarTurnosPorFechaYEstado(turnos, fecha, estado);
    }

    // M�todo privado para filtrar turnos por fecha y estado
    private List<Turno> filtrarTurnosPorFechaYEstado(List<Turno> turnos, Date fecha, String estado) {
        // Filtra los turnos por fecha y estado

        List<Turno> turnosFiltrados = new ArrayList<>();

        for (Turno turno : turnos) {
            boolean cumpleFecha = (fecha == null) || fecha.equals(turno.getFecha());
            boolean cumpleEstado = (estado == null || estado.isEmpty()) || estado.equals(turno.getEstado());

            if (cumpleFecha && cumpleEstado) {
                turnosFiltrados.add(turno);
            }
        }

        return turnosFiltrados;
    }

    // M�todo para agregar un turno (otra versi�n que acepta un objeto Turno)
    public void agregarTurno(Turno turno) {
        // Aseg�rate de tener la l�gica necesaria para manejar la persistencia del turno
        // Puedes utilizar el JpaController, EntityManager, etc.
        // Aqu� se proporciona un ejemplo b�sico utilizando JpaController
        TurnoJpaController turnoJpaController = new TurnoJpaController(Persistence.createEntityManagerFactory("galeriaartePU"));
        try {
            turnoJpaController.create(turno);
        } catch (Exception e) {
            e.printStackTrace(); // Maneja la excepci�n seg�n tus necesidades
        }
    }
}