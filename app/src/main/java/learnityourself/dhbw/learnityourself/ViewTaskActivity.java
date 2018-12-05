package learnityourself.dhbw.learnityourself;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import learnityourself.dhbw.learnityourself.controller.ViewMissionController;
import learnityourself.dhbw.learnityourself.controller.ViewTaskController;
import learnityourself.dhbw.learnityourself.model.Mission;
import learnityourself.dhbw.learnityourself.model.Task;
import learnityourself.dhbw.learnityourself.model.TaskAdapter;
import learnityourself.dhbw.learnityourself.model.User;

public class ViewTaskActivity extends AppCompatActivity {


    private ViewTaskController controller;
    private Task task;
    private TextView taskTitle;
    private TextView taskDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_task);
        controller=new ViewTaskController((User)getIntent().getSerializableExtra("user"),this);
        controller.setTask((Task) getIntent().getSerializableExtra("task"));
        controller.loadTaskDetail();
        init();

    }

    void init() {
        taskTitle = (TextView) findViewById(R.id.taskTitle);
        taskDescription = (TextView) findViewById(R.id.taskDescription);
        taskTitle.setText(controller.getTask().getTaskname());
        taskDescription.setText(controller.getTask().getDescription());


    }


}
