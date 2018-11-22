<?php
header('Content-Type: application/json;charset=utf-8');

$username   = $_POST['username'];
$password   = $_POST['password'];
$sessionkey = $_POST['sessionkey'];

$db = new mysqli('localhost', 'XXX', 'XXX', 'XXX');
if ($db->connect_errno > 0) {
    die(json_encode(array('authentication' => 'false', 'error' => 'Unable to connect to database [' . $db->connect_error . ']')));
}
if (! isset($_POST['username'])) {
	die(json_encode(array('authentication' => 'false', 'error' => 'username not set')));
}

$json = json_encode(array('authentication' => 'false', 'error' => 'Authentication failure'));

if (! isset($_POST['password'])) {
	if (! isset( $_POST['sessionkey'])) {
	        die(json_encode(array('authentication' => 'false', 'error' => 'secret not set')));
	} else {
		$stmt = $db->prepare('SELECT session_key,session_timeout FROM users WHERE user_name = ?');
		$stmt->bind_param('s', $username);

		$stmt->execute();

		$stmt->bind_result($sessionkey_db, $session_timeout);
		$stmt->store_result();
		$stmt->fetch();
		
		$time_now = time();

		if($sessionkey_db === $sessionkey and intval($time_now) <= intval(strtotime($session_timeout))) {
			$time_now = time();
                        $time_then = date('Y-m-d H:i:s',$time_now + 24*60*60);
                        $stmt = $db->prepare("UPDATE users SET session_timeout=? WHERE user_name=?");
                        $stmt->bind_param('ss',$time_then,$username);
                        if ( false===$stmt->execute() ) {
                                die(array('authentication' => 'false', 'error'=> 'Session generating error'));
                        }
                        $data = array('authentication' => 'true', 'user' => $username, 'sessionkey' => $sessionkey, 'session_timeout' => $time_then);
                        $json = json_encode($data);
		}
		$stmt->free_result();
	        $stmt->close();
	}
} else {
	$stmt = $db->prepare('SELECT user_password,salt_hash FROM users WHERE user_name = ?');
	$stmt->bind_param('s', $username);

	$stmt->execute();

	$stmt->bind_result($pw_db,$salt_hash_db);
	$stmt->store_result();
	$stmt->fetch();

	if($stmt->num_rows == 1){
		$hashedpw = hash_pbkdf2('sha256',$password,$salt_hash_db, 1000);
	        if($hashedpw == $pw_db){
        	        $time_now = time();
                	$time_then = date('Y-m-d H:i:s',$time_now + 24*60*60);
	                $sessionkey = hash_pbkdf2('sha256',$username,$time_now, 1000);
        	        $stmt = $db->prepare("UPDATE users SET session_key=?, session_timeout=? WHERE user_name=?");
                	$stmt->bind_param('sss',$sessionkey,$time_then,$username);
	                if ( false===$stmt->execute() ) {
        	                die(array('authentication' => 'false', 'error' => 'Session generating failed'));
                	}
	                $data = array('authentication' => 'true', 'user' => $username, 'sessionkey' => $sessionkey, 'session_timeout' => $time_then);
        	        $json = json_encode($data);
	        }
	}	
	$stmt->free_result();
	$stmt->close();
}
echo $json;
?>
