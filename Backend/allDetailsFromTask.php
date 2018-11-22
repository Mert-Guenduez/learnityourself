<?php
//ini_set('display_errors', 1);
header('Content-Type: application/json; charset=utf8');

$username   = $_POST['username'];
$sessionkey = $_POST['sessionkey'];
$taskid     = $_POST['taskid'];

$db = new mysqli('localhost', 'XXX', 'XXX', 'XXX');
if ($db->connect_errno > 0) {
    die(json_encode(array('authentication' => 'false', 'error' => 'Unable to connect to database [' . $db->connect_error . ']')));
}
if (! isset($_POST['taskid'])) {
    die(json_encode(array('error' => 'task identification not set')));
}
include 'checkSessionkey.php';
$json = json_encode(array('authentication' => 'false', 'error' => 'Authentication failure'));

if($check) {
    $stmt = $db->prepare('SELECT * FROM tasks WHERE id = ?');
    $stmt->bind_param('s', $taskid);
    $stmt->execute();
    $stmt->bind_result($taskid,$missionid, $name, $description, $effort);
    $stmt->fetch();

    $description = utf8_encode($description);
    $name = utf8_encode($name);
    $details = array('taskid' => $taskid, 'missionid' => $missionid, 'name' => $name, 'description' => $description, 'effort' => $effort);

    $stmt->close();
    $json = json_encode($details);
}
echo $json;
?>
