package com.mycompany.pruebatec2.logica;


import com.mycompany.pruebatec2.persistencia.MostrarTurnoJpaController;
import java.util.List;

public class ControladoraMostrarTurno {

    private final MostrarTurnoJpaController jpaController;

    public ControladoraMostrarTurno() {
        this.jpaController = new MostrarTurnoJpaController();
    }

    public List<MostrarTurno> obtenerTodosLosTurnos() {
        return jpaController.findMostrarTurnoEntities();
    }
}
