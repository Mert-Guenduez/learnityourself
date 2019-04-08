package learnityourself.dhbw.learnityourself.controller;

import android.content.Context;

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
}
