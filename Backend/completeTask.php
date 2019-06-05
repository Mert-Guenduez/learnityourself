<?php
header('Content-Type: application/json; charset=utf8');

$params = array(
    'username',
    'sessionkey',
    'taskid'
);

// returns $paramsCheck - parameters all set true/false
// returns $data - failure message
include 'checkParameters.php';

if ($paramsCheck) {
    $username   = $_POST[$params[0]];
    $sessionkey = $_POST[$params[1]];
    $taskid     = $_POST[$params[2]];

    // returns $db - database connection
    // returns $dbCheck - database connection status
    // returns $data - database connection failure message
    include 'connectToDatabase.php';

    if ($dbCheck) {

        // returns $check - authentication status
        // returns $data - authentication failure message
        include 'checkSessionkey.php';

        if($check) {

            //Check if user is assigned to task
            $stmt = $db->prepare('SELECT COUNT(*)
                                    FROM userToTask
                                    WHERE taskid = ? AND username = ?');
            $stmt->bind_param('is', $taskid, $username);
            $stmt->execute();
            $stmt->bind_result($countUserTaskRelation);
            $stmt->fetch();
            $stmt->close();

            if ($countUserTaskRelation == 0) {
                echo json_encode(array('error' => 'The task is not assigned to the user'));
                return;
            }
            
            // Mark task as completed
            $stmt = $db->prepare('UPDATE userToTask
                                    SET completed = 1
                                    WHERE taskid = ?');
            $stmt->bind_param('i', $taskid);
            if($stmt->execute()){
                $data = array('response' => 'Task successfully updated');
            }
            else{
                $data = array('error' => 'Task could not be updated');
            }
            $stmt->close();
        }
    }
}
echo json_encode($data);
?>