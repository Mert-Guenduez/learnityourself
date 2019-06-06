package learnityourself.dhbw.learnityourself.controller;

import android.content.Context;
import android.content.Intent;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import learnityourself.dhbw.learnityourself.ViewMissionsActivity;
import learnityourself.dhbw.learnityourself.model.Mission;
import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.modelFactories.MissionFactory;
import learnityourself.dhbw.learnityourself.utility.HTTPRequestHandler;
import learnityourself.dhbw.learnityourself.utility.MatchUser;

public class CreateMissionController extends MatchUser {
    private String membersString;
    private String[] membersNameString;
    private User[] matchUser;
    private ArrayList<User> membersArrayList;
    private User user;


    public CreateMissionController(User user, Context context){
        super(user, context);
        this.membersString = null;
        this.membersNameString = null;
        this.membersArrayList = new ArrayList<>();
        this.user = user;

        MissionFactory.createNewObject();
    }


    public void setMembersString(String membersString) {
        this.membersString = membersString;
    }

    public void setMissionname(String missionname) {
        MissionFactory.setName(missionname);
    }

    public void setDescription(String description) {
        MissionFactory.setDescription(description);
    }

    public void setDate(Date date) { MissionFactory.setDate(date); }

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
        Mission newMission = MissionFactory.getObject();
        String seconds =""+(newMission.getDeadline().getTime() - new Date().getTime());

        HTTPRequestHandler handler = new HTTPRequestHandler();
        handler.setContext(context);
        try {
           handler.execute("createMission.php","username",
                    user.getUsername(),"sessionkey", user.getSessionkey(),
                    "missionname", newMission.getMissionname(), "description", newMission.getDescription(), "seconds", seconds,
                    "users", (membersString.length()==0)? null : membersString)
                    .get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
