package learnityourself.dhbw.learnityourself.controller;

import android.content.Context;
import android.content.Intent;

import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

import learnityourself.dhbw.learnityourself.ViewRewardsActivity;
import learnityourself.dhbw.learnityourself.model.Reward;
import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.modelFactories.RewardFactory;
import learnityourself.dhbw.learnityourself.utility.HTTPRequestHandler;

public class CreateCustomRewardController extends AuthorizedController{
    private int rewardPosition;
    private Reward[] rewards;
    Logger logger;

    public CreateCustomRewardController(User user, Context context, int rewardPosition, Reward[] rewards) {
        super(user, context);
        this.user = user;
        this.rewardPosition = rewardPosition;
        this.rewards = rewards;
        logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        RewardFactory.createNewObject();
    }

    @Override
    protected void init() {
        //Empty Init
    }

    public void checkClickHandler () {
        if (rewardPosition > -1) {
            editReward();
        } else {
            createReward();
        }
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
        handler.setContext(context);
        try {
            handler.execute("createCustomReward.php","username",
                    user.getUsername(),"sessionkey", user.getSessionkey(),
                    "title", newReward.getTitle(), "description", "", "cost", Integer.toString(newReward.getCost()))
                    .get();
        } catch (ExecutionException e) {
            logger.warning(e.toString());
        } catch (InterruptedException e) {
            logger.warning(e.toString());
            Thread.currentThread().interrupt();
        }

    }

    private void editReward() {
        Reward newReward = RewardFactory.getObject();
        HTTPRequestHandler handler = new HTTPRequestHandler();
        handler.setContext(context);
        try {
           handler.execute("editReward.php","username",
                    user.getUsername(),"sessionkey", user.getSessionkey(),
                    "rewardid", Integer.toString(rewards[rewardPosition].getRewardid()) ,
                    "title", newReward.getTitle(), "description", "", "cost", Integer.toString(newReward.getCost()))
                    .get();
        } catch (ExecutionException e) {
            logger.warning(e.toString());
        } catch (InterruptedException e) {
            logger.warning(e.toString());
            Thread.currentThread().interrupt();
        }

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
