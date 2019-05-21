<?php
header('Content-Type: application/json;charset=utf-8');

$mysqli = new mysqli("localhost", "dblover", "DDBPw1mnmk1337", "learnityourself");

if ($mysqli->connect_errno > 0) {
    die('Unable to connect to database [' . $mysqli->connect_error . ']');
}

$username = $_POST["username"];
$password = $_POST["password"];
$sessionkey = $_POST["sessionkey"];
$password_new = $_POST["passwordNew"];

if (! isset($_POST["password"])){
    $data = array('error' => 'Secret not set.');
    echo json_encode($data);
    return;
}

if (! isset($_POST["passwordNew"])){
    $data = array('error' => 'New secret not set.');
    echo json_encode($data);
    return;
}

// returns $check = true/false
include 'checkSessionkey.php';

$data = array('authentication' => 'false', 'error' => 'Authentication failure');
if($check){

    // Check if old password match hashed password in database
    $stmt = $db->prepare('SELECT user_password,salt_hash FROM users WHERE user_name = ?');
    $stmt->bind_param('s', $username);
    $stmt->execute();
    $stmt->bind_result($password_db,$salt_hash_db);
    $stmt->store_result();
    $stmt->fetch();
    $hashedOldPassword = hash_pbkdf2('sha256',$password,$salt_hash_db, 1000);
    if($hashedOldPassword == $password_db){

        // Generate new hashed password
        $salt_hash = random_bytes(255);
        $hashedNewPassword = hash_pbkdf2("sha256",$password_new, $salt_hash, 1000);

        // Update database
        $stmt = $db->prepare('UPDATE users SET user_password = ?, salt_hash = ? WHERE user_name = ?');
        $stmt->bind_param('sss',$hashedNewPassword,$salt_hash,$username);
        if ($stmt->execute()) {
            $data = array('success' => 'Password updated.');
        } else {
            $data = array('error' => 'Changing password failed.');
        }
    }
    $stmt->free_result();
    $stmt->close();
}
$json = json_encode($data);
echo $json;
?>