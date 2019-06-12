<?php
header('Content-Type: application/json; charset=utf8');

$params = array(
    'username',
    'sessionkey'
);

// returns $paramsCheck - parameters all set -(true/false)
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

			$stmt = $db->prepare('SELECT tasksCompleted, installedApp, totalEarnedPoints, totalRewardsAdded FROM achievements WHERE username = ?');
			$stmt->bind_param('s', $username);
			if($stmt->execute()){
                $row = mysqli_fetch_array($stmt->get_result());
                $data = array('tasksCompleted' => $row[0], 'installedApp' => $row[1], 'totalEarnedPoints' => $row[2], 'totalRewardsAdded' => $row[3]);
            }
            else{
                $data = array('error' => 'Could not get Achievements.');
            }
		}
	}
}
echo json_encode($data);
?>

