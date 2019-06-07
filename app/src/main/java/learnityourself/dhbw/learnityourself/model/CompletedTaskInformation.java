package learnityourself.dhbw.learnityourself.model;

import java.util.Date;

public class CompletedTaskInformation {
    private Date completedDate;
    private int count;

    public Date getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(Date completedDate) {
        this.completedDate = completedDate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
