package learnityourself.dhbw.learnityourself.utility;

import org.json.JSONObject;

import java.io.InputStream;

import learnityourself.dhbw.learnityourself.model.Mission;

public class Helper {


    private static Helper helper = new Helper();
    private InputStream inputStream;
    private JSONObject jsonObject;
    private Mission mission;

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
}
