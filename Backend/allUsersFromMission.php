<?php
//ini_set('display_errors', 1);
header('Content-Type: application/json; charset=utf8');
$username   = $_POST['username'];
$sessionkey = $_POST['sessionkey'];
$db = new mysqli('localhost', 'XXX', 'XXX', 'XXX');
if ($db->connect_errno > 0) {
    die(json_encode(array('authentication' => 'false', 'error' => 'Unable to connect to database [' . $db->connect_error . ']')));
}
include 'checkSessionkey.php';
$json = json_encode(array('authentication' => 'false', 'error' => 'Authentication failure'));
if($check) {
    $missionid   = $_POST['missionid'];
    $stmt = $db->prepare('SELECT username FROM userToMission WHERE missionid = ?');
    $stmt->bind_param('s', $missionid);
    $stmt->execute();
    $allUsers = $stmt->get_result();
    $stmt->free_result();
    $stmt->close();
    $data = array();
    while($row = mysqli_fetch_array($allUsers)){
    $resultArray = array('username' => $row[0]);
    $data[] = $resultArray;
}}
$json = json_encode($data);
echo $json;
?>

