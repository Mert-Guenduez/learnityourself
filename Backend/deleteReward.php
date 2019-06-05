<?php
header('Content-Type: application/json; charset=utf8');

$params = array(
    'username',
    'sessionkey',
    'rewardid'
);

// returns $paramsCheck - parameters all set true/false
// returns $data - failure message
include 'checkParameters.php';

if ($paramsCheck) {
    $username   = $_POST[$params[0]];
    $sessionkey = $_POST[$params[1]];
    $rewardid   = $_POST[$params[2]];

    // returns $db - database connection
    // returns $dbCheck - database connection status
    // returns $data - database connection failure message
    include 'connectToDatabase.php';

    if ($dbCheck) {

        // returns $check - authentication status
        // returns $data - authentication failure message
        include 'checkSessionkey.php';

        if($check) {

            $stmt = $db->prepare('DELETE
                                    FROM rewards
                                    WHERE rewardid = ? AND owner = ?');
            $stmt->bind_param('is', $rewardid, $username);
            if($stmt->execute()){
                $data = array('response' => 'Reward successfully deleted');
            }
            else{
                $data = array('response' => 'There was an error deleting the reward. Maybe you are trying to delete someone elses reward?');
            }
            $stmt->close();
        }
    }
}
echo json_encode($data);
?>