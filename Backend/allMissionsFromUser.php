<?php
header('Content-Type: application/json; charset=utf8');

$params = array(
    'username',
    'sessionkey'
);

// returns $paramsCheck - parameters all set true/false
// returns $data - failure message
include 'checkParameters.php';

if ($paramsCheck) {
    $username   = $_POST[$params[0]];
    $sessionkey = $_POST[$params[1]];

    // returns $db - database connection
    // returns $dbCheck - database connection status
    // returns $data - database connection failure message
    include 'connectToDatabase.php';

    if ($dbCheck) {

        // returns $check - authentication status
        // returns $data - authentication failure message
        include 'checkSessionkey.php';

        if($check) {

            // Get List of all missions from user
            $stmt = $db->prepare('SELECT missionid
                                    FROM userToMission
                                    WHERE username = ?');
            $stmt->bind_param('s', $username);
            $stmt->execute();
            $missionsToUser = $stmt->get_result();
            $stmt->free_result();
            $stmt->close();

            // Get details from missions
            $stmt = $db->prepare('SELECT id, missionname, deadline
                                    FROM missions
                                    WHERE id = ?');
            $data = array();
            while ($relation = $missionsToUser->fetch_assoc()) {
                $stmt->bind_param('i', $relation['missionid']);
                $stmt->execute();
                $stmt->bind_result($missionid, $missionname, $deadline);
                $stmt->fetch();

                $missionname = utf8_encode($missionname);
                $details = array(
                    'missionid' => $missionid,
                    'missionname' => $missionname,
                    'deadline' => $deadline);

                $data[] = $details;
            }
            $stmt->close();
        }
    }
}
echo json_encode($data);
?>
