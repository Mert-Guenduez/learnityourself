<?php
//ini_set('display_errors', 1);
header('Content-Type: application/json; charset=utf8');
$username   = $_POST['username'];
$sessionkey = $_POST['sessionkey'];
$missionid  = $_POST['missionid'];
$taskname  = $_POST['taskname'];
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
	//Insert Task into tasks
    $stmt = $db->prepare('INSERT INTO tasks (missionid, name, description, effort) VALUES (?,?,?,?)');
    $stmt->bind_param('ssss',$missionid,$taskname,$description,$effort);
    if($stmt->execute()){
		$taskid = $db->insert_id;
		$stmt->close();
		//Get all users in mission
		$stmt = $db->prepare('SELECT username FROM userToMission WHERE missionid = ?');
		$stmt->bind_param('s',$missionid);
		$stmt->execute();
		$allUsers = $stmt->get_result();
		$stmt->free_result();
		$stmt->close();
		$data = json_encode(array('response' => 'Task successfully created'));
		while($row = mysqli_fetch_array($allUsers)){
			//For every user, create entry in userToTask
			$stmt = $db->prepare('INSERT INTO userToTask (username, taskid, completed) VALUES (?,?, 0)');
			$stmt->bind_param('ss',$row[0], $taskid);
			if(!$stmt->execute()){
				$data = json_encode(array('response' => 'Task was created, but there was an error assigning every user to the task'));
			}
			$stmt->close();
		}
	}
	else{
		$data = json_encode(array('error' => 'Task could not be inserted into DBTable tasks'));
	}
    $json = json_encode($data);
}
echo $json;
?>