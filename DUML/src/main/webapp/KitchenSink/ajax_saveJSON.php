<?php

$json=json_encode($_POST['datos']);



$file = fopen("archivo.txt", "w");

fwrite($file, $json . PHP_EOL);


fclose($file);
?>