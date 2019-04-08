package learnityourself.dhbw.learnityourself.controller;

import android.content.Context;
import android.content.Intent;

import learnityourself.dhbw.learnityourself.MainActivity;
import learnityourself.dhbw.learnityourself.model.Reward;
import learnityourself.dhbw.learnityourself.model.User;

public class ViewRewardsController extends AuthorizedController {

    Reward[] rewards;

    public ViewRewardsController (User user, Context context) {
        super(user, context);
    }

    @Override
    protected void init() {

    }

    public Reward[] getRewards() {
        return rewards;
    }

    public void createReward() {

    }

    public void keyBackHandler(){
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("user", user);
        context.startActivity(intent);
    }
}
