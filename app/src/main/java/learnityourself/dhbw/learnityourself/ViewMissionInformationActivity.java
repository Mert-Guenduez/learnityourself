package learnityourself.dhbw.learnityourself;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

import learnityourself.dhbw.learnityourself.controller.ViewMissionInformationController;
import learnityourself.dhbw.learnityourself.model.Mission;
import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.model.UserAdapter;
import learnityourself.dhbw.learnityourself.utility.HTTPRequestHandler;
import learnityourself.dhbw.learnityourself.utility.Helper;


public class ViewMissionInformationActivity extends AppCompatActivity {


    private TextView description_textview, finishdate_textview;
    private ImageButton edit;
    private ListView userListView;

    private ViewMissionInformationController controller;

    private JSONObject jsonObject;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_mission_information);

        controller = new ViewMissionInformationController((User) getIntent().getSerializableExtra("user"), this);
        controller.setMission((Mission) getIntent().getSerializableExtra("mission"));
        controller.loadUsers();

        description_textview = findViewById(R.id.description_textview);
        finishdate_textview = findViewById(R.id.date_textView);
        edit = findViewById(R.id.edit_imageButton);

        jsonObject = Helper.getInstance().getJsonObject();

        edit.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.addUserClicked();
            }
        }));
        init();

    }

    public void setDescription_textview() throws JSONException {

        this.description_textview.setText(jsonObject.getString("description"));
    }

    public void setFinishdate_textview() throws JSONException {

        this.finishdate_textview.setText(jsonObject.getString("deadline"));
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


}
