package learnityourself.dhbw.learnityourself;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Scroller;
import android.widget.SeekBar;
import android.widget.TextView;

import learnityourself.dhbw.learnityourself.controller.ViewTaskController;
import learnityourself.dhbw.learnityourself.model.Task;
import learnityourself.dhbw.learnityourself.model.User;

public class ViewTaskActivity extends AppCompatActivity {


    private ViewTaskController controller;
    private Button complete_task_button;
    private TextView taskDescription, taskEffort;
    private SeekBar effortSeekbar;


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
        Task task = controller.getTask();

        actionBarSetTitle();
        taskDescription = (TextView) findViewById(R.id.taskDescription_textview);
        taskEffort = (TextView) findViewById(R.id.effort_textView) ;

        taskDescription.setText(task.getDescription());
        taskEffort.setText(task.getEffort() + "");

        taskDescription.setScroller(new Scroller(this));
        taskDescription.setMaxLines(3);
        taskDescription.setVerticalScrollBarEnabled(true);
        taskDescription.setMovementMethod(new ScrollingMovementMethod());

        effortSeekbar = findViewById(R.id.effortSeekbar_viewTask);
        effortSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int originalProgress;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if( fromUser == true){
                    seekBar.setProgress( originalProgress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                originalProgress = seekBar.getProgress();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        effortSeekbar.setThumbOffset(10000);
        effortSeekbar.setProgress(task.getEffort());

        complete_task_button = (Button) findViewById(R.id.completeTaskBtn);
        complete_task_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.completeTask();
            }
        });
        if(task.getCompleted() != null){
            complete_task_button.setEnabled(!controller.getTask().getCompleted());
        }

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_edit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.edit){
            controller.editTask();
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        controller.keyBackHandler();
    }
}
