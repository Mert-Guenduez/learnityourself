package learnityourself.dhbw.learnityourself.modelFactories;

import learnityourself.dhbw.learnityourself.model.Reward;

public class RewardFactory {
    private static Reward reward;

    public static void createNewObject(){reward = new Reward(); }

    public static void setCost(int cost){
        reward.setCost(cost);
    }
    public static void setName(String name){
        reward.setTitle(name);
    }
    public static void setId(String id){ reward.setRewardId(id);}
    public static void setOwner(String owner) {reward.setOwner(owner);}


    public static Reward getObject(){return reward;};

}
