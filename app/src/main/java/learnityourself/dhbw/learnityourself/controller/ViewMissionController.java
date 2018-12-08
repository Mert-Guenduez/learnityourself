package learnityourself.dhbw.learnityourself.controller;

import android.content.Context;
import android.content.Intent;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;

import learnityourself.dhbw.learnityourself.CreateMissionActivity;
import learnityourself.dhbw.learnityourself.ViewMissionActivity;
import learnityourself.dhbw.learnityourself.ViewMissionInformationActivity;
import learnityourself.dhbw.learnityourself.ViewMissionsActivity;
import learnityourself.dhbw.learnityourself.ViewTaskActivity;
import learnityourself.dhbw.learnityourself.model.Mission;
import learnityourself.dhbw.learnityourself.model.Task;
import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.utility.HTTPRequestHandler;
import learnityourself.dhbw.learnityourself.utility.Helper;

public class ViewMissionController extends AuthorizedController {

    private Mission mission;
    private Task[] tasks;
    private JSONObject jsonObject;

    public ViewMissionController(User user, Context context){
        super(user, context);
    }
    @Override
    protected void init() {

    }

    public void loadTasks(){
        HTTPRequestHandler handler = new HTTPRequestHandler();
        InputStream in  = null;
        try {
            in = handler.execute("https://91.205.172.109/allDetailsFromMission.php","username",
                    user.getUsername(),"sessionkey", user.getSessionkey(),
                    "missionid", mission.getMissionid())
                    .get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        JsonElement element = new JsonParser().parse(new InputStreamReader(in));
        try {
            jsonObject = new JSONObject(element.getAsJsonObject().toString());

            String tag = jsonObject.getString("tasks");
            tasks = new Gson().fromJson(tag, Task[].class);
        } catch (JSONException e){
            System.err.println("ERROR parsing InputStream into JSONObject: " + e.getMessage());
        }

    }

    public void setMission(Mission mission) {
        this.mission=mission;
    }

    public Task[] getTasks() {
        return tasks;
    }

    public Mission getMission() {
        return mission;
    }

    public void titleClickHandler() {
            Helper.getInstance().setJsonObject(jsonObject);
            Intent intent = new Intent(context, ViewMissionInformationActivity.class);
            intent.putExtra("user", user);
            intent.putExtra("mission", mission);
            context.startActivity(intent);
    }

    public void clickTask(int position) {
        Helper.getInstance().setMission(mission);

        Intent intent = new Intent(context, ViewTaskActivity.class);
        intent.putExtra("user", user);
        intent.putExtra("task", tasks[position]);
        context.startActivity(intent);
    }

    public void keyBackHandler(){
        Intent intent = new Intent(context, ViewMissionsActivity.class);
        intent.putExtra("user", user);
        context.startActivity(intent);
    }

}
