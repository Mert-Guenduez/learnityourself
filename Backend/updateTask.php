<?php
header('Content-Type: application/json; charset=utf8');

$params = array(
    'username',
    'sessionkey',
    'missionid',
    'taskname',
    'taskid',
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
    $taskid      = $_POST[$params[4]];
    $description = $_POST[$params[5]];
    $effort      = $_POST[$params[6]];

    // returns $db - database connection
    // returns $dbCheck - database connection status
    // returns $data - database connection failure message
    include 'connectToDatabase.php';

    if ($dbCheck) {

        // returns $check - authentication status
        // returns $data - authentication failure message
        include 'checkSessionkey.php';

        if($check) {
            //Check mission
            $stmt = $db->prepare('SELECT COUNT(*)
                                    FROM missions
                                    WHERE id = ?');
            $stmt->bind_param('i', $missionid);
            $stmt->execute();
            $stmt->bind_result($missionCount);
            $stmt->fetch();
            if ($missionCount == 0) {
                echo json_encode(array('error' => 'mission does not exist'));
                return;
            }
            $stmt->close();

            //Check if user is in the mission
            $stmt = $db->prepare('SELECT COUNT(*)
                                    FROM userToMission
                                    WHERE missionid = ? AND username = ?');
            $stmt->bind_param('is', $missionid, $username);
            $stmt->execute();
            $stmt->bind_result($userCount);
            $stmt->fetch();
            if ($userCount == 0) {
                echo json_encode(array('error' => 'The user is not in this mission'));
                return;
            }
            $stmt->close();

            //Check if task is part of the mission
            $stmt = $db->prepare('SELECT COUNT(*)
                                    FROM tasks
                                    WHERE missionid = ? AND id = ?');
            $stmt->bind_param('ii', $missionid, $taskid);
            $stmt->execute();
            $stmt->bind_result($taskInMissionCount);
            $stmt->fetch();
            if ($taskInMissionCount == 0) {
                echo json_encode(array('error' => 'The task is not part of the mission.'));
                return;
            }
            $stmt->close();

            //Update Task
            $stmt = $db->prepare('UPDATE tasks
                                    SET name = ?, description = ?, effort = ?
                                    WHERE id = ?');
            $stmt->bind_param('sssi', $taskname, $description, $effort, $taskid);
            if($stmt->execute()) {
                $data = json_encode(array('response' => 'Task successfully updated'));
            }
            else{
                $data = json_encode(array('error' => 'Task could not be inserted into DBTable tasks'));
            }
            $stmt->close();
        }
    }
}
echo json_encode($data);
?>