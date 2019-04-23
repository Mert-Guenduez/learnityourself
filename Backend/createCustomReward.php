<?php
//ini_set('display_errors', 1);
header('Content-Type: application/json; charset=utf8');
$username   = $_POST['username'];
$sessionkey = $_POST['sessionkey'];
$title = $_POST['title'];
$description = $_POST['description'];
$cost = $_POST['cost'];
$db = new mysqli('localhost', 'XXX','XXX', 'XXX');
if ($db->connect_errno > 0) {
    die(json_encode(array('authentication' => 'false', 'error' => 'Unable to connect to database [' . $db->connect_error . ']')));
}
include 'checkSessionkey.php';
$json = json_encode(array('authentication' => 'false', 'error' => 'Authentication failure'));
if($check) {
	$stmt = $db->prepare('INSERT INTO rewards (owner, title, description, cost) VALUES (?,?,?,?)');
    $stmt->bind_param('sssi', $username,$title,$description,$cost);
	if($stmt->execute()){
		$data = array('response' => 'Reward successfully created');
	}
	else{
		$data = array('error' => 'Error while trying to insert into rewards table');
	}
	$json = json_encode($data);
}
echo $json;
?>

