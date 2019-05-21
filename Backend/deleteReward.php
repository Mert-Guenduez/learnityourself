<?php
ini_set('display_errors', 1);
header('Content-Type: application/json; charset=utf8');
$username   = $_POST['username'];
$sessionkey = $_POST['sessionkey'];
$rewardid = $_POST['rewardid'];
$db = new mysqli('localhost', 'XXX', 'XXX', 'XXX');
if ($db->connect_errno > 0) {
    $data = array('authentication' => 'false', 'error' => 'Unable to connect to database [' . $db->connect_error . ']');
}
else{
include 'checkSessionkey.php';
$json = json_encode(array('authentication' => 'false', 'error' => 'Authentication failure'));
if($check) {
    $stmt = $db->prepare('DELETE FROM rewards WHERE rewardid = ? AND owner = ?');
    $stmt->bind_param('is', $rewardid, $username);
    if($stmt->execute()){
    $data = array('response' => 'Reward successfully deleted');
    }
    else{
    $data = array('response' => 'There was an error deleting the reward. Maybe you are trying to delete someone elses reward?');
    }
    $stmt->close();
}}
$json = json_encode($data);
echo $json;
?>





