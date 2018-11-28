package learnityourself.dhbw.learnityourself;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;

import learnityourself.dhbw.learnityourself.model.Mission;
import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.model.UserAdapter;
import learnityourself.dhbw.learnityourself.utility.HTTPRequestHandler;
import learnityourself.dhbw.learnityourself.utility.Helper;


public class ViewMissionInformationActivity extends AuthorizedActivity {


    private TextView description_textview, finishdate_textview;
    private JSONObject jsonObject;
    private Mission mission;
    private ListView userListView;
    private User[] users;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_mission_information);

        description_textview = findViewById(R.id.description_textview);
        finishdate_textview = findViewById(R.id.date_textView);

        jsonObject = Helper.getInstance().getJsonObject();

        try {
            setDescription_textview();
            setFinishdate_textview();
        } catch (JSONException e){
            System.err.println("JSONException: " + e.getMessage());
        }

        if(checkAuthorized()){
            init();
        }
    }

    public void setDescription_textview() throws JSONException {

        this.description_textview.setText(jsonObject.getString("description"));
    }

    public void setFinishdate_textview() throws JSONException {

        this.finishdate_textview.setText(jsonObject.getString("deadline"));
    }

    @Override
    void init() {
        Intent intent = getIntent();
        mission = (Mission) intent.getSerializableExtra("mission");

        HTTPRequestHandler handler = new HTTPRequestHandler();
        InputStream in  = null;
        try {
            in = handler.execute("https://91.205.172.109/allUsersFromMission.php","username",
                    user.getUsername(),"sessionkey", user.getSessionkey(),
                    "missionid", mission.getMissionid())
                    .get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //System.out.println("HIER: " + HTTPRequestHandler.getStringFromInputStream(in));

        setUserListView(in);
    }

    public void setUserListView(InputStream in){
        users = new Gson().fromJson(HTTPRequestHandler.getStringFromInputStream(in), User[].class);

        System.out.println("USER: " + users[0].getUsername());

        // TODO

        userListView = (ListView) findViewById(R.id.missionMember_listview);
        userListView.setAdapter(new UserAdapter(this, users));
    }



}
