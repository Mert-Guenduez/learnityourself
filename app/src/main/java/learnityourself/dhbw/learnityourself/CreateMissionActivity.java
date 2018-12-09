package learnityourself.dhbw.learnityourself;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import learnityourself.dhbw.learnityourself.controller.CreateMissionController;

import learnityourself.dhbw.learnityourself.model.MissionMemberAdapter;
import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.utility.Helper;

public class CreateMissionActivity extends AppCompatActivity {

    private EditText missionName, description;
    private TextView finishDate, finishTime;
    private ListView missionMembersList;
    private ImageButton edit;
    private DatePickerDialog.OnDateSetListener dateSetListener;
    private CreateMissionController controller;
    private int day, month, year, hour, minute;

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
        description = findViewById(R.id.createMission_description_textview);
        finishDate = findViewById(R.id.date_createMission_textview);
        finishTime = findViewById(R.id.time_createMission_textview);
        edit = findViewById(R.id.edit_createMission_imageButton);

        description.setScroller(new Scroller(this));
        description.setMaxLines(3);
        description.setVerticalScrollBarEnabled(true);
        description.setMovementMethod(new ScrollingMovementMethod());

        fillComponents();

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

        finishTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePicker();
            }
        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Log.d("AddMissionMemberLayout", "mm/dd/yyyy: " + month + "/" + dayOfMonth + "/" + year);

                finishDate.setText(dateToString(year, month+1, day));
            }
        };

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Helper helper = Helper.getInstance();
                helper.setMissionname(missionName.getText().toString());
                helper.setDescription(description.getText().toString());
                helper.setDate(finishDate.getText().toString());
                helper.setTime(finishTime.getText().toString());
                helper.setCreateMissionInformation(true);
                controller.addUserClicked();
            }
        });

    }

    private void fillComponents(){
        Helper helper = Helper.getInstance();
        if (helper.isCreateMissionInformation()){
            missionName.setText(helper.getMissionname());
            description.setText(helper.getDescription());
            finishDate.setText(helper.getDate());
            finishTime.setText(helper.getTime());
        } else {
            finishDate.setText(defaultDay());
            finishTime.setText(defaultTime());
        }
    }

    private String defaultDay(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);

        return dateToString(year, month+1, day);
    }

    private String defaultTime(){
        Calendar cal = Calendar.getInstance();
        hour = cal.get(Calendar.HOUR_OF_DAY);
        minute = cal.get(Calendar.MINUTE);

        return timeToString(hour, minute);
    }

    private void datePicker(){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(
                CreateMissionActivity.this,
                AlertDialog.THEME_DEVICE_DEFAULT_DARK,
                dateSetListener,
                year, month, day);
        dialog.getDatePicker().setMinDate(cal.getTimeInMillis() - 1000);
        dialog.show();
    }

    private void timePicker(){
        final Calendar cal = Calendar.getInstance();
        hour = cal.get(Calendar.HOUR_OF_DAY);
        minute = cal.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                AlertDialog.THEME_HOLO_DARK,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {
                        // TODO check Minutes
                        finishTime.setText(timeToString(hour, minute));
                    }
                }, hour, minute, false);
        timePickerDialog.show();
    }

    public String timeToString(int hour, int minute){
        return ((hour<10)? "0" + (hour) : hour) + ":" + ((minute<10)? "0" + (minute) : minute);
    }

    public String dateToString(int year, int month, int day){
        return ((month < 10)? "0" + month : month) + "/" + ((day < 10)? "0" + day : day + "/" + year);
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
                    if (validEntry()){
                        controller.setMissionname(missionName.getText().toString());
                        controller.setDescription(description.getText().toString());
                        controller.setSeconds(getSeconds() + "");
                        clearHelper();
                        controller.checkClickHandler();
                    }
                    return false;
                }
            });
        }
        return true;
    }

    public void clearHelper(){
        Helper helper = Helper.getInstance();
        helper.setTime("");
        helper.setDate("");
        helper.setDescription("");
        helper.setMissionname("");
        helper.setCreateMissionInformation(false);
    }

    public boolean validEntry(){
        if (missionName.getText().toString().isEmpty()){
            missionName.setError("Insert Missionname.");
            return false;
        }
        if (description.getText().toString().isEmpty()){
            description.setError("Insert Description");
            return false;
        }
        return true;
    }

    public Date endDate(){
        String strDate = year+"-"+month+"-"+day+"T"+hour+":"+minute+":00.000Z";

        try {
            SimpleDateFormat sdfSource = new SimpleDateFormat(
                    "yyyy-MM-dd'T'hh:mm:ss'.000Z'");

            Date date = sdfSource.parse(strDate);
            return date;

        } catch (ParseException pe) {
            System.out.println("Parse Exception : " + pe);
        }
        return null;
    }

    public long getSeconds(){
        Date date = new Date();

        return date.getTime() - endDate().getTime();
    }

    @Override
    public void onBackPressed() {
        controller.keyBackHandler();
    }
}
