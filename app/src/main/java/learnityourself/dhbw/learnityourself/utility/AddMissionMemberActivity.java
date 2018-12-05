package learnityourself.dhbw.learnityourself.utility;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import learnityourself.dhbw.learnityourself.R;
import learnityourself.dhbw.learnityourself.controller.AddMissionMemberController;
import learnityourself.dhbw.learnityourself.model.AddUserAdapter;
import learnityourself.dhbw.learnityourself.model.Mission;
import learnityourself.dhbw.learnityourself.model.User;

public class AddMissionMemberActivity extends AppCompatActivity {

    private TextView username_field;
    private SearchView searchView;
    private ListView searchUsername;
    private AddMissionMemberController controller;

/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    */


    public void setSearchUsername(final User[] matchUser){
        // TODO Array im controller füllen
        updateSetSeachUsername(matchUser);

        searchUsername.setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
                        User selectedUser = controller.getMatchUser()[position];
                        controller.addUser(selectedUser.getUsername());
                        controller.getMission().getUsers().add(selectedUser);
                        updateSetSeachUsername(matchUser);
                    }
                }
        );
    }

    public void updateSetSeachUsername(User[] matchUser){
        controller.setMatchUser(matchUser);

        for (int i = 0; i < controller.getMission().getUsers().size(); i++) {
            for (int j = 0; j < matchUser.length; j++) {
                if (controller.getMission().getUsers().get(i).getUsername().equals(matchUser[j].getUsername())){
                    matchUser[j].setMember(true);
                }
            }
        }

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
                    controller.checkClickHandler();
                    return false;
                }
            });
        }
        return true;
    }

}