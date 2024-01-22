<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registro Ciudadano</title>
    <!-- Se incluye el estilo de Bootstrap -->
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
    </style>
</head>
<body>

    <div class="container">
        <!-- Título y pregunta principal -->
        <h1 class="mt-5">Ya eres Iwwiriano?</h1>

        <!-- Enlaces para la respuesta del usuario -->
        <div class="mt-4">
            <!-- Enlace para ciudadanos existentes -->
            <a href="YaSoyCiudadano.jsp" class="btn btn-primary">Sí, lo soy!</a>
            <!-- Enlace para nuevos registros de ciudadanos -->
            <a href="agregarCiudadano.jsp" class="btn btn-secondary ml-2">No, voy a ello</a>
        </div>
    </div>
</body>
</html>
