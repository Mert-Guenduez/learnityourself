package learnityourself.dhbw.learnityourself.modelFactories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import learnityourself.dhbw.learnityourself.model.Mission;
import learnityourself.dhbw.learnityourself.model.User;

public class MissionFactory {
    private static Mission mission;

    public static void createNewObject(){mission = new Mission(); }

    public static void setDate(Date date){
        mission.setDeadline(date);
    }
    public static void setDescription(String description){
        mission.setDescription(description);
    }
    public static void setName(String missionName){mission.setMissionname(missionName); }
    public static void setId(String id){mission.setMissionid(id); }
    public static void setOwner(String owner){mission.setOwner(owner);};
    public static void setId(ArrayList<User> users){mission.setUsers(users);}

    public static Mission getObject(){return mission;};

}
