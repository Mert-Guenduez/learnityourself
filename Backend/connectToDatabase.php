<?php
$dbCheck = true;
$db = new mysqli('localhost', 'DB_USER', 'DB_PWD', 'DB_NAME');
if ($db->connect_errno > 0) {
    $dbCheck = false;
    $data = array('db_authentication' => 'false', 'error' => 'Unable to connect to database [' . $db->connect_error . ']');
}
?>