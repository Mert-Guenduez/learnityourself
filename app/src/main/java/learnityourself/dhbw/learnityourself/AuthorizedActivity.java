package learnityourself.dhbw.learnityourself;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.InputStream;
import java.util.concurrent.ExecutionException;

import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.utility.HTTPRequestHandler;

public abstract class AuthorizedActivity extends AppCompatActivity{

    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    abstract void init();

    protected boolean checkAuthorized()
    {
        Intent intent = getIntent();
        user = (User) intent.getSerializableExtra("user");

        if(user==null){
            startActivity(new Intent(this, LoginActivity.class));
            this.finish();
            return false;
        }

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
