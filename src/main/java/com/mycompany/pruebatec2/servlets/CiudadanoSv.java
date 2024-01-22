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

    private List<Ciudadano> listaCiudadanos = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Manejar la lógica de agregar un nuevo ciudadano
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String telefono = request.getParameter("telefono");

        Ciudadano nuevoCiudadano = new Ciudadano(dni, nombre, apellidos, edad, telefono);

        // Utiliza la ControladoraPersistencia para agregar el ciudadano a la base de datos
        ControladoraPersistencia controladoraPersistencia = new ControladoraPersistencia();
        controladoraPersistencia.agregarCiudadano(nuevoCiudadano);

        // Redireccionar o mostrar un mensaje de éxito
        response.sendRedirect(request.getContextPath() + "/bienvenida.jsp");
        

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Manejar la lógica de consultar ciudadanos por DNI
        String consultaDNI = request.getParameter("consultaDNI");

        if (consultaDNI != null && !consultaDNI.isEmpty()) {
            Ciudadano ciudadanoEncontrado = buscarCiudadanoPorDNI(consultaDNI);

            if (ciudadanoEncontrado != null) {
                // Ciudadano encontrado, redirigir al panel de control
                response.sendRedirect(request.getContextPath() + "/panelControl.jsp");
            } else {
                // Ciudadano no encontrado, mostrar mensaje de error
                request.setAttribute("error", "Ciudadano no registrado");
                request.getRequestDispatcher("/YaSoyCiudadano.jsp").forward(request, response);
            }
        } else {
            // Manejar la lógica de listar ciudadanos
            // Puedes pasar la lista de ciudadanos a la página JSP para mostrarla
            request.setAttribute("ciudadanos", listaCiudadanos);
            request.getRequestDispatcher("/listaCiudadanos.jsp").forward(request, response);
        }
    }


    private Ciudadano buscarCiudadanoPorDNI(String dni) {
        for (Ciudadano ciudadano : listaCiudadanos) {
            if (ciudadano.getDni().equals(dni)) {
                return ciudadano;
            }
        }
        return null; // Retorna null si no se encuentra el ciudadano con el DNI dado
    }
    
    


    
}
