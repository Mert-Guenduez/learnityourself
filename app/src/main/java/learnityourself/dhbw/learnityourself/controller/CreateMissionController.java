package learnityourself.dhbw.learnityourself.controller;

import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;

import learnityourself.dhbw.learnityourself.AddMissionMemberCreateMissionActivity;
import learnityourself.dhbw.learnityourself.ViewMissionsActivity;
import learnityourself.dhbw.learnityourself.model.User;

public class CreateMissionController extends AuthorizedController {
    private String membersString;
    private String[] membersNameString;

    public CreateMissionController(User user, Context context){
        super(user, context);
    }

    public CreateMissionController(User user, String membersString, String[] membersNameString, Context context){
        super(user, context);
        this.membersString = membersString;
        this.membersNameString = membersNameString;
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

    public void setMembersNameString(String[] membersNameString) {
        this.membersNameString = membersNameString;
    }

    @Override
    protected void init() {

    }

    public void addUserClicked() {
        Intent intent = new Intent(context, AddMissionMemberCreateMissionActivity.class);
        intent.putExtra("user", user);
        context.startActivity(intent);
    }

    public void checkClickHandler(){

    }

    public void keyBackHandler(){
        Intent intent = new Intent(context, ViewMissionsActivity.class);
        intent.putExtra("user", user);
        context.startActivity(intent);
    }
}
