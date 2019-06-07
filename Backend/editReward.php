<?php
header('Content-Type: application/json; charset=utf8');

$params = array(
    'username',
    'sessionkey',
    'rewardid',
    'title',
    'description',
    'cost'
);

// returns $paramsCheck - parameters all set true/false
// returns $data - failure message
include 'checkParameters.php';

if ($paramsCheck) {
    $username    = $_POST[$params[0]];
    $sessionkey  = $_POST[$params[1]];
    $rewardid    = $_POST[$params[2]];
    $title       = $_POST[$params[3]];
    $description = $_POST[$params[4]];
    $cost        = $_POST[$params[5]];

    // returns $db - database connection
    // returns $dbCheck - database connection status
    // returns $data - database connection failure message
    include 'connectToDatabase.php';

    if ($dbCheck) {

        // returns $check - authentication status
        // returns $data - authentication failure message
        include 'checkSessionkey.php';

        if($check) {

            $stmt = $db->prepare('UPDATE rewards
                                    SET title = ?, description = ?, cost = ?
                                    WHERE rewardid = ? AND owner = ?');
            $stmt->bind_param('ssiis', $title, $description, $cost, $rewardid, $username);
            if($stmt->execute()){
                $data = array('response' => 'Reward successfully updated');
            }
            else{
                $data = array('error' => 'Error while trying to update rewards. Maybe you are trying to update someone elses reward?');
            }
            $stmt->close();
        }
    }
}
echo json_encode($data);
?>

