<?php
//ini_set('display_errors', 1);
header('Content-Type: application/json; charset=utf8');

$username   = $_POST['username'];
$sessionkey = $_POST['sessionkey'];
$missionid  = $_POST['missionid'];

$db = new mysqli('localhost', 'XXX', 'XXX', 'XXX');
if ($db->connect_errno > 0) {
    die(json_encode(array('authentication' => 'false', 'error' => 'Unable to connect to database [' . $db->connect_erro$}
if (! isset($_POST['missionid'])) {
    die(json_encode(array('error' => 'mission identification not set')));
}
include 'checkSessionkey.php';
$json = json_encode(array('authentication' => 'false', 'error' => 'Authentication failure'));

if($check) {
    $stmt = $db->prepare('SELECT * FROM missions WHERE id = ?');
    $stmt->bind_param('i', $missionid);
    $stmt->execute();
    $stmt->bind_result($missionid, $owner, $missionname, $description, $deadline);
    $stmt->fetch();
    $taskname = utf8_encode($owner);
    $missionname = utf8_encode($missionname);
    $description = utf8_encode($description);
    $data = array('missionid' => $missionid, 'owner' => $owner, 'missionname' => $missionname, 'description' => $description, 'deadline' => $deadline, 'tasks' => array());
    $stmt->close();

    $stmt = $db->prepare('SELECT tasks.id,tasks.name, userToTask.completed FROM tasks INNER JOIN userToTask ON tasks.id = userToTask.taskid WHERE tasks.missionid = ? AND userToTask.username = ?');
    $stmt->bind_param('is', $missionid, $username);
    $stmt->execute();
    $stmt->bind_result($taskid, $taskname, $completed);
    while ($stmt->fetch()) {
        $taskname = utf8_encode($taskname);
        $taskhead = array('taskid' => $taskid, 'taskname' => $taskname, 'completed' => $completed);
        $data['tasks'][] = $taskhead;
    }
    $stmt->close();
    $json = json_encode($data);
}
echo $json;
?>