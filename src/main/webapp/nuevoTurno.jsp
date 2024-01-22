<%@ page import="com.mycompany.pruebatec2.logica.Ciudadano" %>
<%@ page import="com.mycompany.pruebatec2.logica.Turno" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Nuevo Turno - Galería de Arte</title>
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
        }
    </style>
    
</head>
<body>

    <div class="container mt-4">
        <h2>Reservar Exposición</h2>

        <!-- Formulario para agregar nuevo turno -->
        <form action="${pageContext.request.contextPath}/turno" method="post" class="custom-form">
            <div class="form-group">
                <label for="dni">Tu DNI:</label>
                <input type="text" class="form-control" id="dni" name="dni" required>
            </div>

            <!-- Lista de turnos ficticios -->
            <div class="form-group">
                <label for="turno">Seleccionar Exposición:</label>
                <select class="form-control" id="turno" name="turno" required>
                    <option value="Fragmentos de un Color Inacabado - Rafael Herrera">Fragmentos de un Color Inacabado - Rafael Herrera</option>
                    <option value="Resonancias Urbanas - Valentina Ramos">Resonancias Urbanas - Valentina Ramos</option>
                    <option value="Metamorfosis Cromatica - Javier Medina">Metamorfosis Cromatica - Javier Medina</option>
                    <option value="Entre Sombras y Luces - Camila Torres">Entre Sombras y Luces - Camila Torres</option>
                    <option value="Sinfonia en Azul - Martin Vargas">Sinfonia en Azul - Martin Vargas</option>
                    <option value="Jardines del Mañana - Clara Hernández">Jardines del Mañana - Clara Hernández</option>
                    <option value="Abstracciones en Movimiento - Andres Rodriguez">Abstracciones en Movimiento - Andres Rodriguez</option>
                    <option value="Espejismos de la Realidad - Beatriz Mendoza">Espejismos de la Realidad - Beatriz Mendoza</option>
                </select>
            </div>
            
            <div class="form-group">
                <label for="fechaConsulta">Para cuando?</label>
                <input type="date" class="form-control" id="fecha" name="fecha" required>
            </div>

            <!-- Lista de horarios ficticios -->
            <div class="form-group">
                <label for="hora">A qué hora?</label>
                <select class="form-control" id="hora" name="hora" required>
                    <option value="08:00 - 08:45">08:00 - 08:45</option>
                    <option value="08:45 - 09:30">08:45 - 09:30</option>
                    <option value="09:30 - 10:15">09:30 - 10:15</option>
                    <option value="10:15 - 11:00">10:15 - 11:00</option>
                    <option value="11:00 - 11:45">11:00 - 11:45</option>
                    <option value="13:15 - 14:00">13:15 - 14:00</option>
                    <option value="14:00 - 14:45">14:00 - 14:45</option>
                </select>
            </div>

            <button type="submit" class="btn btn-primary">Reservar</button>
            <a href="${pageContext.request.contextPath}/panelControl.jsp" class="btn btn-secondary">Volver</a>
        </form>
    </div>

    <!-- Scripts de Bootstrap y jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
