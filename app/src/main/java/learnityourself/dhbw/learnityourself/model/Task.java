package learnityourself.dhbw.learnityourself.model;

import java.io.Serializable;

public class Task implements Serializable {

    private String taskid;
    private String taskname;

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }
}
