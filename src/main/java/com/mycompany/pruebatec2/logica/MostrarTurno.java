package com.mycompany.pruebatec2.logica;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "turnos")
public class MostrarTurno implements Serializable {

    @Id
    private Long id;

    private String descripcionTramite;
    private String estado;
    private Date fecha;
    private String numero;

    // Ciudadano asociado al turno (relación muchos a uno)
    @ManyToOne
    @JoinColumn(name = "ciudadano_dni")
    private Ciudadano ciudadano;

    // Constructores, getters y setters

    // Getter y setter para el identificador único
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getters y setters para los demás atributos

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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }
}
