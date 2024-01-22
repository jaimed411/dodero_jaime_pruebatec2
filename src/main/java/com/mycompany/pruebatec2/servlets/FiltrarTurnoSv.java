package com.mycompany.pruebatec2.servlets;

import com.mycompany.pruebatec2.logica.ControladoraFiltrarTurno;
import com.mycompany.pruebatec2.logica.Turno;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/filtrarTurnos")
public class FiltrarTurnoSv extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener la fecha y el estado del formulario
        String fechaStr = request.getParameter("fecha");
        String estado = request.getParameter("estado");

        try {
            // Convertir la cadena de fecha a un objeto Date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = sdf.parse(fechaStr);

            // Utilizar la ControladoraFiltrarTurno para obtener los turnos filtrados por fecha y estado
            ControladoraFiltrarTurno controladoraFiltrarTurno = new ControladoraFiltrarTurno();
            List<Turno> turnos = controladoraFiltrarTurno.filtrarTurnosPorFechaYEstado(fecha, estado);

            // Establecer los resultados en la solicitud para que se muestren en el JSP
            request.setAttribute("turnos", turnos);

            // Redirigir a la página JSP
            request.getRequestDispatcher("/filtrarTurnos.jsp").forward(request, response);
        } catch (ParseException e) {
            e.printStackTrace();
            // Manejar el error de parseo de fecha según tus necesidades
            request.setAttribute("error", "Error al procesar la fecha");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}




