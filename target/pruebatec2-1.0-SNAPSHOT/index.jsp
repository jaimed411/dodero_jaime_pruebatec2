<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>IWWII Gallery</title>
    <!-- Se incluye el estilo de Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/cyborg/bootstrap.min.css">
    <style>
        body {
            color: #232324;
            padding: 20px;
            height: 100vh;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }

        /* Estilos para el título */
        h1 {
            text-align: center;
            margin-bottom: 20px;
        }

        /* Estilos para el texto */
        p {
            text-align: center;
        }

        /* Estilos para el fondo de la página */
        body {
            background-image: url('img/index_bg.jpg');
            background-size: cover;
            background-repeat: no-repeat;
        }
    </style>
</head>
<body>
    <!-- Cuerpo de la página -->

    <!-- Título -->
    <h1 class="mt-5">IWWII Gallery</h1>

    <!-- Logo -->
    <img src="img/LOGO.png" alt="Logo de la Galería de Arte" style="width: 200px; height: 200px; margin-bottom: 20px;">

    <!-- Texto y botón -->
    <div class="mt-4">
        <!-- Enlace para redirigir a la página "registroCiudadano.jsp" -->
        <a href="registroCiudadano.jsp" class="btn btn-primary">ENTRAR</a>
    </div>
</body>
</html>
