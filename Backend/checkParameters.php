<?php
function checkParameters() {
    $params = var_dump(func_get_args());
    $paramsLength = var_dump(func_num_args());
    $paramCheck = false;

    for ($i=0; $i < paramsLength; $i++) { 
        if (! isset($_POST[$params[$i]])) {
            echo array('error' => '' . $params[$i] . ' not set');
            return;
        }
    }

    $paramCheck = true;
}
?>