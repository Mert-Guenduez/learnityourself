package learnityourself.dhbw.learnityourself.controller;

import android.content.Context;

import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.utility.MatchUser;

public class AddMissionMemberCreateMissionController extends MatchUser {

    private User[] matchUser;

    public AddMissionMemberCreateMissionController(User user, Context context){
        super(user, context);
    }

    public User[] getMatchUser() {
        return matchUser;
    }

    public void setMatchUser(User[] matchUser) {
        this.matchUser = matchUser;
    }

    @Override
    protected void init() {

    }



}
