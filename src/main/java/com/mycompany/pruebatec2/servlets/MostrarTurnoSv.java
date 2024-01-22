package com.mycompany.pruebatec2.servlets;

import com.mycompany.pruebatec2.logica.ControladoraMostrarTurno;
import com.mycompany.pruebatec2.logica.MostrarTurno;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mostrarTurnos")
public class MostrarTurnoSv extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Utilizar la ControladoraMostrarTurno para obtener todos los turnos
        ControladoraMostrarTurno controladoraMostrarTurno = new ControladoraMostrarTurno();
        List<MostrarTurno> todosLosTurnos = controladoraMostrarTurno.obtenerTodosLosTurnos();

        // Imprimir informaci�n de depuraci�n
        System.out.println("N�mero de turnos recuperados: " + todosLosTurnos.size());

        // Establecer los resultados en la solicitud para que se muestren en el JSP
        request.setAttribute("turnos", todosLosTurnos);

        // Redirigir a la p�gina JSP
        request.getRequestDispatcher("/mostrarTurnos.jsp").forward(request, response);
    }

}
