package learnityourself.dhbw.learnityourself;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import learnityourself.dhbw.learnityourself.model.Mission;
import learnityourself.dhbw.learnityourself.model.MissionAdapter;
import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.utility.HTTPRequestHandler;

public class ViewMissionsActivity extends AuthorizedActivity {

    List<Mission> missions;
    ListView missionListView;


    Button newMissionButton;
    User user;
    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_missions);
        if(checkAuthorized())init();
    }

    @Override
    void init() {
        newMissionButton = findViewById(R.id.newMission_button);
        newMissionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ViewMissionsActivity.this, "Not yet implemented.", Toast.LENGTH_SHORT).show();
            }
        });

        missionListView = findViewById(R.id.mission_list);
        missionListView.setAdapter(new MissionAdapter());
    }


}
