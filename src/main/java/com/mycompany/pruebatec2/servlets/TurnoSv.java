package com.mycompany.pruebatec2.servlets;

import com.mycompany.pruebatec2.logica.Ciudadano;
import com.mycompany.pruebatec2.logica.Turno;
import com.mycompany.pruebatec2.logica.ControladoraTurno;
import com.mycompany.pruebatec2.persistencia.ControladoraPersistencia;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/turno")
public class TurnoSv extends HttpServlet {

    private final ControladoraTurno controladoraTurno = new ControladoraTurno();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener parámetros del formulario
        String dniStr = request.getParameter("dni");
        String descripcionTramite = request.getParameter("turno");
        String fechaStr = request.getParameter("fecha");
        String hora = request.getParameter("hora");

        // Parsear DNI a un número
        int dni = 0;  // Valor por defecto o manejo de error
        if (dniStr != null && !dniStr.isEmpty()) {
            try {
                dni = Integer.parseInt(dniStr);
            } catch (NumberFormatException e) {
                // Manejar la excepción, puedes imprimir un mensaje de error o asignar un valor por defecto
                e.printStackTrace();  // Esto imprimirá el rastreo de la excepción en la consola
            }
        }

        // Obtener el ciudadano asociado al DNI
        ControladoraPersistencia controladoraPersistencia = new ControladoraPersistencia();
        Ciudadano ciudadano = controladoraPersistencia.buscarCiudadanoPorDNI(dniStr);

        // Verificar si fechaStr no es nulo antes de intentar parsear
        Date fecha = null;
        if (fechaStr != null && !fechaStr.isEmpty()) {
            fecha = parsearFecha(fechaStr);
        }

        // Configurar 'en espera' como valor predeterminado para el estado
        String estado = "en espera";

        // Crear nuevo turno y agregarlo
        Turno nuevoTurno = new Turno(0, fecha, descripcionTramite, estado, ciudadano);
        nuevoTurno.setHora(hora);  // Establecer la hora
        controladoraTurno.agregarTurno(nuevoTurno);

        // Redirigir a la página de "reserva realizada"
        RequestDispatcher dispatcher = request.getRequestDispatcher("/reservaRealizada.jsp");
        dispatcher.forward(request, response);
    }

    private Date parsearFecha(String fechaStr) {
        // Implementa la lógica para parsear la fecha según el formato que necesites
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(fechaStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}