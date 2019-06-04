<?php
// ini_set('display_errors', 1);
header('Content-Type: application/json; charset=utf8');

$username   = $_POST['username'];
$sessionkey = $_POST['sessionkey'];
$missionid  = $_POST['missionid'];

// $db - database connection
// $dbCheck - database connection status
// $data - database connection failure message
include 'connectToDatabase.php';

if ($dbCheck) {

    // $check - authentication status
    // $data - authentication failure message
    include 'checkSessionkey.php';

    if($check) {

        // Get count of mission members
        $stmt = $db->prepare('SELECT COUNT(*) FROM userToMission WHERE missionid = ?');
        $stmt->bind_param('i', $missionid);
        if ($stmt->execute()) {
            $missionMemberCount = 0;
            $stmt->bind_result($missionMemberCount);
            $stmt->fetch();
            $stmt->close();

            // Is user a member of the mission?
            $stmt = $db->prepare('SELECT COUNT(*) FROM userToMission WHERE missionid = ? AND username = ?');
            $stmt->bind_param('is', $missionid, $username);
            if ($stmt->execute()) {
                $isMissionMember = 0;
                $stmt->bind_result($isMissionMember);
                $stmt->fetch();
                $stmt->close();

                if (! $isMissionMember) {
                    echo json_encode(array('response' => 'Not a member of the mission'));
                    return;
                }
            } else {
                echo json_encode(array('response' => 'Server Error.'));
                return;
            }


            // Delete userToTask relationship
            $stmt = $db->prepare('DELETE utt
                                    FROM userToTask utt
                                    INNER JOIN tasks
                                        ON utt.taskid = tasks.id
                                    WHERE utt.username = ? AND tasks.missionid = ?');
            $stmt->bind_param('si',$username,$missionid);
            if (! $stmt->execute()) {
                echo json_encode(array('response' => 'Server Error.'));
                return;
            }
            $stmt->close();

            // Delete userToMission relationship
            $stmt = $db->prepare('DELETE utm
                                    FROM userToMission utm
                                    INNER JOIN missions
                                        ON utm.missionid = missions.id
                                    WHERE utm.username = ? AND missions.id = ?');
            $stmt->bind_param('si',$username,$missionid);
            if (! $stmt->execute()) {
                echo json_encode(array('response' => 'Server Error.'));
                return;
            }
            $stmt->close();

            // Deletion of whole mission and corresponding tasks, if no member is left
            if ($missionMemberCount == 1) {
                
                // Delete Tasks
                $stmt = $db->prepare('DELETE FROM tasks
                                        WHERE missionid = ?');
                $stmt->bind_param('i',$missionid);
                if (! $stmt->execute()) {
                    echo json_encode(array('response' => 'Server Error.'));
                    return;
                }
                $stmt->close();

                // Delete Mission
                $stmt = $db->prepare('DELETE FROM missions
                                        WHERE id = ?');
                $stmt->bind_param('i',$missionid);
                if (! $stmt->execute()) {
                    echo json_encode(array('response' => 'Server Error.'));
                    return;
                }
                $stmt->close();
            }

            $data = array('response' => 'success');

        } else {
            $data = array('response' => 'Server Error.');
        }
}}
echo json_encode($data);
?>





