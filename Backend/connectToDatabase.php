<?php
$dbCheck = true;
$db = new mysqli('localhost', 'dblover', 'DDBPw1mnmk1337', 'learnityourself');
if ($db->connect_errno > 0) {
    $dbCheck = false;
    $data = array('authentication' => 'false', 'error' => 'Unable to connect to database [' . $db->connect_error . ']');
}
?>