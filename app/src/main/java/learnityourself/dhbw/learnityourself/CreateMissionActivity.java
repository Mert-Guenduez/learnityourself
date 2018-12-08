package learnityourself.dhbw.learnityourself;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

import learnityourself.dhbw.learnityourself.controller.CreateMissionController;

import learnityourself.dhbw.learnityourself.model.MissionMemberAdapter;
import learnityourself.dhbw.learnityourself.model.User;

public class CreateMissionActivity extends AppCompatActivity {

    private EditText missionName;
    private TextView finishDate;
    private ListView missionMembersList;
    private ImageButton edit;
    private DatePickerDialog.OnDateSetListener dateSetListener;
    private CreateMissionController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_mission);
        controller=new CreateMissionController((User)getIntent().getSerializableExtra("user"),
                (String)getIntent().getExtras().get("membersString"),
                getIntent().getStringArrayExtra("membersNameString"),this);
        init();
    }

    void init(){
        missionName = findViewById(R.id.missionName_editText);
        finishDate = findViewById(R.id.date_createMission_textview);
        edit = findViewById(R.id.edit_createMission_imageButton);

        missionMembersList = (ListView)findViewById(R.id.createMission_missionMember_listview);
        if (controller.getMembersNameString().length > 0){
            missionMembersList.setAdapter(new MissionMemberAdapter(this, controller.getMembersNameString()));
        }


        finishDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker();
            }
        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Log.d("AddMissionMemberLayout", "mm/dd/yyyy: " + month + "/" + dayOfMonth + "/" + year);

                String date = month + "/" + dayOfMonth + "/" + year;
                finishDate.setText(date);
            }
        };

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.addUserClicked();
            }
        });

    }

    private void datePicker(){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(
                CreateMissionActivity.this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                dateSetListener,
                year, month, day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_check, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.check){
            item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    controller.checkClickHandler();
                    return false;
                }
            });
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        controller.keyBackHandler();
    }
}
