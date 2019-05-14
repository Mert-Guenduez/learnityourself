package learnityourself.dhbw.learnityourself.controller;

import android.content.Context;
import android.content.Intent;

import java.io.InputStream;
import java.util.concurrent.ExecutionException;

import learnityourself.dhbw.learnityourself.ViewRewardsActivity;
import learnityourself.dhbw.learnityourself.model.Reward;
import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.modelFactories.RewardFactory;
import learnityourself.dhbw.learnityourself.utility.HTTPRequestHandler;

public class CreateCustomRewardController extends AuthorizedController{

    public CreateCustomRewardController (User user, Context context) {
        super(user, context);
        this.user = user;
        RewardFactory.createNewObject();
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
        Reward newReward = RewardFactory.getObject();
        HTTPRequestHandler handler = new HTTPRequestHandler();
        InputStream in  = null;
        try {
            in = handler.execute("https://91.205.172.109/createCustomReward.php","username",
                    user.getUsername(),"sessionkey", user.getSessionkey(),
                    "title", newReward.getTitle(), "description", "", "cost", Integer.toString(newReward.getCost()))
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRewardName(String rewardName) {
        RewardFactory.setName(rewardName);
    }

    public void setPoints(int points) {RewardFactory.setCost(points);}
}
