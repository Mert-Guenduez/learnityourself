package learnityourself.dhbw.learnityourself.controller;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.gson.Gson;

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
        InputStream in  = null;
        try {
            in = handler.execute("https://91.205.172.109/allDetailsFromTask.php","username",
                    user.getUsername(),"sessionkey", user.getSessionkey(),
                    "taskid", task.getTaskid())
                    .get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task = new Gson().fromJson(HTTPRequestHandler.getStringFromInputStream(in), Task.class);

    }

    public void completeTask(){
        String pointsToAdd = Integer.toString(task.getEffort());

        HTTPRequestHandler handler = new HTTPRequestHandler();
        InputStream in  = null;
        try {
            in = handler.execute("https://91.205.172.109/completeTask.php","username",
                    user.getUsername(),"sessionkey", user.getSessionkey(),"taskid", task.getTaskid())
                    .get();
            if(in != null){
                Gson gson= new Gson();
                user = gson.fromJson(HTTPRequestHandler.getStringFromInputStream(in), User.class);
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
