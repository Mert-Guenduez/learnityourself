package learnityourself.dhbw.learnityourself.controller;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.widget.EditText;

import java.io.InputStream;
import java.util.concurrent.ExecutionException;

import learnityourself.dhbw.learnityourself.LoginActivity;
import learnityourself.dhbw.learnityourself.RegisterActivity;
import learnityourself.dhbw.learnityourself.modelFactories.UserFactory;
import learnityourself.dhbw.learnityourself.utility.HTTPRequestHandler;

public class RegisterController {

    private Context context;

    public RegisterController(Context context){

        this.context = context;
    }

    public void register(EditText username, EditText password) {
        UserFactory.createNewObject();
        UserFactory.setUserName(username.getText().toString());

        HTTPRequestHandler handler = new HTTPRequestHandler();
        InputStream in = null;


            try {
                in = handler.execute("https://91.205.172.109/register.php", "username",  UserFactory.getObject().getUsername(), "password", password.getText().toString()).get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String inputString=HTTPRequestHandler.getStringFromInputStream(in);

            if (inputString.equals("{\"response\":\"User already exists\"}")){
                username.setError("User already exists. Please enter another Username.");
            } else {
                context.startActivity(new Intent(context, LoginActivity.class));
            }

    }
}
