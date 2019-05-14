package learnityourself.dhbw.learnityourself.modelFactories;

import learnityourself.dhbw.learnityourself.model.User;

public class UserFactory {
    private static User user;

    public static void createNewObject(){
        user = new User();
    }

    public static void setUserName(String name){
        user.setUsername(name);
    }

    public static void setIsMember(boolean isMember){
        user.setMember(isMember);
    }

    public static void setSessionKey(String sessionKey){
        user.setSessionkey(sessionKey);
    }

    public static void setPoints(int points){
        user.setPoints(points);
    }

    public static User getObject(){
        return user;
    }
}
