package learnityourself.dhbw.learnityourself.controller;

import android.content.Context;
import android.content.Intent;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.InputStream;
import java.util.concurrent.ExecutionException;

import learnityourself.dhbw.learnityourself.CreateMissionActivity;
import learnityourself.dhbw.learnityourself.ViewMissionActivity;
import learnityourself.dhbw.learnityourself.ViewMissionsActivity;
import learnityourself.dhbw.learnityourself.model.Mission;
import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.utility.HTTPRequestHandler;

public class ViewMissionsController extends AuthorizedController{

    Mission[] missions;
    public ViewMissionsController(User user, Context context){
        super(user, context);
    }
    @Override
    protected void init() {
        HTTPRequestHandler handler = new HTTPRequestHandler();
        InputStream in  = null;
        try {
            in = handler.execute("https://91.205.172.109/allMissionsFromUser.php","username", user.getUsername(),"sessionkey", user.getSessionkey()).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd' 'HH:mm:ss")
                .create();
        missions = gson.fromJson(HTTPRequestHandler.getStringFromInputStream(in), Mission[].class);
    }

    public Mission[] getMissions(){
        return missions;
    }

    public void missionClicked(int position) {
        Intent intent = new Intent(context, ViewMissionActivity.class);
        intent.putExtra("user", user);
        intent.putExtra("mission", missions[position]);
        context.startActivity(intent);
    }

    public void createMission(){
        Intent intent = new Intent(context, CreateMissionActivity.class);
        intent.putExtra("user", user);
        context.startActivity(intent);
    }

}
