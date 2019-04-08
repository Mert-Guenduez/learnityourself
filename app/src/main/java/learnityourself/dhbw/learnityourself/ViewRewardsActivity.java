package learnityourself.dhbw.learnityourself;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import learnityourself.dhbw.learnityourself.controller.ViewMissionsController;
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
        rewardListView = (ListView) findViewById(R.id.reward_list);
        rewardListView.setAdapter(new RewardAdapter(this, controller.getRewards()));
    }
}
