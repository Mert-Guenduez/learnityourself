package learnityourself.dhbw.learnityourself.controller;

import android.content.Context;
import android.content.Intent;

import java.io.InputStream;
import java.util.concurrent.ExecutionException;

import learnityourself.dhbw.learnityourself.LoginActivity;
import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.utility.HTTPRequestHandler;

public class OptionsController extends AuthorizedController{

    private Context context;
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
                    "old_password", oldPw,"new_password", oldPw).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(in != null){
            String inputString=HTTPRequestHandler.getStringFromInputStream(in);

            if (inputString.contains("error")){
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

}
