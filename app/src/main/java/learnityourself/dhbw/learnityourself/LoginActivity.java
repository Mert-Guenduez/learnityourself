package learnityourself.dhbw.learnityourself;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.concurrent.ExecutionException;

import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.utility.HTTPRequestHandler;
import learnityourself.dhbw.learnityourself.utility.SSLHandler;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText username_field = findViewById(R.id.username_field);
        final EditText password_field = findViewById(R.id.password_field);

        Button registerButton = findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        Button loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                HTTPRequestHandler handler = new HTTPRequestHandler();
                InputStream in  = null;
                try {
                    in = handler.execute("https://91.205.172.109/login.php","username", username_field.getText().toString(),"password",password_field.getText().toString()).get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //   Toast.makeText(MainActivity.this, getStringFromInputStream(in), Toast.LENGTH_SHORT).show();
                String inputString=HTTPRequestHandler.getStringFromInputStream(in);

                if(inputString.equals("{\"error\":\"Authentication failure\"}")){
                    Toast.makeText(LoginActivity.this, "Wrong Username or Password", Toast.LENGTH_SHORT).show();
                }else{

                    Gson gson= new Gson();
                    User user = gson.fromJson(inputString, User.class);
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("user", user);
                    startActivity(intent);
                }



            }
        });
    }


}
