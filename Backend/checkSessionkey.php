<?php
header('Content-Type: application/json;charset=utf-8');
$check = false;

$stmt = $db->prepare('SELECT session_key, session_timeout
                        FROM users
                        WHERE user_name = ?');
$stmt->bind_param('s', $username);
$stmt->execute();

$stmt->bind_result($sessionkey_db, $session_timeout);
$stmt->store_result();
$stmt->fetch();

if($sessionkey_db === $sessionkey and intval(time()) <= intval(strtotime($session_timeout))) {
        $check = true;
} else {
        $data = array('authentication' => 'false', 'error' => 'Authentication failure');
}
$stmt->free_result();
$stmt->close();
?>
