<?php
    
    $mysqli = new mysqli('localhost:3307', 'root', '', 'papeleria');

    if($mysqli->connect_error){
        
        die('error en la conexion' . $mysqli->connect_error);
    }
?>