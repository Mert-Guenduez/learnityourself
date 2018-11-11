<?php
header('Content-Type: application/json;charset=utf-8');
$mysqli = new mysqli("XXX", "XXX", "XXX", "XXX"); //censored credentials
if ($mysqli->connect_errno > 0) {
    die('Unable to connect to database [' . $mysqli->connect_error . ']');
}
$username = $_POST["username"];
$pw       = $_POST["password"];
//prevent sql injection
$stmt = $mysqli->prepare("SELECT * FROM users WHERE user_name = ?");
$stmt->bind_param('s', $username);

$stmt->execute();
$result = $stmt->get_result();
$row = mysqli_fetch_row($result);
$result = $mysqli->query("SELECT COUNT(*) FROM users");
$rowcount = mysqli_fetch_row($result);
if(count($row)>0){
        $data = array('response' => 'User already exists');
}
elseif($rowcount[0] >=1000){
        $data = array('response' => 'DB limit of 1000 Users reached');
}
else{
        $salt_hash = random_bytes(255);
        $hashedpw = hash_pbkdf2("sha256",$pw,$salt_hash, 1000);
        $stmt = $mysqli->prepare("INSERT INTO users (user_name, user_password, salt_hash)
        VALUES (?,?,?)");
        $stmt->bind_param('sss',$username,$hashedpw,$salt_hash);

        if($stmt->execute()){
        $data = array('response' => 'User successfully created');
        }
        else{
        $data = array('response' => 'Error while trying to insert into DB');
        }
}
        $json = json_encode($data);
        echo $json;
?>
