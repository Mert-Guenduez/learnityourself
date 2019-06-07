<?php
header('Content-Type: application/json; charset=utf8');

$params = array(
    'username',
    'sessionkey',
    'missionname',
    'description',
    'seconds',
    'users'
);

// returns $paramsCheck - parameters all set true/false
// returns $data - failure message
include 'checkParameters.php';

if ($paramsCheck) {
    $username    = $_POST[$params[0]];
    $sessionkey  = $_POST[$params[1]];
    $missionname = $_POST[$params[2]];
    $description = $_POST[$params[3]];
    $seconds     = $_POST[$params[4]];
    $users       = $_POST[$params[5]];

    // returns $db - database connection
    // returns $dbCheck - database connection status
    // returns $data - database connection failure message
    include 'connectToDatabase.php';

    if ($dbCheck) {

        // returns $check - authentication status
        // returns $data - authentication failure message
        include 'checkSessionkey.php';

        if($check) {

            $stmt = $db->prepare('SELECT COUNT(*)
                                    FROM missions');
            $stmt->execute();
            $result = $stmt->get_result();
            $rowcount = mysqli_fetch_row($result);
            $stmt->free_result();
            $stmt->close();

            if($rowcount[0] >= 3000){
                $data = array('error' => 'DB limit of 3000 Missions reached');
            }
            else{

                $stmt = $db->prepare("INSERT
                                        INTO missions (owner, missionname, description, deadline)
                                        VALUES (?,?,?,(NOW()+INTERVAL ? SECOND))");
                $stmt->bind_param('ssss', $username, $missionname, $description, $seconds);
                if($stmt->execute()){
                    $missionid = $db->insert_id;
                    $stmt->close();

                    $stmt = $db->prepare("INSERT
                                            INTO userToMission (username, missionid)
                                            VALUES (?,?)");
                    $stmt->bind_param('si', $username, $missionid);

                    if($stmt->execute()){
                        $data = array('response' => 'Mission successfully created', 'missionid' => $missionid);
                    }
                    else{
                        $data = array('error' => 'Error while trying to insert into DBTable userToMission');
                    }
                }
                else{
                    $data = array('error' => 'Error while trying to insert into DBTable missions');
                }
                $stmt->close();
                $userjson = json_decode($users);
                $userarray = $userjson->{"users"};
                echo $userarray[0];
                foreach($userarray as $singleuser){
                    $stmt = $db->prepare("INSERT
                                            INTO userToMission (username, missionid)
                                            VALUES (?,?)");
                    $stmt->bind_param('ss',$singleuser,$missionid);
                    if(! $stmt->execute()){
                        $data = array('response' => 'Mission successfully created, however not all users could be added', 'missionid' => $missionid);
                    };
                    $stmt->close();
                }
            }
        }
    }
}
echo json_encode($data);
?>