package learnityourself.dhbw.learnityourself;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.InputStream;
import java.util.concurrent.ExecutionException;

import learnityourself.dhbw.learnityourself.model.Mission;
import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.model.UserAdapter;
import learnityourself.dhbw.learnityourself.utility.HTTPRequestHandler;

public class AddMissionMemberActivity extends AuthorizedActivity {

    private TextView username_field;
    private SearchView searchView;
    private ListView searchUsername;
    private User[] matchUser;
    private Mission mission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_missionmember);

        username_field = findViewById(R.id.search_username_label);
        searchView = findViewById(R.id.user_searchView);
        searchUsername = findViewById(R.id.search_user_listview);

        if(checkAuthorized()){
            init();
        }

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                matchUser(newText);
                return false;
            }
        });

    }

    @Override
    void init() {
        Intent intent = new Intent();
        mission = (Mission)intent.getSerializableExtra("mission");
    }

    public void matchUser(String matchuser){
        HTTPRequestHandler handler = new HTTPRequestHandler();
        InputStream in  = null;
        try {
            in = handler.execute("https://91.205.172.109/matchUser.php","username",
                    user.getUsername(),"sessionkey", user.getSessionkey(),
                    "matchuser", matchuser)
                    .get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        setSearchUsername(in);
    }

    public void setSearchUsername(InputStream in){
        matchUser = new Gson().fromJson(HTTPRequestHandler.getStringFromInputStream(in), User[].class);

        searchUsername = (ListView) findViewById(R.id.search_user_listview);
        searchUsername.setAdapter(new UserAdapter(this, matchUser));

        /*
        for (int i = 0; i < matchUser.length; i++) {
            if (mission.getUsers().contains(matchUser[i])){
                // TODO change color
            }
        }
        */

        searchUsername.setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
                        addUser(matchUser[position].getUsername());
                    }
                }
        );
    }

    public void addUser(String addUser){
        HTTPRequestHandler handler = new HTTPRequestHandler();
        InputStream in  = null;
        try {
            in = handler.execute("https://91.205.172.109/addUserToMission.php","username",
                    user.getUsername(),"sessionkey", user.getSessionkey(),
                    "missionid", mission.getMissionid(), "adduser", addUser)
                    .get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String inputString=HTTPRequestHandler.getStringFromInputStream(in);

        System.out.println("INPUTSTRING: " + inputString);

    }

}
