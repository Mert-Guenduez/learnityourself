package learnityourself.dhbw.learnityourself;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
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
import android.widget.ListView;
import android.widget.Scroller;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import learnityourself.dhbw.learnityourself.controller.CreateMissionController;

import learnityourself.dhbw.learnityourself.model.AddUserAdapter;
import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.utility.Helper;

public class CreateMissionActivity extends AppCompatActivity {

    private EditText missionName, description;
    private TextView finishDate, finishTime;
    private ListView searchUsername;
    private SearchView searchView;
    private DatePickerDialog.OnDateSetListener dateSetListener;
    private CreateMissionController controller;
    private int day, month, year, hour, minute;
    private StringBuffer buffer;
    private Calendar cal;
    Helper helper = Helper.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_mission);

        controller=new CreateMissionController((User)getIntent().getSerializableExtra("user"),this);

        init();
    }

    void init(){
        missionName = findViewById(R.id.missionName_editText);
        description = findViewById(R.id.createMission_description_textview);
        finishDate = findViewById(R.id.date_createMission_textview);
        finishTime = findViewById(R.id.time_createMission_textview);
        searchView = findViewById(R.id.createMission_searchView);

        description.setScroller(new Scroller(this));
        description.setMaxLines(3);
        description.setVerticalScrollBarEnabled(true);
        description.setMovementMethod(new ScrollingMovementMethod());

        generateCalender();

        fillComponents();

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

                finishDate.setText(dateToString(year, month+1, dayOfMonth));
            }
        };


        buffer = new StringBuffer();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                setSearchUsername(controller.matchUser(newText));
                return false;
            }
        });

    }

    public void setSearchUsername(final User[] matchUser){
        // TODO Array im controller füllen
        updateSetSearchUsername(matchUser);

        searchUsername.setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
                        User user = controller.getMatchUser()[position];
                        if (!user.getUsername().equals(controller.getUser().getUsername())){
                            if (!controller.getMembersArrayList().contains(user)){
                                controller.getMembersArrayList().add(user);
                                addUserToString(user);
                            } else {
                                controller.getMembersArrayList().remove(user);
                                deleteUserFromString(user);
                            }
                            updateSetSearchUsername(matchUser);
                        }
                    }
                }
        );

    }

    public void addUserToString(User user){
        if (buffer.length() == 0){
            buffer.append("{\"users\":[\"" + user.getUsername() + "\"");
        } else {
            buffer.append(",\"" + user.getUsername() + "\"");
        }
    }

    public void deleteUserFromString(User user){
        int index = buffer.indexOf(user.getUsername());
        if (index > 12){
            buffer.delete(index-2, index + user.getUsername().length()+1);
        } else {
            buffer.delete(index-1, index + user.getUsername().length()+1);
        }
    }


    public void updateSetSearchUsername(User[] matchUser){

        controller.setMatchUser(matchUser);

        editSetMember(matchUser);

        searchUsername = (ListView) findViewById(R.id.createMission_missionMember_listview);
        searchUsername.setAdapter(new AddUserAdapter(this, matchUser));
    }

    public void editSetMember(User[] matchUser){

        for (int i = 0; i < controller.getMembersArrayList().size(); i++) {
            for (int j = 0; j < matchUser.length; j++) {
                if (controller.getMembersArrayList().contains(matchUser[j]) |
                        controller.getUser().getUsername().equals(matchUser[j].getUsername())){
                    matchUser[j].setMember(true);
                } else {
                    matchUser[j].setMember(false);
                }
            }
        }

        if (controller.getMembersArrayList().size() == 0){
            for (int i = 0; i < matchUser.length; i++) {
                if (!controller.getUser().getUsername().equals(matchUser[i].getUsername())){
                    matchUser[i].setMember(false);
                } else {
                    matchUser[i].setMember(true);
                }
            }
        }
    }

    private void fillComponents(){
        finishDate.setText(defaultDay());
        finishTime.setText(defaultTime());
    }

    private void generateCalender(){
        cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH);
        day = cal.get(Calendar.DAY_OF_MONTH);
        hour = cal.get(Calendar.HOUR_OF_DAY);
        minute = cal.get(Calendar.MINUTE);
    }

    private String defaultDay(){
        return dateToString(year, month+1, day);
    }

    private String defaultTime(){
        return timeToString(hour, minute);
    }

    private void datePicker(){
        DatePickerDialog dialog = new DatePickerDialog(
                CreateMissionActivity.this,
                AlertDialog.THEME_DEVICE_DEFAULT_DARK,
                dateSetListener,
                year, month, day);
        dialog.getDatePicker().setMinDate(cal.getTimeInMillis() - 1000);
        dialog.show();
    }

    private void timePicker(){

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
        return (((day < 10)? "0" + day : day) + "/" + ((month < 10)? "0" + month : month) + "/" + year);
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
                        controller.setMembersString(endBuffer());
                        controller.checkClickHandler();
                    }
                    return false;
                }
            });
        }
        return true;
    }

    public String endBuffer(){
        if (buffer.length()==12){
            buffer.delete(0,11);
        } else if (buffer.length()>12){
            buffer.append("]}");
        }
        return buffer.toString();
    }

    public boolean validEntry(){
        if (missionName.getText().toString().isEmpty()){
            missionName.setError("Insert Missionname.");
            return false;
        }
        if (description.getText().toString().isEmpty()){
            description.setError("Insert Description.");
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
