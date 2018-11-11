package learnityourself.dhbw.learnityourself.model;

public class User {

    private String username;
    private String sessionKey;

    public User(String username, String sessionKey){
        this.username=username;
        this.sessionKey=sessionKey;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public String getUsername() {
        return username;
    }
}
