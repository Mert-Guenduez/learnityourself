<?php
// ini_set('display_errors', 1);
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

    // $db - database connection
    // $dbCheck - database connection status
    // $data - database connection failure message
    include 'connectToDatabase.php';

    if ($dbCheck) {

        // $check - authentication status
        // $data - authentication failure message
        include 'checkSessionkey.php';

        if($check) {

            // Default error message
            $data = array('response' => 'Server Error.');

            // Get cost of reward
            $stmt = $db->prepare('SELECT cost FROM rewards WHERE rewardid = ?');
            $stmt->bind_param('i', $rewardid);
            if ($stmt->execute()) {
                $rewardCost = 0;
                $stmt->bind_result($rewardCost);
                $stmt->fetch();
                $stmt->close();

                // Get user points
                $stmt = $db->prepare('SELECT points FROM users WHERE user_name = ?');
                $stmt->bind_param('s', $username);
                if ($stmt->execute()) {
                    $userPoints = 0;
                    $stmt->bind_result($userPoints);
                    $stmt->fetch();
                    $stmt->close();            

                    if ($userPoints < $rewardCost) {
                        $data = array('response' => 'Not enough points');
                    } else {
                        $userPoints = $userPoints - $rewardCost;
                        $stmt = $db->prepare('UPDATE users SET points = ? WHERE user_name = ?');
                        $stmt->bind_param('is', $userPoints, $username);
                        if ($stmt->execute()) {
                            $data = array('response' => 'success');
                        }
                    }
                }
            }
        }
    }
}
echo json_encode($data);
?>





