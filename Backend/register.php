<?php
header('Content-Type: application/json;charset=utf-8');

$params = array(
        'username',
        'password'
    );
    
    // returns $paramsCheck - parameters all set true/false
    // returns $data - failure message
    include 'checkParameters.php';
    
    if ($paramsCheck) {
        $username = $_POST[$params[0]];
        $password = $_POST[$params[1]];
    
        // returns $db - database connection
        // returns $dbCheck - database connection status
        // returns $data - database connection failure message
        include 'connectToDatabase.php';
    
        if ($dbCheck) {

                // Check if user is already registered
                $stmt = $db->prepare('SELECT COUNT(*)
                                        FROM users
                                        WHERE user_name = ?');
                $stmt->bind_param('s', $username);
                $stmt->execute();
                $stmt->bind_result($userExistsCount);
                $stmt->fetch();

                if ($userExistsCount == 1) {
                        echo json_encode(array('response' => 'User already exists'));
                        return;
                }
                $stmt->close();

                // Check if user count is under 1000
                $stmt = $db->prepare('SELECT COUNT(*)
                                        FROM users');
                $stmt->execute();
                $stmt->bind_result($usersCount);
                $stmt->fetch();

                if ($usersCount >= 1000) {
                        echo json_encode(array('response' => 'DB limit of 1000 Users reached'));
                        return;
                }
                $stmt->close();

                $salt_hash = random_bytes(255);
                $hashedpw = hash_pbkdf2("sha256", $password, $salt_hash, 1000);
                $stmt = $db->prepare('INSERT
                                        INTO users (user_name, user_password, salt_hash)
                                        VALUES (?,?,?)');
                $stmt->bind_param('sss', $username, $hashedpw, $salt_hash);

                if($stmt->execute()){
                        $data = array('response' => 'User successfully created');
                } else {
                        $data = array('response' => 'Error while trying to insert into DB');
                }
        }
}
echo json_encode($data);
?>
