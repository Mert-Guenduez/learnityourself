<?php
header('Content-Type: application/json;charset=utf-8');

$params = array(
	'username',
	'sessionkey',
	'password'
    );
    
$username   = $_POST[$params[0]];
$sessionkey = $_POST[$params[1]];
$password  = $_POST[$params[2]];
    
// returns $db - database connection
// returns $dbCheck - database connection status
// returns $data - database connection failure message
include 'connectToDatabase.php';
   
if ($dbCheck) {
   
	$data = array('authentication' => 'false', 'error' => 'Authentication failure');
	if (! isset($_POST['password'])) {
		if (! isset( $_POST['sessionkey'])) {
	        	$data = array('authentication' => 'false', 'error' => 'secret not set');
		} else {
			$stmt = $db->prepare('SELECT session_key, session_timeout
						FROM users
						WHERE user_name = ?');
			$stmt->bind_param('s', $username);
			$stmt->execute();
			$stmt->bind_result($sessionkey_db, $session_timeout);
			$stmt->store_result();
			$stmt->fetch();
			
			$time_now = time();

			if($sessionkey_db === $sessionkey and intval($time_now) <= intval(strtotime($session_timeout))) {
				$time_now = time();
				$time_then = date('Y-m-d H:i:s',$time_now + 24*60*60);
				$stmt = $db->prepare('UPDATE users
							SET session_timeout = ?
							WHERE user_name = ?');
				$stmt->bind_param('ss', $time_then, $username);
				if (! $stmt->execute() ) {
					echo json_encode(array('authentication' => 'false', 'error'=> 'Session generating error'));
					return;
				}
				$data = array('authentication' => 'true', 'user' => $username, 'sessionkey' => $sessionkey, 'session_timeout' => $time_then);
			}
			$stmt->free_result();
			$stmt->close();
		}
	} else {
		$stmt = $db->prepare('SELECT user_password, salt_hash
					FROM users
					WHERE user_name = ?');
		$stmt->bind_param('s', $username);

		$stmt->execute();

		$stmt->bind_result($pw_db, $salt_hash_db);
		$stmt->store_result();
		$stmt->fetch();

		if($stmt->num_rows == 1){
			$hashedpw = hash_pbkdf2('sha256',$password,$salt_hash_db, 1000);
			if($hashedpw == $pw_db){
				$time_now = time();
				$time_then = date('Y-m-d H:i:s',$time_now + 24*60*60);
				$sessionkey = hash_pbkdf2('sha256',$username,$time_now, 1000);
				$stmt = $db->prepare('UPDATE users
							SET session_key = ?, session_timeout = ?
							WHERE user_name = ?');
				$stmt->bind_param('sss', $sessionkey, $time_then, $username);
				if (! $stmt->execute() ) {
					echo json_encode(array('authentication' => 'false', 'error' => 'Session generating failed'));
					return;
				}
				$data = array('authentication' => 'true', 'user' => $username, 'sessionkey' => $sessionkey, 'session_timeout' => $time_then);
			}
		}	
		$stmt->free_result();
		$stmt->close();
	}
}
echo json_encode($data);
?>
