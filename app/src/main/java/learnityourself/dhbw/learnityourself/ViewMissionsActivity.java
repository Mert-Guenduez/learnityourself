package learnityourself.dhbw.learnityourself;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import learnityourself.dhbw.learnityourself.controller.ViewMissionsController;
import learnityourself.dhbw.learnityourself.model.MissionAdapter;
import learnityourself.dhbw.learnityourself.model.User;

public class ViewMissionsActivity extends AppCompatActivity{


    private ListView missionListView;
    private ViewMissionsController controller;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_missions);
        Intent intent = getIntent();
        controller=new ViewMissionsController((User) intent.getSerializableExtra("user"), this);
        init();
    }

    void init() {

        missionListView = (ListView) findViewById(R.id.mission_list);
        missionListView.setAdapter(new MissionAdapter(this, controller.getMissions()));

        missionListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> arg0, View view,int position, long arg3) {
                        // TODO Auto-generated method stub
                        controller.missionClicked(position);
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.add){
            // TODO add create new Mission
        }
        return true;
    }


}
