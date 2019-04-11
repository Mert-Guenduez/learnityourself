package learnityourself.dhbw.learnityourself;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import learnityourself.dhbw.learnityourself.controller.SpendPointsOnRewardsController;
import learnityourself.dhbw.learnityourself.controller.ViewRewardsController;
import learnityourself.dhbw.learnityourself.model.RewardAdapter;
import learnityourself.dhbw.learnityourself.model.User;

public class SpendPointsOnRewardsActivity extends AppCompatActivity {
    private ListView rewardListView;
    private SpendPointsOnRewardsController controller;
    private ViewRewardsController rewardsController;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spend_points_on_rewards);
        Intent intent = getIntent();
        controller = new SpendPointsOnRewardsController((User)intent.getSerializableExtra("user"), this);
        rewardsController = new ViewRewardsController((User)intent.getSerializableExtra("user"), this);
        init();
    }

    void init() {
        rewardListView = findViewById(R.id.reward_list);
        rewardListView.setAdapter(new RewardAdapter(this, rewardsController.getRewards()));
    }

    @Override
    public void onBackPressed() {
        controller.keyBackHandler();
    }
}
