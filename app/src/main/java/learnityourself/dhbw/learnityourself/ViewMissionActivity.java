package learnityourself.dhbw.learnityourself;

import android.content.Context;
import android.content.Intent;
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
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.zip.Inflater;

import learnityourself.dhbw.learnityourself.model.Mission;
import learnityourself.dhbw.learnityourself.model.MissionAdapter;
import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.utility.HTTPRequestHandler;

import static android.support.v7.widget.AppCompatDrawableManager.get;

public class ViewMissionActivity extends AuthorizedActivity {

    Mission mission;
    ActionBar actionBar;
    ListView taskListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_mission);
        actionBar = getSupportActionBar();

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.mission_action_bar, null);

        view.findViewById(R.id.title).setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        Toast.makeText(ViewMissionActivity.this,
                                "Custom title clicked.", Toast.LENGTH_SHORT)
                                .show();

                    }
                });

        actionBar.setCustomView(view);
        actionBar.setDisplayShowCustomEnabled(true);

        if(checkAuthorized()){
            init();
        }
    }

    @Override
    void init() {

        Intent intent = getIntent();
        mission = (Mission) intent.getSerializableExtra("mission");

        TextView textView = (TextView)findViewById(R.id.title);
        System.out.println(textView.getText());
        textView.setText(mission.getMissionname());

/*
        HTTPRequestHandler handler = new HTTPRequestHandler();
        InputStream in  = null;
        try {
            in = handler.execute("https://91.205.172.109/allMissionsFromUser.php","username",
                    user.getUser(),"sessionkey", user.getSessionkey(),
                    "missionid", mission.getMissionid())
                    .get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd' 'HH:mm:ss")
                .create();
        mission = gson.fromJson(HTTPRequestHandler.getStringFromInputStream(in), Mission.class);


        taskListView = (ListView) findViewById(R.id.task_list);
        taskListView.setAdapter(new MissionAdapter(this, mission));

        missionListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> arg0, View view,int position, long arg3) {
                        // TODO Auto-generated method stub
                        startActivity(new Intent(ViewMissionsActivity.this, ViewMissionActivity.class));
                        Toast.makeText(getApplicationContext(),"You Selected Item "+Integer.toString(position), Toast.LENGTH_LONG).show();
                    }
                }
        );
        */
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
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
