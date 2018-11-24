package learnityourself.dhbw.learnityourself;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


import org.json.JSONException;
import org.json.JSONObject;

import learnityourself.dhbw.learnityourself.utility.Helper;


public class ViewMissionInformationActivity extends AppCompatActivity {


    private TextView description_textview, finishdate_textview;
    private JSONObject jsonObject;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_mission_information);

        description_textview = findViewById(R.id.description_textview);
        finishdate_textview = findViewById(R.id.date_textView);

        jsonObject = Helper.getInstance().getJsonObject();

        try {
            setDescription_textview();
            setFinishdate_textview();
        } catch (JSONException e){
            System.err.println("JSONException: " + e.getMessage());
        }
    }

    public void setDescription_textview() throws JSONException {

        this.description_textview.setText(jsonObject.getString("description"));
    }

    public void setFinishdate_textview() throws JSONException {

        this.finishdate_textview.setText(jsonObject.getString("deadline"));
    }

}
