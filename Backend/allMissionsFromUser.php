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
    $stmt = $db->prepare('SELECT missionid FROM userToMission WHERE username = ?');
    $stmt->bind_param('s', $username);
    $stmt->execute();
    $missionsToUser = $stmt->get_result();
    $stmt->free_result();
    $stmt->close();

    $stmt = $db->prepare('SELECT * FROM missions WHERE id = ?');
    $data = array('authentication' => 'true', 'missions' => array());
    while ($relation = $missionsToUser->fetch_assoc()) {
        $stmt->bind_param('i', $relation['missionid']);
        $stmt->execute();
        $stmt->bind_result($missionid, $owner, $missionname, $description, $deadline);
        $stmt->fetch();
        $owner = utf8_encode($owner);
        $missionname = utf8_encode($missionname);
        $description = utf8_encode($description);
        $detail = array('missionid' => $missionid, 'owner' => $owner, 'missionname' => $missionname, 'description' => $description, 'deadline' => $deadline);
        $data['missions'][] = $detail;
    }
    $json = json_encode($data);
}
echo $json;
?>
