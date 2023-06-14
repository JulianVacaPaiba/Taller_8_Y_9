<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <!--Charset para caracteres especiales -->
    <meta charset="utf-8">
    <!-- autor -->
    <meta name="autor" content="Julian Vaca">
    <!-- desccripcion -->
    <meta name="descripcion" content="">
    <!--Keywords/palabras clave-->
    <meta name="keywords"content="Resgistro, formulario, formulario de registro,Registro de usuario, crear cuenta">
    <!-- minimum responsive viewport -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Registro y ingreso de usuario</title>
    <link rel="stylesheet" href="../css/Stylee.css">
    <!-- Bootstrap css / icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</head>
<body class="text-center">
<div class="container">
    <header><h1>Resgistrate</h1></header>
    <nav></nav>
    <section>
        <main class="form-signin w-100 m-auto">
            <form action="../user-register" method="post">
                <img src="../img/Si.png" alt="My app" class="mb-4" width="200px">
                <h4>My App</h4>
                <div class="form-floating">
                    <input type="text" class="form-control" name="user_firstname" id="floatingfirsname"placeholder="Ingrese su nombre"
                           required pattern="[A-Za-z0-9]{2,40}">
                    <label for="floatingfirsname">Nombre</label>
                </div>
                <br>
                <div class="form-floating">
                    <input type="text" class="form-control" name="user_lastname" id="floatingLastname"placeholder="Ingrese su apellido"
                           required pattern="[A-Za-z0-9]{2,40}">
                    <label for="floatingLastname">Apellido</label>
                </div>
                <br>
                <div class="form-floating">
                    <input type="email" class="form-control" name="user_email" id="floatingEmail"placeholder="Ingrese su Gmail"
                           required autofocus>
                    <label for="floatingEmail">Gmail</label>
                </div>
                <br>
                <div class="form-floating">
                    <input type="password" class="form-control"  name="user_password" id="floatingPassword"placeholder="Ingrese su contraseña"
                           required pattern="[A-Za-z0-9]{8,12}">
                    <label for="floatingPassword">Contraseña</label>
                </div>
                <br>
                <button class="w-50 btn btn-lg btn-primary"type="submit">Ingresar</button>
                <div>
                    <a href="#">Registrarse</a>
                </div>
                <p class="mt-3 mb-3 text-muted">Todos los derechos reservados JV ©<%=displayDate()%></p>
            </form>

        </main>
    </section>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
<%!
    public String displayDate() {
        SimpleDateFormat dateFormat=new SimpleDateFormat("YYYY");
        Date date= Calendar.getInstance().getTime();
        return dateFormat.format(date);
    }
%>
</body>
</html>