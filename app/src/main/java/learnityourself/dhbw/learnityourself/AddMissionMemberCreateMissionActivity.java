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

import learnityourself.dhbw.learnityourself.controller.AddMissionMemberCreateMissionController;
import learnityourself.dhbw.learnityourself.model.AddUserAdapter;
import learnityourself.dhbw.learnityourself.model.User;

public class AddMissionMemberCreateMissionActivity extends AppCompatActivity {

    private TextView username_field;
    private SearchView searchView;
    private ListView searchUsername;
    private AddMissionMemberCreateMissionController controller;
    private StringBuffer buffer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_missionmember);

        controller = new AddMissionMemberCreateMissionController((User) getIntent().getSerializableExtra("user"),this);
        username_field = findViewById(R.id.search_username_label);
        searchView = findViewById(R.id.user_searchView);
        searchUsername = findViewById(R.id.search_user_listview);

        String members = controller.getMembersString();
        if (members == null){
            buffer = new StringBuffer();
        } else {
            buffer = new StringBuffer(members);
        }


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
                        User user = controller.getMatchUser()[position];
                        if (buffer.length() == 0){
                            buffer.append("\"" + user.getUsername() + "\"");
                        } else {
                            buffer.append(",\"" + user.getUsername() + "\"");
                        }
                        controller.getMembersArrayList().add(user);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_check, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.check){
            item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    controller.setMembersString(buffer.toString());
                    controller.checkClickHandler();
                    return false;
                }
            });
        }
        return true;
    }
}
