<?php
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
$result = $mysqli->query("SELECT * FROM users");
$rowcount = count(mysqli_fetch_row($result));
if(count($row)>0){
        $data = array('response' => 'User already exists');
                $json = json_encode($data);
        echo $json;
}
elseif($rowcount >=1000){
        $data = array('response' => 'DB limit of 1000 Users reached');
                $json = json_encode($data);
        echo $json;
}
else{
        $salt_hash = random_bytes(255);
        $hashedpw = hash_pbkdf2("sha256",$pw,$salt_hash, 1000);
        $stmt = $mysqli->prepare("INSERT INTO users (user_name, user_password, salt_hash)
        VALUES (?,?,?)");
        $stmt->bind_param('sss',$username,$hashedpw,$salt_hash);

        if($stmt->execute()){
        $data = array('response' => 'User successfully created');
                $json = json_encode($data);
        echo $json;
        }
        else{
        $data = array('response' => 'Error while trying to insert into DB');
                $json = json_encode($data);
        echo $json;
        }
}
?>