package learnityourself.dhbw.learnityourself;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ExecutionException;

import learnityourself.dhbw.learnityourself.model.Mission;
import learnityourself.dhbw.learnityourself.model.MissionAdapter;
import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.utility.HTTPRequestHandler;

public class ViewMissionsActivity extends AuthorizedActivity {

    Mission[] missions;
    ListView missionListView;


    Button newMissionButton;
    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_missions);
        if(checkAuthorized())init();
    }

    @Override
    void init() {


        HTTPRequestHandler handler = new HTTPRequestHandler();
        InputStream in  = null;
        try {
            in = handler.execute("https://91.205.172.109/allMissionsFromUser.php","username", user.getUser(),"sessionkey", user.getSessionkey()).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd' 'HH:mm:ss")
                .create();
        missions = gson.fromJson(HTTPRequestHandler.getStringFromInputStream(in), Mission[].class);


        missionListView = (ListView) findViewById(R.id.mission_list);
        missionListView.setAdapter(new MissionAdapter(this, missions));

        missionListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> arg0, View view,int position, long arg3) {
                        // TODO Auto-generated method stub
                        Intent intent = new Intent(ViewMissionsActivity.this, ViewMissionActivity.class);
                        intent.putExtra("user", user);
                        intent.putExtra("mission", missions[position]);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(),"You Selected Item "+Integer.toString(position), Toast.LENGTH_LONG).show();
                    }
                }
        );
    }


}
