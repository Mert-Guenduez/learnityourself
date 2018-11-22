package learnityourself.dhbw.learnityourself;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.concurrent.ExecutionException;

import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.utility.HTTPRequestHandler;
import learnityourself.dhbw.learnityourself.utility.SSLHandler;

public class MainActivity extends AppCompatActivity {

    private TextView user_label;
    private Button missions_button;
    private User user;
    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSSL();
        if(checkAuthorized()){
            init();
        }
    }

    private void init() {

        user_label = findViewById(R.id.mainUserLabel);
        missions_button = findViewById(R.id.missions_button);
        user_label.setText(user.getUser());
        missions_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewMissionsActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });
    }

    private boolean checkAuthorized() {

        Intent intent = getIntent();
        user = (User) intent.getSerializableExtra("user");

        /* TODO
        If user ==null try reading from file
        if(user==null){
            read from file;
        }

        */
        if(user==null){
            intent = new Intent(this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            this.finish();
            return false;

        }else{
            HTTPRequestHandler handler = new HTTPRequestHandler();
            InputStream in  = null;
            try {
                in = handler.execute("https://91.205.172.109/login.php","username", user.getUser(),"sessionkey",user.getSessionkey()).get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //   Toast.makeText(MainActivity.this, getStringFromInputStream(in), Toast.LENGTH_SHORT).show();
            String inputString=HTTPRequestHandler.getStringFromInputStream(in);

            if(inputString.contains("true")) {
                return true;
            }else{
                startActivity(new Intent(this, LoginActivity.class));
                this.finish();
                return false;
            }
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
