package learnityourself.dhbw.learnityourself.controller;

import android.content.Context;
import android.view.MenuItem;

import com.google.gson.Gson;

import java.io.InputStream;
import java.util.concurrent.ExecutionException;

import learnityourself.dhbw.learnityourself.model.Mission;
import learnityourself.dhbw.learnityourself.model.Task;
import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.utility.HTTPRequestHandler;

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


    public void setTask(Task task) {
        this.task = task;
    }


    public Task getTask() {
        return task;
    }
}
