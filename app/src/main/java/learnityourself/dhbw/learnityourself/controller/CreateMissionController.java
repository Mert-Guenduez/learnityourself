package learnityourself.dhbw.learnityourself.controller;

import android.content.Context;
import android.content.Intent;

import learnityourself.dhbw.learnityourself.AddMissionMemberCreateMissionActivity;
import learnityourself.dhbw.learnityourself.ViewMissionsActivity;
import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.utility.Helper;

public class CreateMissionController extends AuthorizedController {

    public CreateMissionController(User user, Context context){
        super(user, context);
    }
    @Override
    protected void init() {

    }

    public void addUserClicked() {
        Intent intent = new Intent(context, AddMissionMemberCreateMissionActivity.class);
        intent.putExtra("user", user);
        context.startActivity(intent);
    }

    public void keyBackHandler(){
        Intent intent = new Intent(context, ViewMissionsActivity.class);
        intent.putExtra("user", user);
        context.startActivity(intent);
    }
}
