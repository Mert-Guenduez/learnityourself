<?php
//ini_set('display_errors', 1);
header('Content-Type: application/json; charset=utf8');
$username   = $_POST['username'];
$sessionkey = $_POST['sessionkey'];
$rewardid = $_POST['rewardid'];
$title = $_POST['title'];
$description = $_POST['description'];
$cost = $_POST['cost'];
$db = new mysqli('localhost', 'XXX','XXX', 'XXX');
if ($db->connect_errno > 0) {
    $data = array('authentication' => 'false', 'error' => 'Unable to connect to database [' . $db->connect_error . ']');
}
else{
include 'checkSessionkey.php';
$json = json_encode(array('authentication' => 'false', 'error' => 'Authentication failure'));

if($check) {
$stmt = $db->prepare('UPDATE rewards SET title = ?, description = ?, cost = ? WHERE rewardid = ? AND owner = ?');
    $stmt->bind_param('ssiis',$title,$description,$cost, $rewardid, $username);
        if($stmt->execute()){
                $data = array('response' => 'Reward successfully updated');
        }
        else{
                $data = array('error' => 'Error while trying to update rewards. Maybe you are trying to update someone elses reward?');

        }
    $stmt->close();
    $json = json_encode($data);
}
}
echo $json;
?>

