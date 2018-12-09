package learnityourself.dhbw.learnityourself.utility;

import org.json.JSONObject;

import java.io.InputStream;

import learnityourself.dhbw.learnityourself.controller.CreateMissionController;
import learnityourself.dhbw.learnityourself.model.Mission;

public class Helper {


    private static Helper helper = new Helper();
    private InputStream inputStream;
    private JSONObject jsonObject;
    private Mission mission;
    private String missionname, description, date, time;
    private boolean createMissionInformation;
    private CreateMissionController createMissionController;

    private Helper(){

    }

    public static Helper getInstance() {
        return helper;
    }

    public void setInputStreamer(InputStream in){
        this.inputStream = in;
    }

    public InputStream getInputStreamer(){
        return this.inputStream;
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }

    public String getMissionname() {
        return missionname;
    }

    public void setMissionname(String missionname) {
        this.missionname = missionname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isCreateMissionInformation() {
        return createMissionInformation;
    }

    public void setCreateMissionInformation(boolean createMissionInformation) {
        this.createMissionInformation = createMissionInformation;
    }

    public CreateMissionController getCreateMissionController() {
        return createMissionController;
    }

    public void setCreateMissionController(CreateMissionController createMissionController) {
        this.createMissionController = createMissionController;
    }
}
