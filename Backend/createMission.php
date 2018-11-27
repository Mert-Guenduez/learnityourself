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
    $stmt = $db->prepare('SELECT COUNT(*) FROM missions');
    $stmt->execute();
    $result = $stmt->get_result();
    $rowcount = mysqli_fetch_row($result);
    $stmt->free_result();
    $stmt->close();
	if($rowcount[0] >=3000){
        $json = json_encode(array('error' => 'DB limit of 3000 Missions reached'));
	}
	else{
        $missionname = $_POST["missionname"];
        $description = $_POST["description"];
        $seconds = $_POST["seconds"];
        //prevent sql injection
        $stmt = $db->prepare("INSERT INTO missions (owner, missionname, description, deadline)
                VALUES (?,?,?,(NOW()+INTERVAL ? SECOND))");
        $stmt->bind_param('ssss', $username,$missionname,$description,$seconds);
        if($stmt->execute()){
			$missionid = $db->insert_id;
			$stmt->close();
			$stmt = $db->prepare("INSERT INTO userToMission (username, missionid)
                VALUES (?,?)");
			$stmt->bind_param('ss',$username,$missionid);
			if($stmt->execute()){
				$data = array('response' => 'Mission successfully created');
			}
			else{
				$data = array('error' => 'Error while trying to insert into DBTable userToMission');
			}
        }
        else{
            $data = array('error' => 'Error while trying to insert into DBTable missions');
        }
	}
    $json = json_encode($data);
}
echo $json;
?>
