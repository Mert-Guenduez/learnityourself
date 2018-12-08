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
                        if (!user.getUsername().equals(controller.getUser().getUsername())){
                            if (!controller.getMembersArrayList().contains(user)){
                                controller.getMembersArrayList().add(user);
                                addUserToString(user);
                            } else {
                                controller.getMembersArrayList().remove(user);
                                deleteUserFromString(user);
                            }
                            updateSetSeachUsername(matchUser);
                        }

                    }
                }
        );

    }

    public void addUserToString(User user){
        if (buffer.length() == 0){
            buffer.append("\"" + user.getUsername() + "\"");
        } else {
            buffer.append(",\"" + user.getUsername() + "\"");
        }
    }

    public void deleteUserFromString(User user){
        int index = buffer.indexOf(user.getUsername());
        if (index > 1){
            buffer.delete(index-2, index + user.getUsername().length()+1);
        } else {
            buffer.delete(index-1, index + user.getUsername().length()+1);
        }
    }


    public void updateSetSeachUsername(User[] matchUser){
        controller.setMatchUser(matchUser);

        editSetMember(matchUser);

        searchUsername = (ListView) findViewById(R.id.search_user_listview);
        searchUsername.setAdapter(new AddUserAdapter(this, matchUser));
    }

    public void editSetMember(User[] matchUser){
        for (int i = 0; i < controller.getMembersArrayList().size(); i++) {
            for (int j = 0; j < matchUser.length; j++) {
                if (controller.getMembersArrayList().contains(matchUser[j]) |
                controller.getUser().getUsername().equals(matchUser[j].getUsername())){
                    matchUser[j].setMember(true);
                } else {
                    matchUser[j].setMember(false);
                }
            }
        }

        if (controller.getMembersArrayList().size() == 0){
            for (int i = 0; i < matchUser.length; i++) {
                if (!controller.getUser().getUsername().equals(matchUser[i].getUsername())){
                    matchUser[i].setMember(false);
                } else {
                    matchUser[i].setMember(true);
                }
            }
        }
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

    @Override
    public void onBackPressed() {
        controller.keyBackHandler();
    }
}
