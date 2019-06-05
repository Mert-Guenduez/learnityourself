<?php
header('Content-Type: application/json; charset=utf8');

$params = array(
    'username',
    'sessionkey',
    'title',
	'description',
	'cost'
);

// returns $paramsCheck - parameters all set -(true/false)
// returns $data - failure message
include 'checkParameters.php';

if ($paramsCheck) {
    $username    = $_POST[$params[0]];
    $sessionkey  = $_POST[$params[1]];
    $title  	 = $_POST[$params[2]];
	$description = $_POST[$params[3]];
	$cost		 = $_POST[$params[4]];

    // returns $db - database connection
    // returns $dbCheck - database connection status
    // returns $data - database connection failure message
    include 'connectToDatabase.php';

    if ($dbCheck) {

        // returns $check - authentication status
        // returns $data - authentication failure message
        include 'checkSessionkey.php';

        if($check) {

			$stmt = $db->prepare('INSERT
									INTO rewards (owner, title, description, cost)
									VALUES (?,?,?,?)');
			$stmt->bind_param('sssi', $username, $title, $description, $cost);
			if($stmt->execute()){
				$data = array('response' => 'Reward successfully created');
			}
			else{
				$data = array('error' => 'Error while trying to insert into rewards table');
			}
		}
	}
}
echo json_encode($data);
?>

