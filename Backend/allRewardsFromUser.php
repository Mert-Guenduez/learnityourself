<?php
header('Content-Type: application/json; charset=utf8');

$params = array(
    'username',
    'sessionkey'
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

            $stmt = $db->prepare('SELECT rewardid, title, description, cost
                                    FROM rewards
                                    WHERE owner = ?');
            $stmt->bind_param('s', $username);
            $stmt->execute();
            $allRewards = $stmt->get_result();
            $stmt->free_result();
            $stmt->close();

            $data = array();
            while($row = mysqli_fetch_array($allRewards)){
                $resultArray = array(
                    'rewardid' => $row[0],
                    'title' => $row[1],
                    'description' => $row[2],
                    'cost' => $row[3]);
                $data[] = $resultArray;
            }
        }
    }
}
echo json_encode($data);
?>
