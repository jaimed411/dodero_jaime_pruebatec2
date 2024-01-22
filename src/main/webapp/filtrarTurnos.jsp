<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.pruebatec2.logica.Turno" %>
<%@ page import="com.mycompany.pruebatec2.persistencia.ControladoraPersistencia" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Filtrar Turnos por Fecha</title>
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
    <h2 class="centered-heading">Filtrar Turnos por Fecha</h2>

    <!-- Formulario para filtrar por fecha y estado -->
    <form action="${pageContext.request.contextPath}/filtrarTurnos" method="post" class="custom-form">
        <div class="form-group">
            <label for="fecha">Qué día quieres filtrar?</label>
            <input type="date" class="form-control" id="fecha" name="fecha" required>
        </div>

        <div class="form-group">
            <label for="estado">En espera o Ya atendido?</label>
            <select class="form-control" id="estado" name="estado">
                <option value="En espera">En espera</option>
                <option value="Ya atendido">Ya atendido</option>
            </select>
        </div>

        <button type="submit" class="btn btn-primary custom-btn">Filtrar y mostrar</button>
    </form>

    <!-- Mostrar resultados en una tabla -->
    <table class="table mt-4">
        <% if (request.getAttribute("turnos") != null) { %>
            <table class="table">
                <thead>
                    <tr>
                        <th>Descripción Trámite</th>
                        <th>Estado</th>
                        <th>Fecha</th>
                        <th>Número</th>
                        <th>Ciudadano DNI</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Turno turno : (List<Turno>) request.getAttribute("turnos")) { %>
                        <tr>
                            <td><%= turno.getDescripcionTramite() %></td>
                            <td><%= turno.getEstado() %></td>
                            <td><%= new SimpleDateFormat("EEE MMM dd yyyy").format(turno.getFecha()) %></td>
                            <td><%= turno.getNumero() %></td>
                            <td><%= turno.getCiudadano().getDni() %></td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        <% } %>
    </table>

    <div class="btn-container">
        <a href="${pageContext.request.contextPath}/panelControl.jsp" class="btn btn-secondary">Volver</a>
    </div>
</div>

<!-- Scripts de Bootstrap y jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
