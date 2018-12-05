package learnityourself.dhbw.learnityourself;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
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
    private TextView taskDescription, taskEffort;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_task);
        controller=new ViewTaskController((User)getIntent().getSerializableExtra("user"),this);
        controller.setTask((Task) getIntent().getSerializableExtra("task"));
        controller.loadTaskDetail();
        generateActionBar();
        init();

    }

    void init() {
        actionBarSetTitle();
        taskDescription = (TextView) findViewById(R.id.taskDescription_textview);
        taskEffort = (TextView) findViewById(R.id.effort_textView) ;

        taskDescription.setText(controller.getTask().getDescription());
        taskEffort.setText(controller.getTask().getEffort() + "");
    }

    public void generateActionBar(){

        ActionBar actionBar = getSupportActionBar();

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.mission_action_bar, null);

        actionBar.setCustomView(view);
        actionBar.setDisplayShowCustomEnabled(true);
    }

    public void actionBarSetTitle(){
        TextView textView = (TextView)findViewById(R.id.title);
        textView.setText(controller.getTask().getTaskname());
    }


}
