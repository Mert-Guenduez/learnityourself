<?php
header('Content-Type: application/json; charset=utf8');

$username   = $_POST['username'];
$sessionkey = $_POST['sessionkey'];
$missionid  = $_POST['missionid'];
$adduser    = $_POST['adduser'];

$db = new mysqli('localhost', 'XXX', 'XXX', 'XXX');

if ($db->connect_errno > 0) {
    die(json_encode(array('authentication' => 'false', 'error' => 'Unable to connect to database [' . $db->connect_error . ']')));
}
if (! isset($_POST['missionid'])) {
    die(json_encode(array('error' => 'mission id not set')));
}
if (! isset($_POST['adduser'])) {
    die(json_encode(array('error' => 'user to add not set')));
}
include 'checkSessionkey.php';
$json = json_encode(array('authentication' => 'false', 'error' => 'Authentication failure'));

if($check) {
    // check if mission exists
    $stmt = $db->prepare('SELECT COUNT(*) FROM missions WHERE id = ?');
    $stmt->bind_param('i',$missionid);
    $stmt->execute();
    $stmt->bind_result($count);
    $stmt->fetch();
    if ($count == 0) {
        die(json_encode(array('error' => 'mission does not exist')));
    }
    $stmt->close();

    // check if user exists
    $stmt = $db->prepare('SELECT COUNT(*) FROM users WHERE user_name = ?');
    $stmt->bind_param('s',$adduser);
    $stmt->execute();
    $stmt->bind_result($count);
    $stmt->fetch();
    if ($count == 0) {
        die(json_encode(array('error' => 'user does not exist')));
    }
    $stmt->close();

    // check if user was already added to mission
    $stmt = $db->prepare('SELECT COUNT(*) FROM userToMission WHERE username = ? AND missionid = ?');
    $stmt->bind_param('si',$adduser,$missionid);
    $stmt->execute();
    $stmt->bind_result($count);
    $stmt->fetch();
    if ($count != 0) {
        die(json_encode(array('error' => 'user already in mission')));
    }
    $stmt->close();

    // add user to mission
    $stmt = $db->prepare("INSERT INTO userToMission (username, missionid) VALUES (?,?)");
    $stmt->bind_param('si',$adduser,$missionid);
    if($stmt->execute()) {
        $stmt->close();

        // get tasks from mission
        $stmt = $db->prepare("SELECT id FROM tasks WHERE missionid = ?");
        $stmt->bind_param('i', $missionid);
        $stmt->execute();
        $tasks = $stmt->get_result();
        $stmt->free_result();
        $stmt->close();

        // add tasks from mission to user
        $stmt = $db->prepare("INSERT INTO userToTask (username, taskid, completed) VALUES (?,?,?)");
        $completed = 0;
        while($task = $tasks->fetch_assoc()) {
            $stmt->bind_param('sii',$username, $task['id'], $completed);
            $stmt->execute();
        }

        $data = array('response' => 'User successfully added');
    } else {
        $data = array('error' => 'Error while trying to insert into DBTable userToMission');
    }
    $stmt->close();

    $json = json_encode($data);
}
echo $json;
?>