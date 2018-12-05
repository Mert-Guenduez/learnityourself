package learnityourself.dhbw.learnityourself.controller;

import android.content.Context;
import android.content.Intent;

import com.google.gson.Gson;

import java.io.InputStream;
import java.util.concurrent.ExecutionException;

import learnityourself.dhbw.learnityourself.ViewMissionInformationActivity;
import learnityourself.dhbw.learnityourself.model.Mission;
import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.utility.HTTPRequestHandler;

public class AddMissionMemberController extends AuthorizedController {

    private User[] matchUser;
    private Mission mission;

    public AddMissionMemberController(User user, Context context){
        super(user, context);
    }

    @Override
    protected void init() {

    }

    public void setMission(Mission mission) {
        this.mission=mission;
    }

    public User[] getMatchUser() {
        return matchUser;
    }

    public void setMatchUser(User[] matchUser) {
        this.matchUser = matchUser;
    }

    public User[] matchUser(String matchuser){
        HTTPRequestHandler handler = new HTTPRequestHandler();
        InputStream in  = null;
        try {
            in = handler.execute("https://91.205.172.109/matchUser.php","username",
                    user.getUsername(),"sessionkey", user.getSessionkey(),
                    "matchuser", matchuser)
                    .get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new Gson().fromJson(HTTPRequestHandler.getStringFromInputStream(in), User[].class);
    }

    public Mission getMission() {
        return mission;
    }

    public void addUser(String addUser){
        HTTPRequestHandler handler = new HTTPRequestHandler();
        InputStream in  = null;
        try {
            in = handler.execute("https://91.205.172.109/addUserToMission.php","username",
                    user.getUsername(),"sessionkey", user.getSessionkey(),
                    "missionid", mission.getMissionid(), "adduser", addUser)
                    .get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void checkClickHandler() {
        //Helper.getInstance().setJsonObject(jsonObject);
        Intent intent = new Intent(context, ViewMissionInformationActivity.class);
        intent.putExtra("user", user);
        intent.putExtra("mission", mission);
        context.startActivity(intent);
    }
}
