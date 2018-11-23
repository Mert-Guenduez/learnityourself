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
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.zip.Inflater;

import learnityourself.dhbw.learnityourself.model.Mission;
import learnityourself.dhbw.learnityourself.model.MissionAdapter;
import learnityourself.dhbw.learnityourself.model.Task;
import learnityourself.dhbw.learnityourself.model.TaskAdapter;
import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.utility.HTTPRequestHandler;

import static android.support.v7.widget.AppCompatDrawableManager.get;

public class ViewMissionActivity extends AuthorizedActivity {

    Mission mission;
    ActionBar actionBar;
    ListView taskListView;
    Task[] tasks;

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
                        startActivity(new Intent(ViewMissionActivity.this, ViewMissionInformationActivity.class));
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

        tasks = mission.getTasks();


        HTTPRequestHandler handler = new HTTPRequestHandler();
        InputStream in  = null;
        try {
            in = handler.execute("https://91.205.172.109/allDetailsFromMission.php","username",
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
        //mission = gson.fromJson(HTTPRequestHandler.getStringFromInputStream(in), Mission.class);


        try {
            JsonElement element = new JsonParser().parse(new InputStreamReader(in));
            JSONObject jsonObject = new JSONObject(element.getAsJsonObject().toString());

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
