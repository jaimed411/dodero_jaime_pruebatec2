package com.mycompany.pruebatec2.logica;


import com.mycompany.pruebatec2.persistencia.CiudadanoJpaController;
import java.util.List;

public class ControladoraCiudadano {
    private CiudadanoJpaController ciudadanoJpaController;

    public ControladoraCiudadano(CiudadanoJpaController ciudadanoJpaController) {
        this.ciudadanoJpaController = ciudadanoJpaController;
    }

    public void agregarCiudadano(String dni, String nombre, int edad) throws Exception {
        Ciudadano ciudadano = new Ciudadano(dni, nombre, edad);
        ciudadanoJpaController.create(ciudadano);
    }

    public List<Ciudadano> listarCiudadanos() {
        return ciudadanoJpaController.findCiudadanoEntities();
    }

    public Ciudadano obtenerCiudadanoPorDni(String dni) {
        return ciudadanoJpaController.findCiudadano(dni);
    }

    // Puedes agregar más métodos según tus necesidades (actualizar, borrar, etc.)
}
