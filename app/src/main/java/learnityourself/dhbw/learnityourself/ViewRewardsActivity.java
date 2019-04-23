package learnityourself.dhbw.learnityourself;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import learnityourself.dhbw.learnityourself.controller.ViewRewardsController;
import learnityourself.dhbw.learnityourself.model.RewardAdapter;
import learnityourself.dhbw.learnityourself.model.User;

public class ViewRewardsActivity extends AppCompatActivity {

    private ListView rewardListView;
    private ViewRewardsController controller;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_rewards);
        Intent intent = getIntent();
        controller=new ViewRewardsController((User) intent.getSerializableExtra("user"), this);
        init();
    }

    void init() {
        rewardListView = findViewById(R.id.reward_list);
        rewardListView.setAdapter(new RewardAdapter(this, controller.getRewards()));

        /*
        rewardListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //
                    }
                }
        );
        */
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
