<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <!-- Redireccionar a panelControl.jsp después de 3 segundos -->
    <meta http-equiv="refresh" content="3;url=panelControl.jsp">
    <!-- Se incluye el estilo de Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/cyborg/bootstrap.min.css">

    <title>Bienvenida</title>
    <style>
        body {
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
            color: #007bff; 
            font-size: 100px; 
        }

        .container {
            text-align: center;
        }
    </style>
</head>
<body>
    <!-- Contenido de la página de bienvenida -->
    <div>
        <p>Bienvenido a IWWII!</p>
    </div>

    <!-- Scripts de Bootstrap y jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <!-- Script para redireccionar a panelControl.jsp después de 3 segundos -->
    <script>
        // Limpiar el mensaje después de unos segundos (puedes ajustar el tiempo)
        setTimeout(function () {
            window.location.href = "panelControl.jsp";
        }, 3000); // (3 segundos)
    </script>
</body>
</html>
