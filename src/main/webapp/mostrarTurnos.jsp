<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.pruebatec2.logica.Turno" %>
<%@ page import="com.mycompany.pruebatec2.persistencia.ControladoraPersistencia" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mostrar Todos los Turnos</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/cyborg/bootstrap.min.css">
    <style>
        .container {
            text-align: center;
        }

        .btn-container {
            text-align: center;
            margin-top: 15px;
        }
    </style>
</head>
<body>

<div class="container mt-4">
    <h2>Mostrar Todos los Turnos</h2>

    <!-- Mostrar todos los turnos en una tabla -->
    <table class="table mt-4">
        <thead>
            <tr>
                <th>ID</th>
                <th>Descripción Trámite</th>
                <th>Estado</th>
                <th>Fecha</th>
                <th>Número</th>
                <th>Ciudadano DNI</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="turno" items="${turnos}">
                <tr>
                    <td>${turno.id}</td>
                    <td>${turno.descripcionTramite}</td>
                    <td>${turno.estado}</td>
                    <td>${turno.fecha}</td>
                    <td>${turno.numero}</td>
                    <td>${turno.ciudadano.dni}</td>
                </tr>
            </c:forEach>
        </tbody>
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
