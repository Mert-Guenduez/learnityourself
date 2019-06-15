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
                echo $row[0] . $row[1] . $row[2] . $row[3];
                $data = array();
                if($row[0] >= 1){
                    array_push($data, "Completed 1 Task");
                }
                if($row[0] >= 5){
                    array_push($data, "Completed 5 Tasks");
                }
                if($row[0] >= 10){
                    array_push($data, "Completed 10 Tasks");
                }
                if($row[1] == 1){
                    array_push($data, "Installed the learnityourself App");
                }
                if($row[2] >= 10){
                    array_push($data, "Earned 10 Points");
                }
                if($row[2] >= 50){
                    array_push($data, "Earned 50 Points");
                }
                if($row[3] >= 1){
                    array_push($data, "Added 1 Custom Reward");
                }
                if($row[3] >= 10){
                    array_push($data, "Added 10 Custom Rewards");
                }
            }
            else{
                $data = array('error' => 'Could not get Achievements.');
            }
		}
	}
}
echo json_encode($data);
?>

