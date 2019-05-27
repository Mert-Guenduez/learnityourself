package learnityourself.dhbw.learnityourself.model;

import java.io.Serializable;

public class Reward implements Serializable {

    private int rewardid;
    private String title;
    private String owner;
    private int cost;

    public int getRewardid() {
        return rewardid;
    }

    public void setRewardid(int rewardid) {
        this.rewardid = rewardid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
