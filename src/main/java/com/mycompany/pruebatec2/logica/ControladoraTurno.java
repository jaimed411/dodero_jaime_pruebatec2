package com.mycompany.pruebatec2.logica;



import com.mycompany.pruebatec2.persistencia.TurnoJpaController;
import java.util.ArrayList;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class ControladoraTurno {

    private TurnoJpaController turnoJpaController;

    public ControladoraTurno() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("galeriaartePU");
        turnoJpaController = new TurnoJpaController(emf);
    }

    public void agregarTurno(int numero, Date fecha, String descripcionTramite, String estado, Ciudadano ciudadano) {
        Turno nuevoTurno = new Turno(numero, fecha, descripcionTramite, estado, ciudadano);
        turnoJpaController.create(nuevoTurno);
    }



    public List<Turno> obtenerTurnosPorFechaYEstado(Date fecha, String estado) {
        return turnoJpaController.consultarTurnosPorFechaYEstado(fecha, estado);
    }



    public List<Turno> obtenerTodosLosTurnos() {
        return turnoJpaController.findTurnoEntities();
    }

    public Turno buscarTurnoPorId(Long id) {
        return turnoJpaController.findTurno(id);
    }

    public void actualizarTurno(Turno turno) {
        try {
            turnoJpaController.edit(turno);
        } catch (Exception e) {
            // Maneja la excepción según tus necesidades
            e.printStackTrace();
        }
    }

    public void eliminarTurno(Long id) {
        try {
            turnoJpaController.destroy(id);
        } catch (Exception e) {
            // Maneja la excepción según tus necesidades
            e.printStackTrace();
        }
    }
    
    
    
    public List<Turno> consultarTurnosPorFechaYEstado(Date fecha, String estado) {
    List<Turno> turnos = turnoJpaController.findTurnoEntities();
    return filtrarTurnosPorFechaYEstado(turnos, fecha, estado);
}

    private List<Turno> filtrarTurnosPorFechaYEstado(List<Turno> turnos, Date fecha, String estado) {
        // Filtra los turnos por fecha y estado
        // Si fecha es null, no filtra por fecha
        // Si estado es null o vacío, no filtra por estado
        // Devuelve la lista filtrada

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
    
    
    public void agregarTurno(Turno turno) {
        // Asegúrate de tener la lógica necesaria para manejar la persistencia del turno
        // Puedes utilizar el JpaController, EntityManager, etc.
        // Aquí se proporciona un ejemplo básico utilizando JpaController
        TurnoJpaController turnoJpaController = new TurnoJpaController(Persistence.createEntityManagerFactory("galeriaartePU"));
        try {
            turnoJpaController.create(turno);
        } catch (Exception e) {
            e.printStackTrace(); // Maneja la excepción según tus necesidades
        }
    }
    

}

