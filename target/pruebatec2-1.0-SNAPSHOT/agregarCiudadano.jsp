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
        }

        .custom-form {
            max-width: 400px; /* Ancho máximo del formulario */
            margin: 0 auto; /* Centrar el formulario en la pantalla */
        }

        .form-group {
            width: 100%; /* Ancho del 100% para cajas de entrada */
            margin-bottom: 10px; /* Espacio entre las cajas del formulario */
        }

        .btn-container {
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container mt-4">
        <form action="${pageContext.request.contextPath}/ciudadano" method="post" class="custom-form">
            <div class="form-group">
                <label for="dni">DNI:</label>
                <input type="text" class="form-control" id="dni" name="dni" required>
            </div>
            <div class="form-group">
                <label for="nombre">Nombre:</label>
                <input type="text" class="form-control" id="nombre" name="nombre" required>
            </div>
            <div class="form-group">
                <label for="apellidos">Apellidos:</label>
                <input type="text" class="form-control" id="apellidos" name="apellidos" required>
            </div>
            <div class="form-group">
                <label for="edad">Edad:</label>
                <input type="number" class="form-control" id="edad" name="edad" required>
            </div>
            <div class="form-group">
                <label for="telefono">Teléfono:</label>
                <input type="text" class="form-control" id="telefono" name="telefono" required>
            </div>
            <p>
                
            </p>
            <div class="btn-container">
                <button type="submit" class="btn btn-primary">Agregar Ciudadano</button>
                <a href="${pageContext.request.contextPath}/registroCiudadano.jsp" class="btn btn-secondary">Volver</a>
            </div>
        </form>
        <hr>
    </div>

    <!-- Scripts de Bootstrap y jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
