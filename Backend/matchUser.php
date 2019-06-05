<?php
header('Content-Type: application/json;charset=utf-8');

$params = array(
    'username',
    'sessionkey',
    'matchuser'
);

$username   = $_POST[$params[0]];
$sessionkey = $_POST[$params[1]];
$matchuser  = $_POST[$params[2]];

// returns $db - database connection
// returns $dbCheck - database connection status
// returns $data - database connection failure message
include 'connectToDatabase.php';

if ($dbCheck) {

	// returns $check - authentication status
	// returns $data - authentication failure message
	include 'checkSessionkey.php';

	if($check) {
		if (! isset($_POST['matchuser'])) {
			$matchuser = '';
		}
		$stmt = $db->prepare('SELECT user_name
								FROM users
								WHERE user_name LIKE ?');
		$matchuser = '%' . $matchuser . '%';
		$stmt->bind_param('s', $matchuser);
		$stmt->execute();
		$stmt->bind_result($username);

		$data = array();
		while($stmt->fetch()) {
			$username = utf8_encode($username);
			$data[] = array('username' => $username);
		}
		$stmt->close();
	}
}
echo json_encode($data);
?>
