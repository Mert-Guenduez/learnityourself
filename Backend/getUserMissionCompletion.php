<?php
ini_set('display_errors', 1);
header('Content-Type applicationjson; charset=utf8');
$username   = $_POST['username'];
$sessionkey = $_POST['sessionkey'];
$missionid  = $_POST['missionid'];
$db = new mysqli('localhost', 'XXX', 'XXX', 'XXX');
if ($db-connect_errno  0) {
    $data = array('authentication' = 'false', 'error' = 'Unable to connect to database [' . $db-connect_error . ']');
}
else {
if (! isset($_POST['missionid'])) {
    $data = array('error' = 'mission identification not set');
}
else {
include 'checkSessionkey.php';
$json = json_encode(array('authentication' = 'false', 'error' = 'Authentication failure'));
if($check) {
    $stmt = $db-prepare('SELECT userToTask.username, COUNT() FROM tasks INNER JOIN userToTask ON tasks.id = userToTask.taskid WHERE tasks.missionid =  AND userToTask.completed  = 1 GROUP BY userToTask.username');
$stmt-bind_param('i', $missionid);
    $stmt-execute();

    $UserAmounts = $stmt-get_result();
    $stmt-free_result();
    $stmt-close();
    $data = array();
    while($row = mysqli_fetch_array($UserAmounts)){
    $resultArray = array('username' = $row[0], 'amount' = $row[1]);
    $data[] = $resultArray;
}

    $json = json_encode($data);
}}}
echo $json;
?>

