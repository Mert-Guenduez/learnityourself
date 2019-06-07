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

            $stmt = $db->prepare('SELECT username
                                    FROM userToMission
                                    WHERE missionid = ?');
            $stmt->bind_param('i', $missionid);
            $stmt->execute();
            $allUsers = $stmt->get_result();
            $stmt->free_result();
            $stmt->close();

            $data = array();
            while($row = mysqli_fetch_array($allUsers)){
                $resultArray = array('username' => $row[0]);
                $data[] = $resultArray;
            }
        }
    }
}
echo json_encode($data);
?>