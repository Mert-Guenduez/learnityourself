package learnityourself.dhbw.learnityourself.controller;

import android.content.Context;
import android.content.Intent;

import com.google.gson.Gson;

import java.io.InputStream;
import java.util.concurrent.ExecutionException;

import learnityourself.dhbw.learnityourself.CreateCustomRewardActivity;
import learnityourself.dhbw.learnityourself.MainActivity;
import learnityourself.dhbw.learnityourself.model.Reward;
import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.utility.HTTPRequestHandler;

public class ViewRewardsController extends AuthorizedController {

    Reward[] rewards;

    public ViewRewardsController (User user, Context context) {
        super(user, context);
    }

    @Override
    protected void init() {
        HTTPRequestHandler handler = new HTTPRequestHandler();
        InputStream in  = null;
        try {
            in = handler.execute("https://91.205.172.109/allRewardsFromUser.php","username", user.getUsername(),"sessionkey", user.getSessionkey()).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        rewards = new Gson().fromJson(HTTPRequestHandler.getStringFromInputStream(in), Reward[].class);
    }

    public Reward[] getRewards() {
        return rewards;
    }

    public void missionClicked(int position) {
        // TODO
    }

    public void createReward() {
        Intent intent = new Intent(context, CreateCustomRewardActivity.class);
        intent.putExtra("user", user);
        intent.putExtra("rewardNames", rewards);
        context.startActivity(intent);
    }

    public void keyBackHandler(){
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("user", user);
        context.startActivity(intent);
    }
}
