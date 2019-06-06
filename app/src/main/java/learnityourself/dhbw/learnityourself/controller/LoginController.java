package learnityourself.dhbw.learnityourself.controller;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.EditText;

import com.google.gson.Gson;

import java.io.InputStream;
import java.util.concurrent.ExecutionException;

import learnityourself.dhbw.learnityourself.LoginActivity;
import learnityourself.dhbw.learnityourself.MainActivity;
import learnityourself.dhbw.learnityourself.RegisterActivity;
import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.utility.HTTPRequestHandler;

public class LoginController {

    private Context context;

    public LoginController(Context context){

        this.context = context;
    }

    public void register() {
        context.startActivity(new Intent(context, RegisterActivity.class));
    }

    public void login(EditText username_field, EditText password_field){
        HTTPRequestHandler handler = new HTTPRequestHandler();
        handler.setContext(context);
        InputStream in  = null;
        try {
            in = handler.execute("login.php","username",
                    username_field.getText().toString(),"password",password_field.getText().toString()).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String inputString=HTTPRequestHandler.getStringFromInputStream(in);

        if(inputString.contains("false")){
            username_field.setError("Wrong Username or Password.");
        }else{

            Gson gson= new Gson();
            User user = gson.fromJson(inputString, User.class);
            Intent intent = new Intent(context, MainActivity.class);
            intent.putExtra("user", user);
            context.startActivity(intent);
        }
    }

    public void setHost(String host) {
        SharedPreferences settings = context.getSharedPreferences("LearnItYourself", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("host", host);
        editor.apply();
    }

    public String getHost(){
        return new HTTPRequestHandler().getHost();
    }
}
