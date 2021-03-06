package learnityourself.dhbw.learnityourself.controller;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.concurrent.ExecutionException;

import learnityourself.dhbw.learnityourself.ManageTaskActivity;
import learnityourself.dhbw.learnityourself.ViewMissionActivity;
import learnityourself.dhbw.learnityourself.ViewMissionsActivity;
import learnityourself.dhbw.learnityourself.model.Mission;
import learnityourself.dhbw.learnityourself.model.Task;
import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.utility.HTTPRequestHandler;
import learnityourself.dhbw.learnityourself.utility.Helper;

public class ViewTaskController extends AuthorizedController{

    private Task task;

    public ViewTaskController(User user, Context context){
        super(user, context);
    }
    @Override
    protected void init() {

    }

    public void loadTaskDetail() {
        HTTPRequestHandler handler = new HTTPRequestHandler();
        handler.setContext(context);
        InputStream in  = null;
        try {
            in = handler.execute("allDetailsFromTask.php","username",
                    user.getUsername(),"sessionkey", user.getSessionkey(),
                    "taskid", task.getTaskid())
                    .get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String out = HTTPRequestHandler.getStringFromInputStream(in);
        task = new Gson().fromJson(out, Task.class);
        task.setTaskname(out.substring(out.indexOf("name\":\"")+7, out.indexOf("\",\"description")));
    }

    public void completeTask(){
        String pointsToAdd = Integer.toString(task.getEffort());

        HTTPRequestHandler handler = new HTTPRequestHandler();
        handler.setContext(context);
        InputStream in  = null;
        try {
            in = handler.execute("completeTask.php","username",
                    user.getUsername(),"sessionkey", user.getSessionkey(),"taskid", task.getTaskid())
                    .get();
            String inString = HTTPRequestHandler.getStringFromInputStream(in);
            if(in != null && !inString.contains("error")){
                Toast.makeText(context, "Congratulations for \n Completing this Task. \n You receive " +task.getEffort()+ " Points", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
            }

            return;
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();

    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Task getTask() {
        return task;
    }

    public void keyBackHandler(){
        Intent intent = new Intent(context, ViewMissionActivity.class);
        intent.putExtra("user", user);
        intent.putExtra("mission", Helper.getInstance().getMission());
        context.startActivity(intent);
    }

    public void editTask() {
        Intent intent = new Intent(context, ManageTaskActivity.class);
        intent.putExtra("user", user);
        intent.putExtra("task", task);
        context.startActivity(intent);
    }
}
