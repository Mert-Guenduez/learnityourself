package learnityourself.dhbw.learnityourself.controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

import learnityourself.dhbw.learnityourself.CreateMissionActivity;
import learnityourself.dhbw.learnityourself.ViewMissionsActivity;
import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.utility.MatchUser;

public class AddMissionMemberCreateMissionController extends MatchUser {

    private User[] matchUser;
    private String membersString;
    private ArrayList<User> membersArrayList;
    private String[] membersNameString;
    private User user;

    public AddMissionMemberCreateMissionController(User user, Context context){
        super(user, context);
        this.user = user;
        membersArrayList = new ArrayList<>();
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

    public String getMembersString() {
        return membersString;
    }

    public void setMembersString(String membersString) {
        this.membersString = membersString;
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

    public void checkClickHandler() {
        setMembersNameString();

        Intent intent = new Intent(context, CreateMissionActivity.class);
        intent.putExtra("user", user);
        intent.putExtra("membersString", membersString);
        intent.putExtra("membersNameString", membersNameString);
        context.startActivity(intent);
    }

    public void setMembersNameString() {
        membersNameString = new String[membersArrayList.size()];
        for (int i = 0; i < membersArrayList.size(); i++) {
            membersNameString[i] = membersArrayList.get(i).getUsername();
        }
    }

    public String[] getMembersNameString() {
        return membersNameString;
    }

    public void keyBackHandler(){
        Intent intent = new Intent(context, CreateMissionActivity.class);
        intent.putExtra("user", user);
        context.startActivity(intent);
    }
}
