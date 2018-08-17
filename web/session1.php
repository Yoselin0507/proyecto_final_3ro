<DOCTYPE html>
    <html>
        <head>
            <title>Zona VIP</title>
        </head>
        <body>
            <?php
            #session_star -Iniciar una nueva sesion o reanudar la existente.
            session_start();
            ##isset -Determina si una variable esta definida y no es NULL.
            #$_SESSION-Variables de sesion.
            if (!isset($SESSION["usuario"]))
            {
                #header-Enviar encabezado sin formato HTTP
                header("Location:Logiin.html");
            }
            ?>
            <h1>Zona VIP</h1>
            <?php
            #printf-Imprimir una cadena con formato
            printf("usuario: %s", $_SESSION["usuario"]);
            ?>
            <br><a href="session1.php">cerrar Sesi&oacute;n</a>
        </body>
    </html>