<?php

use PHPUnit\Framework\TestCase;
class AllUsersFromMissinPHPUnit extends Testcase{
        public function setUp()
        {
        }
        public function testLogin(){
        // Bei Angabe korrekter Daten unter Verwendung des Passwort muss 'authentication' => 'true' sein und ein Sessionkey zurückgegeben werden
				
	$_POST['username'] = 'testuser1';
        $_POST['password'] = '12345';
        $_POST['sessionkey'] = NULL;
	require('../login.php');
        $this->assertTrue($data["authentication"] === 'true');
	$this->assertArrayHasKey("sessionkey", $data);

        // Bei Angabe korrekter Daten unter Verwendung des Sessionkeys muss 'authentication' => 'true' sein
        $_POST['username'] = 'testuser1';
        $_POST['password'] = NULL;
        $_POST['sessionkey'] = $data["sessionkey"];
        require('../login.php');
        $this->assertTrue($data["authentication"] === 'true');

        // Bei Auslassung von Passwort & Sessionkey muss 'error' => 'secret not set' sein
        $_POST['username'] = 'testuser1';
        $_POST['password'] = NULL;
        $_POST['sessionkey'] = NULL;
        require('../login.php');
        $this->assertTrue($data["error"] === 'secret not set');
				
	// Bei Auslassung des Username muss 'error' => 'username not set' sein
	$_POST['username'] = NULL;
        $_POST['password'] = '12345';
        $_POST['sessionkey'] = NULL;
        require('../login.php');
        $this->assertTrue($data["error"] === 'username not set');
				
	// Falls entweder der Username oder das Passwort (oder beides) nicht stimmt, muss 'error' => 'Authentication failure' sein
	$_POST['username'] = 'testuser1';
        $_POST['password'] = '54321';
        $_POST['sessionkey'] = NULL;
        require('../login.php');
        $this->assertTrue($data["error"] === 'Authentication failure');
				
	$_POST['username'] = 'unregisteredUser';
        $_POST['password'] = '12345';
        $_POST['sessionkey'] = NULL;
        require('../login.php');
        $this->assertTrue($data["error"] === 'Authentication Failure');
        }

}
?>
