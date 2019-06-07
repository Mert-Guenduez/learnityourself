package learnityourself.dhbw.learnityourself.controller;

import android.content.Context;
import android.content.Intent;

import java.io.InputStream;
import java.util.concurrent.ExecutionException;

import learnityourself.dhbw.learnityourself.ViewTaskActivity;
import learnityourself.dhbw.learnityourself.model.Mission;
import learnityourself.dhbw.learnityourself.model.Task;
import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.utility.HTTPRequestHandler;

public class ManageTaskController extends AuthorizedController{

    private Task task;
    private Mission mission;

    public ManageTaskController(User user, Context context){
        super(user, context);
    }
    @Override
    protected void init() {

    }


    public void setTask(Task task) {
        this.task = task;
    }

    public Task getTask() {
        return task;
    }


    public void saveTask(String title, String description, String effort) {
        task.setTaskname(title);
        task.setDescription(description);
        task.setEffort(Integer.parseInt(effort));

        HTTPRequestHandler handler = new HTTPRequestHandler();
        handler.setContext(context);
        try {
            handler.execute("updateTask.php","username",
                    user.getUsername(),"sessionkey", user.getSessionkey(), "missionid", task.getMissionid(),
                    "taskname", task.getTaskname(), "taskid", task.getTaskid(), "description", task.getDescription(), "effort", Integer.toString(task.getEffort())).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        returnToTaskActivity();

    }

    public void returnToTaskActivity() {
        Intent intent = new Intent(context, ViewTaskActivity.class);
        intent.putExtra("user", user);
        intent.putExtra("task", task);
        context.startActivity(intent);
    }

    public void keyBackHandler() {
        returnToTaskActivity();
    }
}
