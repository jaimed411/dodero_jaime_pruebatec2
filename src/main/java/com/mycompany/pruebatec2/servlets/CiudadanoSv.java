package com.mycompany.pruebatec2.servlets;


import com.mycompany.pruebatec2.logica.Ciudadano;
import com.mycompany.pruebatec2.persistencia.ControladoraPersistencia;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CiudadanoSv", urlPatterns = {"/ciudadano"})
public class CiudadanoSv extends HttpServlet {

    // Lista temporal de ciudadanos (podría ser reemplazada por la base de datos)
    private List<Ciudadano> listaCiudadanos = new ArrayList<>();

    // Método para manejar las solicitudes POST
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lógica para agregar un nuevo ciudadano
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String telefono = request.getParameter("telefono");

        // Crear un nuevo ciudadano
        Ciudadano nuevoCiudadano = new Ciudadano(dni, nombre, apellidos, edad, telefono);

        // Utilizar la ControladoraPersistencia para agregar el ciudadano a la base de datos
        ControladoraPersistencia controladoraPersistencia = new ControladoraPersistencia();
        controladoraPersistencia.agregarCiudadano(nuevoCiudadano);

        // Redireccionar o mostrar un mensaje de éxito
        response.sendRedirect(request.getContextPath() + "/bienvenida.jsp");
    }

    // Método para manejar las solicitudes GET
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lógica para consultar ciudadanos por DNI
        String consultaDNI = request.getParameter("consultaDNI");

        if (consultaDNI != null && !consultaDNI.isEmpty()) {
            // Utilizar la ControladoraPersistencia para buscar el ciudadano por DNI en la base de datos
            ControladoraPersistencia controladoraPersistencia = new ControladoraPersistencia();
            Ciudadano ciudadanoEncontrado = controladoraPersistencia.buscarCiudadanoPorDNI(consultaDNI);

            if (ciudadanoEncontrado != null) {
                // Ciudadano encontrado, redirigir al panel de control
                response.sendRedirect(request.getContextPath() + "/panelControl.jsp");
            } else {
                // Ciudadano no encontrado, mostrar mensaje de error
                request.setAttribute("error", "Ciudadano no registrado");
                request.getRequestDispatcher("/YaSoyCiudadano.jsp").forward(request, response);
            }
        } else {
            // Lógica para listar todos los ciudadanos (puedes obtener la lista desde la base de datos)
            // Puedes pasar la lista de ciudadanos a la página JSP para mostrarla
            request.setAttribute("ciudadanos", listaCiudadanos);
            request.getRequestDispatcher("/listaCiudadanos.jsp").forward(request, response);
        }
    }
}
