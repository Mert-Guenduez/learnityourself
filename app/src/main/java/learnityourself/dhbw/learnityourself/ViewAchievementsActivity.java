package learnityourself.dhbw.learnityourself;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import learnityourself.dhbw.learnityourself.controller.ViewAchievementsController;
import learnityourself.dhbw.learnityourself.controller.ViewMissionsController;
import learnityourself.dhbw.learnityourself.model.AchievementAdapter;
import learnityourself.dhbw.learnityourself.model.MissionAdapter;
import learnityourself.dhbw.learnityourself.model.User;

public class ViewAchievementsActivity extends AppCompatActivity{


    private ListView achievementListView;
    private ViewAchievementsController controller;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_missions);
        Intent intent = getIntent();
        controller=new ViewAchievementsController((User) intent.getSerializableExtra("user"), this);
        init();
    }

    void init() {

        achievementListView = (ListView) findViewById(R.id.achievement_list);
        achievementListView.setAdapter(new AchievementAdapter(this, controller.getAchievements()));

    }

    @Override
    public void onBackPressed() {
        controller.keyBackHandler();
    }

}
