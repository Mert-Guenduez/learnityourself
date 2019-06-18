<?php
$params = array(
    'username',
    'sessionkey'
);

// returns $paramsCheck - parameters all set true/false
// returns $data - failure message
include 'checkParameters.php';

if ($paramsCheck) {
    $username    = $_POST[$params[0]];
    $sessionkey  = $_POST[$params[1]];

    // returns $db - database connection
    // returns $dbCheck - database connection status
    // returns $data - database connection failure message
    include 'connectToDatabase.php';

    if ($dbCheck) {

        // returns $check - authentication status
        // returns $data - authentication failure message
        include 'checkSessionkey.php';

        if($check) {
            $stmt = $db->prepare('SELECT points
                                    FROM users
                                    WHERE user_name = ?');
            $stmt->bind_param('s',$username);
            if($stmt->execute()){
                    $stmt->bind_result($points);
                    $stmt->fetch();
                    $data = array('user_points' => $points);
            }
            else{
                    $data = array('error' => 'Error fetching points from user');
            }
            $stmt->close();
        }
    }
}
echo json_encode($data);
?>