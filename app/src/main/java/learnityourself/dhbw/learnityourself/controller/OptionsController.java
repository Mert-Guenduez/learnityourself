package learnityourself.dhbw.learnityourself.controller;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.io.InputStream;
import java.util.concurrent.ExecutionException;

import learnityourself.dhbw.learnityourself.LoginActivity;
import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.utility.HTTPRequestHandler;

public class OptionsController extends AuthorizedController{

    public OptionsController(User user, Context context){
        super(user, context);
    }

    @Override
    protected void init() {

    }

    public boolean setNewPassword(String oldPw, String newPw) {
        HTTPRequestHandler handler = new HTTPRequestHandler();
        InputStream in = null;


        try {
            in = handler.execute("https://91.205.172.109/changePassword.php", "username",  user.getUsername(), "sessionkey", user.getSessionkey(),
                    "password", oldPw,"passwordNew", newPw).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(in != null){
            String inputString=HTTPRequestHandler.getStringFromInputStream(in);
            System.out.println(inputString);
            if (inputString.contains("error")){
                return false;
            } else {
                Toast.makeText(context, "Your Password has been changed ", Toast.LENGTH_SHORT).show();
                return true;
            }
        }
        return false;
    }

}
