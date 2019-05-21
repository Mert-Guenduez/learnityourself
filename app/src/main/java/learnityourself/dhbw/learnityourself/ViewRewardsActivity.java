package learnityourself.dhbw.learnityourself;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;

import learnityourself.dhbw.learnityourself.controller.ViewRewardsController;
import learnityourself.dhbw.learnityourself.model.RewardAdapter;
import learnityourself.dhbw.learnityourself.model.User;

public class ViewRewardsActivity extends AppCompatActivity {

    private ListView rewardListView;
    private ViewRewardsController controller;
    private User user;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_rewards);
        Intent intent = getIntent();
        user = (User) intent.getSerializableExtra("user");
        controller=new ViewRewardsController(user, this);
        init();
    }

    void init() {
        rewardListView = findViewById(R.id.reward_list);
        rewardListView.setAdapter(new RewardAdapter(this, user, controller.getRewards()));

        rewardListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        controller.missionClicked(position, view);
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
            controller.createReward();
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        controller.keyBackHandler();
    }

}
