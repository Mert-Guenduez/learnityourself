<?php
header('Content-Type: application/json;charset=utf-8');

$params = array(
    'username',
    'sessionkey',
    'password',
    'passwordNew'
);

// returns $paramsCheck - parameters all set true/false
// returns $data - failure message
include 'checkParameters.php';

if ($paramsCheck) {
    $username    = $_POST[$params[0]];
    $sessionkey  = $_POST[$params[1]];
    $password    = $_POST[$params[2]];
    $password_new = $_POST[$params[3]];

    // returns $db - database connection
    // returns $dbCheck - database connection status
    // returns $data - database connection failure message
    include 'connectToDatabase.php';

    if ($dbCheck) {

        // returns $check - authentication status
        // returns $data - authentication failure message
        include 'checkSessionkey.php';

        if($check) {

            // Check if old password match hashed password in database
            $stmt = $db->prepare('SELECT user_password, salt_hash
                                    FROM users
                                    WHERE user_name = ?');
            $stmt->bind_param('s', $username);
            $stmt->execute();
            $stmt->bind_result($password_db, $salt_hash_db);
            $stmt->store_result();
            $stmt->fetch();

            $hashedOldPassword = hash_pbkdf2('sha256', $password, $salt_hash_db, 1000);
            $data = array('error' => 'Password mismatch.');
            if($hashedOldPassword == $password_db){

                // Generate new hashed password
                $salt_hash = random_bytes(255);
                $hashedNewPassword = hash_pbkdf2("sha256",$password_new, $salt_hash, 1000);

                // Update database
                $stmt = $db->prepare('UPDATE users
                                        SET user_password = ?, salt_hash = ?
                                        WHERE user_name = ?');
                $stmt->bind_param('sss', $hashedNewPassword, $salt_hash, $username);
                if ($stmt->execute()) {
                    $data = array('success' => 'Password updated.');
                } else {
                    $data = array('error' => 'Changing password failed.');
                }
            }
            $stmt->free_result();
            $stmt->close();
        }
    }
}
echo json_encode($data);
?>