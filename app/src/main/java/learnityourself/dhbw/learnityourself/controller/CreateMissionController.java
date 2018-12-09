package learnityourself.dhbw.learnityourself.controller;

import android.content.Context;
import android.content.Intent;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import learnityourself.dhbw.learnityourself.AddMissionMemberCreateMissionActivity;
import learnityourself.dhbw.learnityourself.ViewMissionsActivity;
import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.utility.HTTPRequestHandler;
import learnityourself.dhbw.learnityourself.utility.Helper;
import learnityourself.dhbw.learnityourself.utility.MatchUser;

public class CreateMissionController extends MatchUser {
    private String membersString;
    private String[] membersNameString;
    private User[] matchUser;
    private String missionname, description, seconds;
    private ArrayList<User> membersArrayList;
    private User user;


    public CreateMissionController(User user, String membersString, String[] membersNameString, Context context){
        super(user, context);
        this.membersString = membersString;
        this.membersNameString = membersNameString;
        this.membersArrayList = new ArrayList<>();
        this.user = user;
    }

    public String getMembersString() {
        return membersString;
    }

    public void setMembersString(String membersString) {
        this.membersString = membersString;
    }

    public String[] getMembersNameString() {
        return membersNameString;
    }

    public String getMissionname() {
        return missionname;
    }

    public void setMissionname(String missionname) {
        this.missionname = missionname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSeconds() {
        return seconds;
    }

    public void setSeconds(String seconds) {
        this.seconds = seconds;
    }

    public void setMembersNameString(String[] membersNameString) {
        this.membersNameString = membersNameString;
    }

    public User[] getMatchUser() {
        return matchUser;
    }

    public void setMatchUser(User[] matchUser) {
        this.matchUser = matchUser;
    }

    public ArrayList<User> getMembersArrayList() {
        return membersArrayList;
    }

    public void setMembersArrayList(ArrayList<User> membersArrayList) {
        this.membersArrayList = membersArrayList;
    }

    @Override
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    protected void init() {

    }

    public void checkClickHandler(){
        createMission();
        returnToViewMissions();
    }

    public void createMission(){
        System.out.println("USERNAME: " + user.getUsername());
        System.out.println("SESSIONKEY: " + user.getSessionkey());
        System.out.println("MISSIONNAME: " + missionname);
        System.out.println("DESCRIPTION: " + description);
        System.out.println("SECONDS: " + seconds);
        System.out.println("MEMBERS: " + membersString);

        HTTPRequestHandler handler = new HTTPRequestHandler();
        InputStream in  = null;
        try {
            in = handler.execute("https://91.205.172.109/createMission.php","username",
                    user.getUsername(),"sessionkey", user.getSessionkey(),
                    "missionname", missionname, "description", description, "seconds", seconds,
                    "users", (membersString.length()==0)? null : membersString)
                    .get();
        } catch (ExecutionException e) {
            System.out.println("EXECUTATIONEXCEPTION: " + e.getMessage());
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("INTERRUPTEDEXCETION: " + e.getMessage());
            e.printStackTrace();
        }

        String inputString=HTTPRequestHandler.getStringFromInputStream(in);

        System.out.println("ERGEBNIS: " + inputString);
    }

    public void keyBackHandler(){
        returnToViewMissions();
    }

    public void returnToViewMissions(){
        Intent intent = new Intent(context, ViewMissionsActivity.class);
        intent.putExtra("user", user);
        context.startActivity(intent);
    }
}
