package learnityourself.dhbw.learnityourself.utility;

import java.io.InputStream;

public class Helper {

    private static Helper helper = new Helper();
    private InputStream inputStream;

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
}
