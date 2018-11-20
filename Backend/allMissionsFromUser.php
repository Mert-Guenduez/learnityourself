<?php
header('Content-Type: application/json;charset=utf-8');

$username   = $_POST['username'];
$sessionkey = $_POST['sessionkey'];

$db = new mysqli('localhost', 'dblover', 'DDBPw1mnmk1337', 'learnityourself');
if ($db->connect_errno > 0) {
	die(json_encode(array('authentication' => 'false', 'error' => 'Unable to connect to database [' . $db->connect_error . ']')));
}

include 'checkSessionkey.php';

if($check) {
    $stmt = $db->prepare('SELECT missionid FROM userToMission WHERE username = ?');
    $stmt->bind_param('s', $username);
    $stmt->execute();
    $stmt->bind_result($missionid);
    $missions = $stmt->get_result();
    $stmt->free_result();
    $stmt->close();

    $stmt = $db->prepare('SELECT * FROM missions WHERE id = ?');
    $data = array('authentication' => 'true', 'missions' => array());
    while ($missionid = $missions->fetch_row()) {
        $stmt->bind_param('i', $missionid[0]);
        $stmt->execute();
        $stmt->bind_result($missionid, $owner, $missionname, $description, $deadline);
        $stmt->store_result();
        $stmt->fetch();
        $data['missions'][] = array('missionId' => $missionid, 'owner' => $owner, 'missionname' => $missionname, 'description' => $description, 'deadline' => $deadline);
    }
    $json = json_encode($data);
} else {
	$json = json_encode(array('authentication' => 'false', 'error' => 'Authentication failure'));
}
echo $json;
?>