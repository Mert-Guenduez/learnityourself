package learnityourself.dhbw.learnityourself.controller;

import android.content.Context;
import android.content.Intent;

import java.io.InputStream;
import java.util.concurrent.ExecutionException;

import learnityourself.dhbw.learnityourself.ViewRewardsActivity;
import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.utility.HTTPRequestHandler;

public class CreateCustomRewardController extends AuthorizedController{

    private User user;
    private String rewardName;
    private int points;

    public CreateCustomRewardController (User user, Context context) {
        super(user, context);

        this.user = user;
        this.rewardName = null;
        this.points = 0;
    }

    @Override
    protected void init() {

    }

    public void checkClickHandler () {
        createReward();
        returnToViewRewards();
    }

    private void returnToViewRewards() {
        Intent intent = new Intent(context, ViewRewardsActivity.class);
        intent.putExtra("user", user);
        context.startActivity(intent);
    }

    private void createReward() {
        HTTPRequestHandler handler = new HTTPRequestHandler();
        InputStream in  = null;
        try {
            in = handler.execute("https://91.205.172.109/createCustomReward.php","username",
                    user.getUsername(),"sessionkey", user.getSessionkey(),
                    "title", rewardName, "description", "", "cost", Integer.toString(points))
                    .get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String inputString=HTTPRequestHandler.getStringFromInputStream(in);

    }

    public void keyBackHandler() {
        returnToViewRewards();
    }

    @Override
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
