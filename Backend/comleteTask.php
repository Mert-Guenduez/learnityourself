<?php
//ini_set('display_errors', 1);
header('Content-Type: application/json; charset=utf8');
$username   = $_POST['username'];
$sessionkey = $_POST['sessionkey'];
$taskid  = $_POST['taskid'];

$db = new mysqli('localhost', 'XXX', 'XXX', 'learnityourself');
if ($db->connect_errno > 0) {
    die(json_encode(array('authentication' => 'false', 'error' => 'Unable to connect to database [' . $db->connect_error . ']')));
}
if (! isset($_POST['taskid'])) {
    die(json_encode(array('error' => 'task id not set')));
}
include 'checkSessionkey.php';
$json = json_encode(array('authentication' => 'false', 'error' => 'Authentication failure'));
if($check) {
        //Check if user is assigned to task
        $stmt = $db->prepare('SELECT COUNT(*) FROM userToTask WHERE taskid = ? AND username = ?');
    $stmt->bind_param('is',$taskid, $username);
    $stmt->execute();
    $stmt->bind_result($count);
    $stmt->fetch();
    if ($count == 0) {
        die(json_encode(array('error' => 'The task is not assigned to the user')));
    }
    $stmt->close();
        //Check completed
    $stmt = $db->prepare('UPDATE userToTask SET completed = 1 WHERE taskid = ?');
    $stmt->bind_param('i',$taskid);
    if($stmt->execute()){
                $stmt->close();
                $data = json_encode(array('response' => 'Task successfully updated'));
        }
        else{
                $data = json_encode(array('error' => 'Task could not be updated'));
        }
    $json = json_encode($data);
}
echo $json;
?>