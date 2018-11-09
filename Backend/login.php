<?php
header('Content-Type: application/json;charset=utf-8');

$username = $_POST['username'];
$pw       = $_POST['password'];

$db = new mysqli('localhost', 'dblover', 'DDBPw1mnmk1337', 'learnityourself');
if ($db->connect_errno > 0) {
    die('Unable to connect to database [' . $db->connect_error . ']');
}

//prevent sql injection
$stmt = $db->prepare('SELECT user_password,salt_hash FROM users WHERE user_name = ?');
$stmt->bind_param('s', $username);

$stmt->execute();

$stmt->bind_result($pw_db,$salt_hash_db);
$stmt->store_result();
$stmt->fetch();

$json = json_encode(array('error' => 'Authentication failure'));

if($stmt->num_rows == 1){
	$hashedpw = hash_pbkdf2('sha256',$pw,$salt_hash_db, 1000);
	if($hashedpw == $pw_db){
		$time_now = time();
		$time_then = date('Y-m-d H:i:s',$time_now + 30*60);
		$sessionkey = hash_pbkdf2('sha256',$username,$time_now, 1000);
		$stmt = $db->prepare("UPDATE users SET session_key=?, session_timeout=? WHERE user_name=?");
		$stmt->bind_param('sss',$sessionkey,$time_then,$username);
		if ( false===$stmt->execute() ) {
			die('Session generating failed: ' . htmlspecialchars($stmt->error));
		}
		$data = array('user' => $username, 'sessionkey' => $sessionkey, 'session_timeout' => $time_then);
		$json = json_encode($data);
	}
}
echo $json;
$stmt->free_result();
$stmt->close();
?>
