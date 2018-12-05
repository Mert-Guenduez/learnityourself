package learnityourself.dhbw.learnityourself;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import learnityourself.dhbw.learnityourself.controller.AddMissionMemberController;
import learnityourself.dhbw.learnityourself.model.AddUserAdapter;
import learnityourself.dhbw.learnityourself.model.Mission;
import learnityourself.dhbw.learnityourself.model.User;

public class AddMissionMemberActivity extends learnityourself.dhbw.learnityourself.utility.AddMissionMemberActivity {

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

}
