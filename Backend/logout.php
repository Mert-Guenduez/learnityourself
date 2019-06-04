<?php
header('Content-Type: application/json;charset=utf-8');

$params = array(
    'username',
    'sessionkey',
);

// returns $paramsCheck - parameters all set true/false
// returns $data - failure message
include 'checkParameters.php';

if ($paramsCheck) {
    $username   = $_POST[$params[0]];
    $sessionkey = $_POST[$params[1]];

    // returns $db - database connection
    // returns $dbCheck - database connection status
    // returns $data - database connection failure message
    include 'connectToDatabase.php';

    if ($dbCheck) {

        // returns $check - authentication status
        // returns $data - authentication failure message
        include 'checkSessionkey.php';

        if($check) {
            // invalidate sessionkey by setting timeout to now()
            $stmt = $db->prepare('UPDATE users
                                    SET session_timeout = ?
                                    WHERE user_name = ?');
            $time_now = date('Y-m-d H:i:s', time());
            $stmt->bind_param('ss', $time_now, $username);
            $stmt->execute();
            $stmt->close();
            $data = array('response' => 'successful');
        }
    }
}
echo json_encode($data);
?>
