package com.mycompany.pruebatec2.logica;


import com.mycompany.pruebatec2.persistencia.CiudadanoJpaController;
import java.util.List;

// Clase que actúa como controladora para la entidad Ciudadano
public class ControladoraCiudadano {
    private CiudadanoJpaController ciudadanoJpaController;

    // Constructor que recibe una instancia de CiudadanoJpaController
    public ControladoraCiudadano(CiudadanoJpaController ciudadanoJpaController) {
        this.ciudadanoJpaController = ciudadanoJpaController;
    }

    // Método para agregar un nuevo Ciudadano a la base de datos
    public void agregarCiudadano(String dni, String nombre, int edad) throws Exception {
        // Crear una nueva instancia de Ciudadano con los datos proporcionados
        Ciudadano ciudadano = new Ciudadano(dni, nombre, edad);
        // Invocar al controlador JPA para crear el Ciudadano en la base de datos
        ciudadanoJpaController.create(ciudadano);
    }

    // Método para listar todos los Ciudadanos en la base de datos
    public List<Ciudadano> listarCiudadanos() {
        // Invocar al controlador JPA para obtener la lista de Ciudadanos
        return ciudadanoJpaController.findCiudadanoEntities();
    }

    // Método para obtener un Ciudadano por su número de DNI
    public Ciudadano obtenerCiudadanoPorDni(String dni) {
        // Invocar al controlador JPA para buscar un Ciudadano por su DNI
        return ciudadanoJpaController.findCiudadano(dni);
    }

}
