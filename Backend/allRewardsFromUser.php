<?php
//ini_set('display_errors', 1);
header('Content-Type: application/json; charset=utf8');
$username   = $_POST['username'];
$sessionkey = $_POST['sessionkey'];
$db = new mysqli('localhost', 'XXX','XXX', 'XXX');
if ($db->connect_errno > 0) {
    die(json_encode(array('authentication' => 'false', 'error' => 'Unable to connect to database [' . $db->connect_error . ']')));
}
include 'checkSessionkey.php';
$json = json_encode(array('authentication' => 'false', 'error' => 'Authentication failure'));
if($check) {
$stmt = $db->prepare('SELECT rewardid, title, description, cost FROM rewards WHERE owner = ?');
    $stmt->bind_param('s', $username);
    $stmt->execute();
    $allRewards = $stmt->get_result();
    $stmt->free_result();
    $stmt->close();
    $data = array();
    while($row = mysqli_fetch_array($allRewards)){
    $resultArray = array('rewardid' => $row[0], 'title' => $row[1], 'description' => $row[2], 'cost' => $row[3]);
    $data[] = $resultArray;
}
    $json = json_encode($data);
}
echo $json;
?>
