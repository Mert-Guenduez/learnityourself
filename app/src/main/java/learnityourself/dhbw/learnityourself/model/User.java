package learnityourself.dhbw.learnityourself.model;

import java.io.Serializable;

public class User implements Serializable {


    private String username;
    private int points;
    private String sessionkey;
    private boolean isMember;

    public User(String username, String sessionkey) {

        this.username = username;
        this.sessionkey = sessionkey;
        this.isMember = false;
    }

    public String getUsername() {
        return username;
    }

    public String getSessionkey() {
        return sessionkey;
    }

    public void setUsername(String username) {
       this.username=username;
    }

    public void setSessionkey(String sessionkey) {
        this.sessionkey = sessionkey;
    }

    public boolean isMember() {
        return isMember;
    }

    public void setMember(boolean member) {
        isMember = member;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
