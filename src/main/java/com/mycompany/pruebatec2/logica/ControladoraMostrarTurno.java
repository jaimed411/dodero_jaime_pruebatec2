package com.mycompany.pruebatec2.logica;


import com.mycompany.pruebatec2.persistencia.MostrarTurnoJpaController;
import java.util.List;

public class ControladoraMostrarTurno {

    // Controlador JPA para acceder a la capa de persistencia
    private final MostrarTurnoJpaController jpaController;

    // Constructor que inicializa el controlador JPA
    public ControladoraMostrarTurno() {
        this.jpaController = new MostrarTurnoJpaController();
    }

    // Método para obtener todos los turnos disponibles
    public List<MostrarTurno> obtenerTodosLosTurnos() {
        return jpaController.findMostrarTurnoEntities();
    }
}
