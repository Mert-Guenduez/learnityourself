<?php
//ini_set('display_errors', 1);
header('Content-Type: application/json; charset=utf8');
$params = array(
    'username',
    'sessionkey',
    'missionid'
);
include 'checkParameters.php';
if ($paramsCheck) {
    $username   = $_POST[$params[0]];
    $sessionkey = $_POST[$params[1]];
    $missionid  = $_POST[$params[2]];

    include 'connectToDatabase.php';
    if ($dbCheck) {

        include 'checkSessionkey.php';
        if($check) {
            $stmt = $db->prepare('SELECT userToTask.username, COUNT(*)
                                    FROM tasks
                                    INNER JOIN userToTask
                                        ON tasks.id = userToTask.taskid
                                    WHERE tasks.missionid = ? AND userToTask.completed  = 1
                                    GROUP BY userToTask.username');
    $stmt->bind_param('i', $missionid);
    $stmt->execute();

    $UserAmounts = $stmt->get_result();
    $stmt->free_result();
    $stmt->close();
    $data = array();
    $resultArray = array();
    while($row = mysqli_fetch_array($UserAmounts)){
    //$resultArray = array($row[0] => $row[1]);
    $data[$row[0]] = $row[1] . "";

}
}}}
echo json_encode($data);;
?>