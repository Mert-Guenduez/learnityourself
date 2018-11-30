<?php
header('Content-Type: application/json;charset=utf-8');

$username   = $_POST['username'];
$matchuser   = $_POST['matchuser'];
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
    if (! isset($_POST['matchuser'])) {
        $matchUser = '';
    }
	$stmt = $db->prepare('SELECT user_name FROM users WHERE user_name LIKE ?');
    $matchuser = '%' . $matchuser . '%';
	$stmt->bind_param('s', $matchuser);
	$stmt->execute();
	$stmt->bind_result($username);

	$data = array();
	while($stmt->fetch()) {
	    $username = utf8_encode($username);
	    $data[] = array('username' => $username);
	}
    $stmt->close();
	$json = json_encode($data);
}
echo $json;
?>
