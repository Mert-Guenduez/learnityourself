package learnityourself.dhbw.learnityourself;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;


import org.json.JSONException;
import org.json.JSONObject;

import learnityourself.dhbw.learnityourself.controller.ViewMissionInformationController;
import learnityourself.dhbw.learnityourself.model.Mission;
import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.model.UserAdapter;


public class ViewMissionInformationActivity extends AppCompatActivity {


    private TextView description_textview, finishdate_textview;
    private ImageButton edit;
    private ListView userListView;

    private ViewMissionInformationController controller;

    private JSONObject info;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_mission_information);

        controller = new ViewMissionInformationController((User) getIntent().getSerializableExtra("user"), this);
        controller.setMission((Mission) getIntent().getSerializableExtra("mission"));
        try {
            info = new JSONObject(getIntent().getStringExtra("info"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        controller.loadUsers();

        description_textview = findViewById(R.id.description_textview);
        finishdate_textview = findViewById(R.id.date_textView);
        edit = findViewById(R.id.edit_imageButton);

        edit.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.addUserClicked();
            }
        }));
        init();

    }

    public void setDescription_textview() throws JSONException {

        this.description_textview.setText(info.getString("description"));
    }

    public void setFinishdate_textview() throws JSONException {

        this.finishdate_textview.setText(info.getString("deadline"));
    }

    void init() {


        try {
            setDescription_textview();
            setFinishdate_textview();
        } catch (JSONException e){
            System.err.println("JSONException: " + e.getMessage());
        }

        userListView = (ListView) findViewById(R.id.missionMember_listview);
        userListView.setAdapter(new UserAdapter(this, controller.getUsers()));
    }

    @Override
    public void onBackPressed() {
        controller.keyBackHandler();
    }

}
