<DOCTYPE html>
    <hml>
        <header>
        <title>Cerrar Sesi&oacute;n</title>
        </header>
        <body>
            <?php
            #session_star -Iniciar una nueva sesion o reanudar la existente.
            session_start();
            #session_destroy-Destruye toda la informacion registrada de una sesion.
            session_destroy();
            #header-Enviar encabezado sin formato HTTP
            header("Location:Logiin.html");
            ?>
        </body>
    </hml>
</DOCTYPE>