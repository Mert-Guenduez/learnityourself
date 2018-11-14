package learnityourself.dhbw.learnityourself.model;

import java.util.Date;
import java.util.List;

public class Mission {

    private Date endDate;
    private String title;
    private List<User> users;
    private List<Task> tasks;

    public Mission(){

    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }






}
