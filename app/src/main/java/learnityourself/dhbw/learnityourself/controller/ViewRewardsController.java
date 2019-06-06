package learnityourself.dhbw.learnityourself.controller;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;

import com.google.gson.Gson;

import java.io.InputStream;
import java.util.concurrent.ExecutionException;

import learnityourself.dhbw.learnityourself.CreateCustomRewardActivity;
import learnityourself.dhbw.learnityourself.MainActivity;
import learnityourself.dhbw.learnityourself.R;
import learnityourself.dhbw.learnityourself.model.Reward;
import learnityourself.dhbw.learnityourself.model.RewardAdapter;
import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.utility.HTTPRequestHandler;

public class ViewRewardsController extends AuthorizedController {

    Reward[] rewards;
    Context context;
    RewardAdapter rewardAdapter;

    public ViewRewardsController (User user, Context context) {
        super(user, context);
        this.context = context;
    }

    @Override
    protected void init() {
        HTTPRequestHandler handler = new HTTPRequestHandler();
        handler.setContext(context);
        InputStream in  = null;
        try {
            in = handler.execute("allRewardsFromUser.php","username", user.getUsername(),"sessionkey", user.getSessionkey()).get();
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

    public void missionClicked(final int position, View view) {
        PopupMenu popupMenu = new PopupMenu(context, view);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getTitle().equals("Edit")) {
                    editReward(position);
                } else if (item.getTitle().equals("Delete")){
                    deleteReward(position);
                }
                return false;
            }
        });

        popupMenu.show();
    }

    public void editReward(int position) {
        Intent intent = new Intent(context, CreateCustomRewardActivity.class);
        intent.putExtra("user", user);
        intent.putExtra("rewardNames", rewards);
        intent.putExtra("reward", position);
        context.startActivity(intent);
    }

    public void deleteReward(int position) {
        HTTPRequestHandler handler = new HTTPRequestHandler();
        handler.setContext(context);
        InputStream in  = null;
        try {
            in = handler.execute("deleteReward.php","username", user.getUsername()
                    ,"sessionkey", user.getSessionkey()
                    ,"rewardid", Integer.toString(rewards[position].getRewardid())).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        init();
        rewardAdapter.updateResults(rewards);
    }

    public void createReward() {
        Intent intent = new Intent(context, CreateCustomRewardActivity.class);
        intent.putExtra("user", user);
        intent.putExtra("rewardNames", rewards);
        intent.putExtra("reward", -1);
        context.startActivity(intent);
    }

    public void keyBackHandler(){
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("user", user);
        context.startActivity(intent);
    }

    public void setRewardAdapter(RewardAdapter rewardAdapter) {
        this.rewardAdapter = rewardAdapter;
    }
}
