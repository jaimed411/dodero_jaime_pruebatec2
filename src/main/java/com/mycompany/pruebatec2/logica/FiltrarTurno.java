package com.mycompany.pruebatec2.logica;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class FiltrarTurno implements Serializable {

    // Identificador �nico del filtro de turno
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcionTramite;
    private String estado;

    @Temporal(TemporalType.DATE)
    private Date fecha;
    private String hora;
    private String numero;

    // Ciudadano asociado al filtro (relaci�n muchos a uno)
    @ManyToOne
    private Ciudadano ciudadano;

    // Constructores, getters y setters

    // Constructor por defecto
    public FiltrarTurno() {
    }

    // Constructor con par�metros para inicializar todos los atributos
    public FiltrarTurno(String descripcionTramite, String estado, Date fecha, String hora, String numero, Ciudadano ciudadano) {
        this.descripcionTramite = descripcionTramite;
        this.estado = estado;
        this.fecha = fecha;
        this.hora = hora;
        this.numero = numero;
        this.ciudadano = ciudadano;
    }

    // Getter y setter para el identificador �nico
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getters y setters para los dem�s atributos

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

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
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
