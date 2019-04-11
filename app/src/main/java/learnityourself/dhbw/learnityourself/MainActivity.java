package learnityourself.dhbw.learnityourself;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import learnityourself.dhbw.learnityourself.controller.MainController;
import learnityourself.dhbw.learnityourself.model.User;

public class MainActivity extends AppCompatActivity {

    private TextView user_label;
    private Button missions_button, logout_button, rewards_button, spendPoints_button;
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

        rewards_button = findViewById(R.id.rewards_button);
        spendPoints_button = findViewById(R.id.spendPoints_button);
        logout_button = findViewById(R.id.logout_button);
        missions_button = findViewById(R.id.missions_button);

        rewards_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.viewRewards();
            }
        });
        spendPoints_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.viewSpendPointsOnRewards();
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
    public void onBackPressed() {
        controller.keyBackHandler();
    }
}
