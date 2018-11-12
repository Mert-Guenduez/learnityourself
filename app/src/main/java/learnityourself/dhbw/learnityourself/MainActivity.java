package learnityourself.dhbw.learnityourself;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.concurrent.ExecutionException;

import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.utility.SSLHandler;

public class MainActivity extends AppCompatActivity {

    private User user;
    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSSL();

        Intent intent = getIntent();
        user = (User) intent.getSerializableExtra("user");

        /*TODO look for active session key

        if(SESSION_KEY == null){
            Read Session Key From File
        }
         */
        if(user==null){
            startActivity(new Intent(this, LoginActivity.class));
        }else{
            TextView user_label = findViewById(R.id.mainUserLabel);
            user_label.setText(user.getUser());
        }


    }

    private void setSSL(){

        SSLHandler sslHandler = null;
        try {
            sslHandler= new SSLHandler(getApplicationContext());
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
