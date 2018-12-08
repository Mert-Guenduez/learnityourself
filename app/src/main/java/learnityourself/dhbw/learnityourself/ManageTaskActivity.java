package learnityourself.dhbw.learnityourself;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import learnityourself.dhbw.learnityourself.controller.ManageTaskController;
import learnityourself.dhbw.learnityourself.controller.ViewTaskController;
import learnityourself.dhbw.learnityourself.model.Task;
import learnityourself.dhbw.learnityourself.model.User;

public class ManageTaskActivity extends AppCompatActivity {


    private ManageTaskController controller;
    private TextView taskTitle, taskDescription, taskEffort;
    private EditText taskTitleEdit, taskDescEdit, taskEffortEdit;
    private Button saveButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_task);
        controller=new ManageTaskController((User)getIntent().getSerializableExtra("user"),this);
        controller.setTask((Task) getIntent().getSerializableExtra("task"));
        init();

    }

    void init() {
        taskTitle = (TextView) findViewById(R.id.tasktitle_label);
        taskDescription = (TextView) findViewById(R.id.taskDescription_textview);
        taskEffort = (TextView) findViewById(R.id.effort_textView) ;

        taskTitleEdit = (EditText) findViewById(R.id.taskTitle_field);
        taskTitleEdit.setText(controller.getTask().getTaskname());

        taskDescEdit = (EditText) findViewById(R.id.taskDescription_field);
        taskDescEdit.setText(controller.getTask().getDescription());

        taskEffort = (EditText) findViewById(R.id.effortField);
        taskEffort.setText(Integer.toString(controller.getTask().getEffort()));

        saveButton = (Button) findViewById(R.id.saveTask_button);
        saveButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 controller.saveTask(taskTitleEdit.getText().toString(), taskDescEdit.getText().toString(), taskEffort.getText().toString());

            }
        }));


    }

    public void actionBarSetTitle(){
        TextView textView = (TextView)findViewById(R.id.title);
        textView.setText(controller.getTask().getTaskname());
    }


}
