<!DOCTYPE html>
<html>
    <head>
        <title></title>
    </head>
    <body>
    <?php
        try
        {
            # Las conexiones se establecen creando instancias de la clase base PDO. El constructor acepta parámetros para especificar el origen de la base de datos  (conocido como DNS) y, opcionalmente, el nombre de usuario y la contraseña (si la hubiera).
            $conMySQL = new PDO("mysql:host=localhost; port=3307; dbname=papeleria", "root","");
            # PDO::set Attribute - Establece un atributo.
            $conMySQL->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            $conMySQL->exec("SET CHARACTER SET UTF8");
            $sentenciasSQL = "SELECT * FROM registro_usuarios WHERE usuario = :login AND contraseña = :passw";
            #PDO::prepare - preparar una sentencia para ejecución y devuelve un objeto sentencia.
            $sentenciaPrep = $conMySQL ->prepare ($sentenciasSQL);
            # htmlspecialchars - Convierte caracteres especiales en entidades HTML.
            # addslashes - Escapa un string con barras invertidas.
           $log=htmlspecialchars(addslashes($_POST["usuario"]));
           $pas=htmlspecialchars(addslashes($_POST["contraseña"]));
            # PDOStatement::execute - Ejecutar una sentencia preparada.
            $sentenciaPrep->execute(array(":login"=>$log, ":passw"=>$pas));
            # PDOStatement::rowCount -Devuelve el número de filas afectadas en la sentencia SQL.
            $numRegistros = $sentenciaPrep->rowCount();
            if ($numRegistros !=0)
            {
              session_start();
                $_SESSION["usuario"]=$_POST["usuario"];
                header("Location:zona-vip.php");
            }
            else    
            {
                #header - Enviar encabezado sin formato HTTP.
                header("Location:Logiin.html");
            }  
        }
        catch(Exception $e)
        {
            #die o exit -Imprime unmensaje y termina el script actual.
            die("Error: " . $e->getMessage());
        }
        finally{    $conMySQL = null;   }
        ?>
        </body>
</html>