<?php
//ini_set('display_errors', 1);
header('Content-Type: application/json; charset=utf8');
$username   = $_POST['username'];
$sessionkey = $_POST['sessionkey'];
$missionid  = $_POST['missionid'];
$taskname  = $_POST['taskname'];
$taskid  = $_POST['taskid'];
$description    = $_POST['description'];
$effort   = $_POST['effort'];
$db = new mysqli('localhost', 'XXX', 'XXX', 'XXX');
if ($db->connect_errno > 0) {
    die(json_encode(array('authentication' => 'false', 'error' => 'Unable to connect to database [' . $db->connect_error . ']')));
}
if (! isset($_POST['missionid'])) {
    die(json_encode(array('error' => 'mission id not set')));
}
if (! isset($_POST['taskname'])) {
    die(json_encode(array('error' => 'taskname not set')));
}
include 'checkSessionkey.php';
$json = json_encode(array('authentication' => 'false', 'error' => 'Authentication failure'));
if($check) {
	//Check mission
    $stmt = $db->prepare('SELECT COUNT(*) FROM missions WHERE id = ?');
    $stmt->bind_param('i',$missionid);
    $stmt->execute();
    $stmt->bind_result($count);
    $stmt->fetch();
    if ($count == 0) {
        die(json_encode(array('error' => 'mission does not exist')));
    }
    $stmt->close();
	//Check if user is in the mission
	$stmt = $db->prepare('SELECT COUNT(*) FROM userToMission WHERE missionid = ? AND username = ?');
    $stmt->bind_param('ss',$missionid, $username);
    $stmt->execute();
    $stmt->bind_result($count);
    $stmt->fetch();
    if ($count == 0) {
        die(json_encode(array('error' => 'The user is not in this mission')));
    }
    $stmt->close();
	//Update Task
    $stmt = $db->prepare('UPDATE tasks SET name = ?, description = ?, effort = ? WHERE id = ?');
    $stmt->bind_param('ssss',$taskname,$description,$effort,$taskid);
    if($stmt->execute()){
		$stmt->close();
		$data = json_encode(array('error' => 'Task successfully updated'));
	}
	else{
		$data = json_encode(array('error' => 'Task could not be inserted into DBTable tasks'));
	}
    $json = json_encode($data);
}
echo $json;
?>