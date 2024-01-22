package com.mycompany.pruebatec2.logica;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "turnos")
public class Turno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "numero")
    private int numero;

    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name = "descripcionTramite")
    private String descripcionTramite;
    

    @Column(name = "estado")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "ciudadano_dni")
    private Ciudadano ciudadano;
    
    @Column(name = "hora")
    private String hora;

    
    // Constructor sin parámetros
    public Turno() {
    }

    public Turno(int numero, Date fecha, String descripcionTramite, String estado, Ciudadano ciudadano) {
        this.numero = numero;
        this.fecha = fecha;
        this.descripcionTramite = descripcionTramite;
        this.estado = estado;
        this.ciudadano = ciudadano;
    }
    
    

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcionTramite() {
        return descripcionTramite;
    }

    public void setDescripcionTramite(String descripcionTramite) {
        this.descripcionTramite = descripcionTramite;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }
    
    public String getDescripcion() {
        String descripcion = null;
        return descripcion;
    }
    
    public String getHora() {
    return hora;
}

    public void setHora(String hora) {
        this.hora = hora;
    }
 

    // Otros métodos según las necesidades
}
