<?php
header('Content-Type: application/json; charset=utf8');

$params = array(
    'username',
    'sessionkey',
    'missionid'
);

// returns $paramsCheck - parameters all set true/false
// returns $data - failure message
include 'checkParameters.php';

if ($paramsCheck) {
    $username   = $_POST[$params[0]];
    $sessionkey = $_POST[$params[1]];
    $missionid  = $_POST[$params[2]];

    // returns $db - database connection
    // returns $dbCheck - database connection status
    // returns $data - database connection failure message
    include 'connectToDatabase.php';

    if ($dbCheck) {

        // returns $check - authentication status
        // returns $data - authentication failure message
        include 'checkSessionkey.php';

        if($check) {

            // Get Details about mission
            $stmt = $db->prepare('SELECT *
                                    FROM missions
                                    WHERE id = ?');
            $stmt->bind_param('i', $missionid);
            $stmt->execute();
            $stmt->bind_result($missionid, $owner, $missionname, $description, $deadline);
            $stmt->fetch();
            $stmt->close();

            $owner = utf8_encode($owner);
            $missionname = utf8_encode($missionname);
            $description = utf8_encode($description);

            $data = array(
                'missionid' => $missionid,
                'owner' => $owner,
                'missionname' => $missionname,
                'description' => $description,
                'deadline' => $deadline,
                'tasks' => array());
            
            // Get details about tasks from mission
            $stmt = $db->prepare('SELECT tasks.id, tasks.name, userToTask.completed
                                    FROM tasks
                                        INNER JOIN userToTask
                                            ON tasks.id = userToTask.taskid
                                    WHERE tasks.missionid = ? AND userToTask.username = ?');
            $stmt->bind_param('is', $missionid, $username);
            $stmt->execute();
            $stmt->bind_result($taskid, $taskname, $completed);
            while ($stmt->fetch()) {
                $taskname = utf8_encode($taskname);
                $task = array('taskid' => $taskid, 'taskname' => $taskname, 'completed' => ($completed == 0 ? 'false' : 'true'));
                $data['tasks'][] = $task;
            }
            $stmt->close();
        }
    }
}
echo json_encode($data);
?>

