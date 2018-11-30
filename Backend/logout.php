<?php
header('Content-Type: application/json;charset=utf-8');

$username   = $_POST['username'];
$sessionkey = $_POST['sessionkey'];

$db = new mysqli('localhost', 'XXX', 'XXX', 'XXX');
if ($db->connect_errno > 0) {
    die(json_encode(array('authentication' => 'false', 'error' => 'Unable to connect to database [' . $db->connect_error . ']')));
}
if (! isset($_POST['username'])) {
    die(json_encode(array('authentication' => 'false', 'error' => 'username not set')));
}

include 'checkSessionkey.php';
$json = json_encode(array('authentication' => 'false', 'error' => 'Authentication failure'));

if ($check) {
    $stmt = $db->prepare("UPDATE users SET session_timeout=? WHERE user_name=?");
    $time_now = date('Y-m-d H:i:s', time());
    $stmt->bind_param('ss', $time_now, $username);
    $stmt->execute();
    $stmt->close();
    $json = json_encode(array('response' => 'successful'));
}
echo $json;
?>
