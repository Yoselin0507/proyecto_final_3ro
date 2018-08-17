<?php
$usuario=$_POST['usuario'];
$contraseña=$_POST['contraseña'];
 
//conectar a la base de datos
$conexion=mysqli_connect("localhost:3307", "root", "", "papeleria");
$consulta="SELECT * FROM registros_de_usuarios WHERE usuario='$usuario' and contraseña='$contraseña'";
$resultado=mysqli_query($conexion, $consulta);

$filas=mysqli_num_rows($resultado);
if ($filas>0) {
  header("location:bienvenidos.htlm");
}
else {
    echo "Error en la autentificacion";
}
mysqli_free_result($resultado);
mysqli_close($conexion);