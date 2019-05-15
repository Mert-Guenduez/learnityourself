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
import android.widget.SeekBar;
import android.widget.TextView;

import learnityourself.dhbw.learnityourself.controller.ManageTaskController;
import learnityourself.dhbw.learnityourself.controller.ViewTaskController;
import learnityourself.dhbw.learnityourself.model.Task;
import learnityourself.dhbw.learnityourself.model.User;

public class ManageTaskActivity extends AppCompatActivity {


    private ManageTaskController controller;
    private TextView taskTitle, taskDescription, taskEffort, effortProgress, effortError;
    private SeekBar taskEffortSeekBar;
    private EditText taskTitleEdit, taskDescEdit, taskEffortEdit;
    private int effortValue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_task);
        controller=new ManageTaskController((User)getIntent().getSerializableExtra("user"),this);
        controller.setTask((Task) getIntent().getSerializableExtra("task"));
        init();

    }

    void init() {
        Task task = controller.getTask();

        taskTitle = findViewById(R.id.tasktitle_label);
        taskDescription = findViewById(R.id.taskDescription_textview);
        taskEffort = findViewById(R.id.effort_textView) ;
        effortProgress = findViewById(R.id.effortProgress_textView);
        effortError = findViewById(R.id.effortError_textView);

        taskTitleEdit = (EditText) findViewById(R.id.taskTitle_field);
        taskTitleEdit.setText(task.getTaskname());

        taskDescEdit = (EditText) findViewById(R.id.taskDescription_field);
        taskDescEdit.setText(task.getDescription());

        effortValue = 0;

        taskEffortSeekBar = findViewById(R.id.effortField);
        taskEffortSeekBar.setProgress(task.getEffort());

        taskEffortSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                effortValue = progress;

                int val = (progress * (seekBar.getWidth() - 2 * seekBar.getThumbOffset())) / seekBar.getMax();
                effortProgress.setText("" + progress);
                effortProgress.setX(seekBar.getX() + val + seekBar.getThumbOffset() / 2);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        //taskEffortSeekBar.setText(Integer.toString(controller.getTask().getEffort()));

        /*
        saveButton = (Button) findViewById(R.id.saveTask_button);
        saveButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 controller.saveTask(taskTitleEdit.getText().toString(), taskDescEdit.getText().toString(), taskEffort.getText().toString());

            }
        }));
        */


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_check, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();

        if (id == R.id.check){
            item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    if (validEntry()){
                        controller.saveTask(taskTitleEdit.getText().toString(), taskDescEdit.getText().toString(), Integer.toString(effortValue));

                        //controller.checkClickHandler();
                    }
                    return false;
                }
            });
        }
        return true;
    }


    public boolean validEntry() {
        if (taskTitleEdit.getText().toString().isEmpty()) {
            taskTitleEdit.setError("Insert Title");
            return false;
        }
        if (effortValue < 1) {
            effortError.requestFocus();
            effortError.setError("Insert Effort.");
            return false;
        }
        return true;
    }

    public void actionBarSetTitle(){
        TextView textView = (TextView)findViewById(R.id.title);
        textView.setText(controller.getTask().getTaskname());
    }

    @Override
    public void onBackPressed() {
        controller.keyBackHandler();
    }
}
