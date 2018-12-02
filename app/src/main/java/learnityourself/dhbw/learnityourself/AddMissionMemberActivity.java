package learnityourself.dhbw.learnityourself;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.InputStream;
import java.util.concurrent.ExecutionException;

import learnityourself.dhbw.learnityourself.controller.AddMissionMemberController;
import learnityourself.dhbw.learnityourself.model.Mission;
import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.model.UserAdapter;
import learnityourself.dhbw.learnityourself.utility.HTTPRequestHandler;

public class AddMissionMemberActivity extends AppCompatActivity {

    private TextView username_field;
    private SearchView searchView;
    private ListView searchUsername;
    private AddMissionMemberController controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_missionmember);

        controller = new AddMissionMemberController((User) getIntent().getSerializableExtra("user"),this);
        controller.setMission((Mission)getIntent().getSerializableExtra("mission"));
        username_field = findViewById(R.id.search_username_label);
        searchView = findViewById(R.id.user_searchView);
        searchUsername = findViewById(R.id.search_user_listview);



        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                setSearchUsername(controller.matchUser(newText));
                return false;
            }
        });

    }




    public void setSearchUsername(User[] matchUser){
        searchUsername = (ListView) findViewById(R.id.search_user_listview);
        searchUsername.setAdapter(new UserAdapter(this, matchUser));

        for (int i = 0; i < matchUser.length; i++) {
            if (controller.getMission().getUsers().contains(matchUser[i])){
                // TODO change color 
            }
        }

        searchUsername.setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
                        // TODO add MissionMember
                    }
                }
        );
    }

}
