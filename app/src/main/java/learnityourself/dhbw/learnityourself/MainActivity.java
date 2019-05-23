package learnityourself.dhbw.learnityourself;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import learnityourself.dhbw.learnityourself.controller.MainController;
import learnityourself.dhbw.learnityourself.model.User;

public class MainActivity extends AppCompatActivity {

    private TextView user_label,  points_label;
    private Button missions_button, logout_button, rewards_button, achievements_button;
    private MainController controller;
    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = new MainController( (User) getIntent().getSerializableExtra("user"),this);
        if(controller.getUser()!=null){
            init();
        }


     }

     private void init() {

         user_label = findViewById(R.id.mainUserLabel);
         user_label.setText(controller.getUser().getUsername());

         controller.fetchUserPoints();
         points_label = findViewById(R.id.pointsLabel);
         points_label.setText(controller.getUser().getPoints() + " Points");


        rewards_button = findViewById(R.id.rewards_button);
        achievements_button = findViewById(R.id.achievements_button);
        logout_button = findViewById(R.id.logout_button);
        missions_button = findViewById(R.id.missions_button);

        rewards_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.viewRewards();
            }
        });
        achievements_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: view AchievementsActivity
            }
        });
        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.logout();
            }
        });
        missions_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.viewMissions();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.options){
            controller.openOptions();
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        controller.keyBackHandler();
    }
}
