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

public class AddMissionMemberLayout extends AppCompatActivity {

    private TextView username_field;
    private SearchView searchView;
    private ListView searchUsername;
    private AddMissionMemberController controller;

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