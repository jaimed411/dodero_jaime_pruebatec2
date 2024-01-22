<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Panel de Control</title>
    <!-- Se incluye el estilo de Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/cyborg/bootstrap.min.css">
    
    <style>
        body {
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
            background-image: url('img/panControl_bg.jpg');
            background-size: cover;
            background-repeat: no-repeat;
        }

        .container {
            text-align: center;
        }

        .custom-form {
            max-width: 400px; 
            margin: 0 auto; 
        }

        .form-group {
            width: 50%; 
        }

        .custom-btn {
            width: 70%; 
            margin: 5px auto; 
        }
    </style>
</head>
<body>   
    <div class="container mt-4">
        <!-- Título del panel de control -->
        <h2>Qué quieres hacer?</h2>

        <!-- Botones organizados en dos filas -->
        <div class="row mt-3">
            <div class="col-md-6 mb-3">
                <!-- Enlace para reservar exposición -->
                <a href="${pageContext.request.contextPath}/nuevoTurno.jsp" class="btn btn-primary custom-btn">Reservar Exposición</a>
            </div>
            <div class="col-md-6 mb-3">
                <!-- Enlace para mostrar todos los turnos de exposición -->
                <a href="${pageContext.request.contextPath}/mostrarTurnos.jsp" class="btn btn-primary custom-btn">Mostrar Todos los Turnos Exposición</a>
            </div>
        </div>
        <!-- Segunda fila de botones -->
        <div class="row">
            <div class="col-md-6">
                <!-- Enlace para filtrar turnos de exposición -->
                <a href="${pageContext.request.contextPath}/filtrarTurnos.jsp" class="btn btn-primary custom-btn">Filtrar Turnos Exposición</a>
            </div>
            <div class="col-md-6">
                <!-- Enlace para cerrar la cuenta -->
                <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-secondary custom-btn">Cerrar mi cuenta</a>
            </div>
        </div>
    </div>

    <!-- Scripts de Bootstrap y jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
