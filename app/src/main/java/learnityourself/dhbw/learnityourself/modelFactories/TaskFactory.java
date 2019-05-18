package learnityourself.dhbw.learnityourself.modelFactories;

import learnityourself.dhbw.learnityourself.model.Task;

public class TaskFactory {
    private static Task task;

    public static void createNewObject(){task = new Task(); }

    public static void setCompleted(Boolean completed){
        task.setCompleted(completed);
    }
    public static void setEffort(int effort){
        task.setEffort(effort);
    }
    public static void setDescription(String description){
        task.setDescription(description);
    }
    public static void setName(String taskName){
        task.setTaskname(taskName);
    }
    public static void setId(String id){
        task.setTaskid(id);
    }
    public static void setMissionId(String id){
        task.setMissionid(id);
    }

    public static Task getObject(){return task;};

}
