package learnityourself.dhbw.learnityourself.controller;

import android.content.Context;
import android.content.Intent;
import android.widget.ListView;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

import learnityourself.dhbw.learnityourself.AddMissionMemberActivity;
import learnityourself.dhbw.learnityourself.ViewMissionActivity;
import learnityourself.dhbw.learnityourself.ViewMissionInformationActivity;
import learnityourself.dhbw.learnityourself.ViewMissionsActivity;
import learnityourself.dhbw.learnityourself.model.Mission;
import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.utility.HTTPRequestHandler;
import learnityourself.dhbw.learnityourself.utility.Helper;

public class ViewMissionInformationController extends AuthorizedController {

    private Mission mission;
    private User[] users;

    public ViewMissionInformationController(User user, Context context){
        super(user, context);
    }
    @Override
    protected void init() {

    }

    public void loadUsers(){

        HTTPRequestHandler handler = new HTTPRequestHandler();
        InputStream in  = null;
        try {
            in = handler.execute("https://91.205.172.109/allUsersFromMission.php","username",
                    user.getUsername(),"sessionkey", user.getSessionkey(),
                    "missionid", mission.getMissionid())
                    .get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        users = new Gson().fromJson(HTTPRequestHandler.getStringFromInputStream(in), User[].class);

        ArrayList<User> arrayList = new ArrayList<>(Arrays.asList(users));
        mission.setUsers(arrayList);
    }

    public void addUserClicked() {
        Intent intent = new Intent(context, AddMissionMemberActivity.class);
        intent.putExtra("user", user);
        intent.putExtra("mission", mission);
        context.startActivity(intent);
    }

    public void keyBackHandler(){
        Intent intent = new Intent(context, ViewMissionActivity.class);
        intent.putExtra("user", user);
        intent.putExtra("mission", mission);
        context.startActivity(intent);
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }

    public User[] getUsers() {
        return users;
    }

    public void leaveMission() {

        HTTPRequestHandler handler = new HTTPRequestHandler();
        try {
            handler.execute("https://91.205.172.109/leaveMission.php","username",
                    user.getUsername(),"sessionkey", user.getSessionkey(),
                    "missionid", mission.getMissionid())
                    .get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Intent intent = new Intent(context, ViewMissionsActivity.class);
        intent.putExtra("user", user);
        context.startActivity(intent);
    }
}
