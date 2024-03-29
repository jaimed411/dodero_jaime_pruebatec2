package com.mycompany.pruebatec2.logica;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
// Especificaci�n del nombre de la tabla en la base de datos y del esquema (schema)
@Table(name = "ciudadanos", schema = "galeriaarte")
public class Ciudadano {

    // Identificador �nico generado autom�ticamente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Atributos de la entidad Ciudadano
    private String dni;
    private String nombre;
    private String apellidos;
    private int edad;
    private String telefono;

    // Constructor vacio
    public Ciudadano(int dni1) {
    }

    // Constructores de la clase

    // Constructor utilizado para prop�sitos internos (no utilizado en el c�digo proporcionado)
    public Ciudadano(String dni1, String nombre1, int edad1) {}

    // Constructor principal utilizado para crear instancias de la clase Ciudadano
    public Ciudadano(String dni, String nombre, String apellidos, int edad, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.telefono = telefono;
    }

    // M�todos Getters y Setters para acceder y modificar los atributos

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // M�todo adicional que devuelve el nombre completo concatenando nombre y apellidos
    public String getNombreCompleto() {
        return nombre + " " + apellidos;
    }
    
    // Constructor predeterminado necesario para JPA
    public Ciudadano() {
        // Constructor predeterminado
    }
}

