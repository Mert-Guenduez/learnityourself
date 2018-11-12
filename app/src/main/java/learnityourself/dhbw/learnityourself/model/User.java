package learnityourself.dhbw.learnityourself.model;

import java.io.Serializable;

public class User implements Serializable {


    private String user;
    private String sessionkey;

    public User(String user, String sessionkey) {

        this.user = user;
        this.sessionkey = sessionkey;
    }

    public String getUser() {
        return user;
    }

    public String getSessionkey() {
        return sessionkey;
    }

    public void setUser(String user) {
       this.user=user;
    }

    public void setSessionkey(String sessionkey) {
        this.sessionkey = sessionkey;
    }



}
