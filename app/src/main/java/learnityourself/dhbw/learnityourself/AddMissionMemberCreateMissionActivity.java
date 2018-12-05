package learnityourself.dhbw.learnityourself;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import learnityourself.dhbw.learnityourself.controller.AddMissionMemberCreateMissionController;
import learnityourself.dhbw.learnityourself.model.AddUserAdapter;
import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.utility.AddMissionMemberLayout;

public class AddMissionMemberCreateMissionActivity extends AddMissionMemberLayout {

    private TextView username_field;
    private SearchView searchView;
    private ListView searchUsername;
    private AddMissionMemberCreateMissionController controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_missionmember);

        controller = new AddMissionMemberCreateMissionController((User) getIntent().getSerializableExtra("user"),this);
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

    public void setSearchUsername(final User[] matchUser){
        // TODO Array im controller füllen
        updateSetSeachUsername(matchUser);

        searchUsername.setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
                        User selectedUser = controller.getMatchUser()[position];
                        /*
                        controller.addUser(selectedUser.getUsername());
                        controller.getMission().getUsers().add(selectedUser);
                        updateSetSeachUsername(matchUser);
                        */
                    }
                }
        );
    }


    public void updateSetSeachUsername(User[] matchUser){
        controller.setMatchUser(matchUser);

        /*
        for (int i = 0; i < controller.getMission().getUsers().size(); i++) {
            for (int j = 0; j < matchUser.length; j++) {
                if (controller.getMission().getUsers().get(i).getUsername().equals(matchUser[j].getUsername())){
                    matchUser[j].setMember(true);
                }
            }
        }
        */

        searchUsername = (ListView) findViewById(R.id.search_user_listview);
        searchUsername.setAdapter(new AddUserAdapter(this, matchUser));
    }
}
