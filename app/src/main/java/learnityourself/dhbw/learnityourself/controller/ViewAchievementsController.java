package learnityourself.dhbw.learnityourself.controller;

import android.content.Context;
import android.content.Intent;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.InputStream;
import java.util.concurrent.ExecutionException;

import learnityourself.dhbw.learnityourself.CreateMissionActivity;
import learnityourself.dhbw.learnityourself.MainActivity;
import learnityourself.dhbw.learnityourself.ViewMissionActivity;
import learnityourself.dhbw.learnityourself.model.Achievement;
import learnityourself.dhbw.learnityourself.model.Mission;
import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.utility.HTTPRequestHandler;

public class ViewAchievementsController extends AuthorizedController{

    Achievement[] achievements;
    public ViewAchievementsController(User user, Context context){
        super(user, context);
    }
    @Override
    protected void init() {
        HTTPRequestHandler handler = new HTTPRequestHandler();
        InputStream in  = null;
        try {
            in = handler.execute("getUserAchievements.php","username", user.getUsername(),"sessionkey", user.getSessionkey()).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Gson gson = new GsonBuilder().create();
        achievements = gson.fromJson(HTTPRequestHandler.getStringFromInputStream(in), Achievement[].class);
    }

    public Achievement[] getAchievements(){
        return achievements;
    }

    public void keyBackHandler(){
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("user", user);
        context.startActivity(intent);
    }
}
