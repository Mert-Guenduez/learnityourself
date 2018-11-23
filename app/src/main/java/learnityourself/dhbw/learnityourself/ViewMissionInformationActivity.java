package learnityourself.dhbw.learnityourself;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;

import learnityourself.dhbw.learnityourself.model.Mission;
import learnityourself.dhbw.learnityourself.model.Task;
import learnityourself.dhbw.learnityourself.utility.HTTPRequestHandler;
import learnityourself.dhbw.learnityourself.utility.Helper;


public class ViewMissionInformationActivity extends AppCompatActivity {

    private Mission mission;
    private TextView description_textview, finishdate_textview;
    private InputStream in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_mission_information);

        description_textview = findViewById(R.id.description_textview);
        finishdate_textview = findViewById(R.id.date_textView);

        in = Helper.getInstance().getInputStreamer();

        setDescription_textview();
    }

    public void setDescription_textview() {

        try {
            JSONObject jsonObject = new JSONObject(in.toString());
            System.out.println("JSONOBJECT: " + jsonObject.toString());

            //String tag = jsonObject.getString("deadline");
            //String content = new Gson().fromJson(tag, String.class);
            System.out.println("JSONSTRING2 :"+jsonObject.getString("deadline"));
            this.description_textview.setText(jsonObject.getString("deadline"));

        } catch (JSONException e) {
            System.err.println("JSONEXCEPTION: " + e.getMessage());
        }
    }
}
