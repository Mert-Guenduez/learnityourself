<?php
$paramsCheck = true;

$paramsLength = count($params);
for ($i = 0; $i < $paramsLength; $i++) {
    if (! isset($_POST[$params[$i]])) {
        $data = array('error' => '' . $params[$i] . ' not set');
        $paramsCheck = false;
    }
}
?>