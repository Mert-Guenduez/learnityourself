package learnityourself.dhbw.learnityourself.controller;

import android.content.Context;

import learnityourself.dhbw.learnityourself.model.Mission;
import learnityourself.dhbw.learnityourself.model.User;

public class ViewTaskController extends AuthorizedController{

    public ViewTaskController(User user, Context context){
        super(user, context);
    }
    @Override
    protected void init() {

    }

    public void setTask(Mission task) {
    }

    public void loadTaskDetail() {
    }
}
