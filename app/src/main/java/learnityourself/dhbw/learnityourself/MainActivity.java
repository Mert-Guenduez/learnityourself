package learnityourself.dhbw.learnityourself;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import org.json.JSONObject;

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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSSL();

        final EditText username_field = findViewById(R.id.username_field);
        final EditText password_field = findViewById(R.id.password_field);

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
               String inputString=getStringFromInputStream(in);

              if(inputString.equals("{\"error\":\"Authentication failure\"}")){
                  System.out.println("");
                   System.out.println("-------------------");
                   System.out.println("Wrong Password or Username");
                   System.out.println("-------------------");
               }else{

                    Gson gson= new Gson();
                    User user = gson.fromJson(inputString, User.class);

                  System.out.println("");
                   System.out.println("-------------------");
                   System.out.println("User " + user.getUser() +" logged in with Session key "+ user.getSessionkey());
                   System.out.println("-------------------");
               }



           }
        });
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

    private String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();

    }



}
