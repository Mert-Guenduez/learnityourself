<?php
header('Content-Type: application/json; charset=utf8');

$params = array(
    'username',
    'sessionkey',
    'missionid',
    'adduser'
);

// returns $paramsCheck - parameters all set true/false
// returns $data - failure message
include 'checkParameters.php';

if ($paramsCheck) {
    $username   = $_POST[$params[0]];
    $sessionkey = $_POST[$params[1]];
    $missionid  = $_POST[$params[2]];
    $adduser    = $_POST[$params[3]];

    // returns $db - database connection
    // returns $dbCheck - database connection status
    // returns $data - database connection failure message
    include 'connectToDatabase.php';

    if ($dbCheck) {

        // returns $check - authentication status
        // returns $data - authentication failure message
        include 'checkSessionkey.php';

        if($check) {

            // Check if mission exists
            $stmt = $db->prepare('SELECT COUNT(*)
                                    FROM missions
                                    WHERE id = ?');
            $stmt->bind_param('i',$missionid);
            $stmt->execute();
            $stmt->bind_result($missionCount);
            $stmt->fetch();

            if ($missionCount == 0) {
                echo json_encode(array('response' => 'Mission does not exist'));
                return;
            }
            $stmt->close();

            // Check if user exists
            $stmt = $db->prepare('SELECT COUNT(*)
                                    FROM users
                                    WHERE user_name = ?');
            $stmt->bind_param('s',$adduser);
            $stmt->execute();
            $stmt->bind_result($userCount);
            $stmt->fetch();

            if ($userCount == 0) {
                echo json_encode(array('response' => 'User does not exist'));
                return;
            }
            $stmt->close();

            // Check if user is already member of the mission
            $stmt = $db->prepare('SELECT COUNT(*)
                                    FROM userToMission
                                    WHERE username = ? AND missionid = ?');
            $stmt->bind_param('si',$adduser,$missionid);
            $stmt->execute();
            $stmt->bind_result($userMissionCount);
            $stmt->fetch();

            if ($userMissionCount == 1) {
                echo json_encode(array('response' => 'User already in mission'));
                return;
            }
            $stmt->close();

            // Add user to mission
            $stmt = $db->prepare('INSERT INTO userToMission (username, missionid)
                                    VALUES (?,?)');
            $stmt->bind_param('si',$adduser,$missionid);
            if($stmt->execute()) {
                $stmt->close();

                // Get tasks from mission
                $stmt = $db->prepare("SELECT id
                                        FROM tasks
                                        WHERE missionid = ?");
                $stmt->bind_param('i', $missionid);
                $stmt->execute();
                $taskList = $stmt->get_result();
                $stmt->free_result();
                $stmt->close();

                // Add tasks from mission to user
                $stmt = $db->prepare("INSERT INTO userToTask (username, taskid, completed)
                                        VALUES (?,?,0)");
                while($singleTask = $taskList->fetch_assoc()) {
                    $stmt->bind_param('si', $username, $singleTask['id']);
                    $stmt->execute();
                }
                $data = array('response' => 'User successfully added');
            } else {
                $data = array('response' => 'DB Error');
            }
            $stmt->close();
        }
    }
}
$json = json_encode($data);
echo $json;
?>