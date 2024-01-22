<%@page import="com.mycompany.pruebatec2.persistencia.ControladoraPersistencia"%>
<%@page import="com.mycompany.pruebatec2.logica.Ciudadano"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario Ciudadano - Galería de Arte</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/cyborg/bootstrap.min.css">
    <style>
        body {
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
        }

        .container {
            text-align: center;
            max-width: 400px; /* Ajusta el ancho según tus necesidades */
        }

        .form-group {
            max-width: 300px; /* Ajusta el ancho según tus necesidades */
            margin: 0 auto; /* Centra el formulario en la pantalla */
        }

        .btn-container {
            text-align: center;
            margin-top: 15px; /* Espaciado superior para separar los botones del formulario */
        }
    </style>
</head>
<body>
    <div class="container mt-4">
        <h2>Consultar por DNI</h2>
        <form action="${pageContext.request.contextPath}/panelControl.jsp" method="get">
            <% if (request.getAttribute("error") != null) { %>
                <div class="alert alert-danger" role="alert">
                    <%= request.getAttribute("error") %>
                </div>
            <% } %>

            <div class="form-group">
                <label for="consultaDNI">Consultar por DNI:</label>
                <input type="text" class="form-control" id="consultaDNI" name="consultaDNI" required>
            </div>
            <div class="btn-container">
                <button type="submit" class="btn btn-primary">Buscar</button>
                <a href="${pageContext.request.contextPath}/registroCiudadano.jsp" class="btn btn-secondary">Volver</a>
            </div>
        </form>
    </div>

    <!-- Scripts de Bootstrap y jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
