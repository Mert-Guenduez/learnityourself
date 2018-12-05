package learnityourself.dhbw.learnityourself;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Calendar;

import learnityourself.dhbw.learnityourself.controller.CreateMissionController;

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
        controller=new CreateMissionController((User)getIntent().getSerializableExtra("user"),this);

        init();
    }

    void init(){
        missionName = findViewById(R.id.missionName_editText);
        finishDate = findViewById(R.id.date_createMission_textview);
        missionMembersList = findViewById(R.id.createMission_missionMember_listview);
        edit = findViewById(R.id.edit_createMission_imageButton);

        finishDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker();
            }
        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Log.d("AddMissionMemberActivity", "mm/dd/yyyy: " + month + "/" + dayOfMonth + "/" + year);

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

}
