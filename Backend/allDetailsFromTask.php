<?php
header('Content-Type: application/json; charset=utf8');

$params = array(
    'username',
    'sessionkey',
    'taskid'
);

// returns $paramsCheck - parameters all set true/false
// returns $data - failure message
include 'checkParameters.php';

if ($paramsCheck) {
    $username   = $_POST[$params[0]];
    $sessionkey = $_POST[$params[1]];
    $taskid     = $_POST[$params[2]];

    // returns $db - database connection
    // returns $dbCheck - database connection status
    // returns $data - database connection failure message
    include 'connectToDatabase.php';

    if ($dbCheck) {

        // returns $check - authentication status
        // returns $data - authentication failure message
        include 'checkSessionkey.php';

        if($check) {

            $stmt = $db->prepare('SELECT *
                                    FROM tasks
                                    WHERE id = ?');
            $stmt->bind_param('i', $taskid);
            $stmt->execute();
            $stmt->bind_result($taskid, $missionid, $name, $description, $effort);
            $stmt->fetch();
            $stmt->close();

            $description = utf8_encode($description);
            $name = utf8_encode($name);

            $data = array(
                'taskid' => $taskid,
                'missionid' => $missionid,
                'name' => $name,
                'description' => $description,
                'effort' => $effort);
        }
    }
}
echo json_encode($data);
?>
