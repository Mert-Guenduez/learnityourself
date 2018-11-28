package learnityourself.dhbw.learnityourself;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;

import learnityourself.dhbw.learnityourself.model.Mission;
import learnityourself.dhbw.learnityourself.model.Task;
import learnityourself.dhbw.learnityourself.model.TaskAdapter;
import learnityourself.dhbw.learnityourself.utility.HTTPRequestHandler;
import learnityourself.dhbw.learnityourself.utility.Helper;

public class ViewMissionActivity extends AuthorizedActivity {


    private Mission mission;
    private ActionBar actionBar;
    private ListView taskListView;
    private Task[] tasks;
    private JSONObject jsonObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_mission);
        generateActionBar();
        if(checkAuthorized()){
            init();
        }
    }

    public void generateActionBar(){

        actionBar = getSupportActionBar();

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.mission_action_bar, null);

        view.findViewById(R.id.title).setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        titleClickHandler();
                    }
                });

        actionBar.setCustomView(view);
        actionBar.setDisplayShowCustomEnabled(true);
    }

    public void titleClickHandler(){

        Helper.getInstance().setJsonObject(jsonObject);
        Intent intent = new Intent(ViewMissionActivity.this, ViewMissionInformationActivity.class);
        intent.putExtra("user", user);
        intent.putExtra("mission", mission);
        startActivity(intent);
    }

    @Override
    void init() {

        Intent intent = getIntent();
        mission = (Mission) intent.getSerializableExtra("mission");
        actionBarSetTitle();


        HTTPRequestHandler handler = new HTTPRequestHandler();
        InputStream in  = null;
        try {
            in = handler.execute("https://91.205.172.109/allDetailsFromMission.php","username",
                    user.getUsername(),"sessionkey", user.getSessionkey(),
                    "missionid", mission.getMissionid())
                    .get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fillListFiew(in);
    }

    public void actionBarSetTitle(){
        TextView textView = (TextView)findViewById(R.id.title);
        textView.setText(mission.getMissionname());
    }

    public void fillListFiew(InputStream in){

        JsonElement element = new JsonParser().parse(new InputStreamReader(in));
        try {
            jsonObject = new JSONObject(element.getAsJsonObject().toString());

            String tag = jsonObject.getString("tasks");
            tasks = new Gson().fromJson(tag, Task[].class);
        } catch (JSONException e){
            System.err.println("ERROR parsing InputStream into JSONObject: " + e.getMessage());
        }


        taskListView = (ListView) findViewById(R.id.task_list);
        taskListView.setAdapter(new TaskAdapter(this, tasks));

        taskListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> arg0, View view,int position, long arg3) {
                        // TODO Auto-generated method stub
                        Toast.makeText(getApplicationContext(),"You Selected Item "+Integer.toString(position), Toast.LENGTH_LONG).show();
                    }
                }
        );
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
