<?php
	
	require 'conexionn.php';
	
	$usuario = $_POST['usuario'];
	$nombre_completo = $_POST['nombre_completo'];
	$contraseña = $_POST['contraseña'];
	$repite_contraseña = $_POST['repite_contraseña'];
	$telefono = $_POST['telefono'];
    $correo_electronico = $_POST['correo_electronico'];
	

	
	$sql = "INSERT INTO registro_usuarios(usuario, nombre_completo, contraseña, repite_contraseña, telefono, correo_electronico) VALUES ('$usuario', '$nombre_completo', '$contraseña', '$repite_contraseña', '$telefono', '$correo_electronico')";
	$resultado = $mysqli->query($sql);
	
?>

<html lang="es">
	<head>
		
		<meta name="viewport" content="width=device-width, initial-scale=1">

	</head>
	
	<body>
		<div class="container">
			<div class="row">
				<div class="row" style="text-align:center">
					<?php if($resultado) { ?>
						<h3>REGISTRO GUARDADO</h3>
						<?php } else { ?>
						<h3>ERROR AL GUARDAR</h3>
					<?php } ?>
                    <center><button href="Logiin.html"type="submit" class="btn-primary">Siguiente</button></center>
					
				</div>
			</div>
		</div>
	</body>
</html>
