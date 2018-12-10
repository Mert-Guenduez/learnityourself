package learnityourself.dhbw.learnityourself.controller;

import android.content.Context;
import android.content.Intent;

import java.io.InputStream;
import java.util.concurrent.ExecutionException;

import learnityourself.dhbw.learnityourself.LoginActivity;
import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.utility.HTTPRequestHandler;

public abstract class AuthorizedController {

    protected User user;
    protected Context context;

    public AuthorizedController(User user, Context context){

        this.user = user;
        this.context = context;

        if(checkAuthorized()){
            init();
        }else{
            context.startActivity(new Intent(context, LoginActivity.class));
        }
    }

    protected abstract void init();

    private boolean checkAuthorized(){

        if(user==null){
            return false;
        }

        HTTPRequestHandler handler = new HTTPRequestHandler();
        InputStream in  = null;
        try {
            in = handler.execute("https://91.205.172.109/login.php","username", user.getUsername(),"sessionkey",user.getSessionkey()).get();
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
            return false;
        }

    }

    protected  User getUser(){
        return user;
    }
}
