package learnityourself.dhbw.learnityourself;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import learnityourself.dhbw.learnityourself.controller.ViewMissionController;
import learnityourself.dhbw.learnityourself.model.Mission;
import learnityourself.dhbw.learnityourself.model.TaskAdapter;
import learnityourself.dhbw.learnityourself.model.User;

public class ViewMissionActivity extends AppCompatActivity {



    private ActionBar actionBar;
    private ListView taskListView;
    private ViewMissionController controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_mission);
        controller=new ViewMissionController((User)getIntent().getSerializableExtra("user"),this);
        controller.setMission((Mission) getIntent().getSerializableExtra("mission"));
        controller.loadTasks();
        generateActionBar();

            init();

    }

    public void generateActionBar(){

        actionBar = getSupportActionBar();

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.mission_action_bar, null);

        view.findViewById(R.id.title).setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        controller.titleClickHandler();
                    }
                });

        actionBar.setCustomView(view);
        actionBar.setDisplayShowCustomEnabled(true);
    }

    void init() {

        actionBarSetTitle();
        taskListView = (ListView) findViewById(R.id.task_list);
        taskListView.setAdapter(new TaskAdapter(this, controller.getTasks()));

        taskListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> arg0, View view,int position, long arg3) {
                        // TODO Auto-generated method stub
                        controller.clickTask(position);
                    }
                }
        );

    }

    public void actionBarSetTitle(){
        TextView textView = (TextView)findViewById(R.id.title);
        textView.setText(controller.getMission().getMissionname());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.add){
            // TODO add create new Task
        }
        return true;
    }

}
