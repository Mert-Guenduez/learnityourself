package learnityourself.dhbw.learnityourself.controller;

import android.content.Context;
import android.content.Intent;

import learnityourself.dhbw.learnityourself.MainActivity;
import learnityourself.dhbw.learnityourself.model.User;

public class SpendPointsOnRewardsController extends AuthorizedController {

    public SpendPointsOnRewardsController(User user, Context context) {
        super(user, context);
    }

    @Override
    protected void init() {

    }

    public void keyBackHandler(){
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("user", user);
        context.startActivity(intent);
    }
}
