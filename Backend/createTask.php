<?php
header('Content-Type: application/json; charset=utf8');

$params = array(
    'username',
    'sessionkey',
    'missionid',
	'taskname',
	'description',
	'effort'
);

// returns $paramsCheck - parameters all set true/false
// returns $data - failure message
include 'checkParameters.php';

if ($paramsCheck) {
    $username    = $_POST[$params[0]];
    $sessionkey  = $_POST[$params[1]];
    $missionid   = $_POST[$params[2]];
	$taskname    = $_POST[$params[3]];
	$description = $_POST[$params[4]];
    $effort   	 = $_POST[$params[5]];

    // returns $db - database connection
    // returns $dbCheck - database connection status
    // returns $data - database connection failure message
    include 'connectToDatabase.php';

    if ($dbCheck) {

        // returns $check - authentication status
        // returns $data - authentication failure message
        include 'checkSessionkey.php';

        if($check) {

			//Check if mission exists
			$stmt = $db->prepare('SELECT COUNT(*)
									FROM missions
									WHERE id = ?');
			$stmt->bind_param('i', $missionid);
			$stmt->execute();
			$stmt->bind_result($missionCount);
			$stmt->fetch();
			if ($missionCount == 0) {
				echo json_encode(array('error' => 'Mission does not exist'));
				return;
			}
			$stmt->close();

			//Check if user is member of mission
			$stmt = $db->prepare('SELECT COUNT(*)
									FROM userToMission
									WHERE missionid = ? AND username = ?');
			$stmt->bind_param('is', $missionid, $username);
			$stmt->execute();
			$stmt->bind_result($userToMissionRelationCount);
			$stmt->fetch();
			if ($userToMissionRelationCount == 0) {
				echo json_encode(array('error' => 'The user is not a member of this mission'));
				return;
			}
			$stmt->close();

			//Insert Task into db table tasks
			$stmt = $db->prepare('INSERT
									INTO tasks (missionid, name, description, effort)
									VALUES (?,?,?,?)');
			$stmt->bind_param('issi', $missionid, $taskname, $description, $effort);
			if($stmt->execute()){
				$taskid = $db->insert_id;
				$stmt->close();

				//Get all users in mission
				$stmt = $db->prepare('SELECT username
										FROM userToMission
										WHERE missionid = ?');
				$stmt->bind_param('i', $missionid);
				$stmt->execute();
				$allUsers = $stmt->get_result();
				$stmt->free_result();
				$stmt->close();

				$data = array('response' => 'Task successfully created', 'taskid' => $taskid);
				while($row = mysqli_fetch_array($allUsers)){
					//For every user, create entry in userToTask
					$stmt = $db->prepare('INSERT
											INTO userToTask (username, taskid, completed)
											VALUES (?,?, 0)');
					$stmt->bind_param('si', $row[0], $taskid);
					if(!$stmt->execute()){
						$data = array('response' => 'Task was created, but there was an error assigning every user to the task', 'id' => $taskid);
					}
					$stmt->close();
				}
			}
			else{
				$data = array('error' => 'Task could not be updated');
			}
		}
	}
}
echo json_encode($data);
?>