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


public class ViewMissionInformationActivity extends AuthorizedActivity {

    private Mission mission;
    private TextView description_textview, finishdate_textview;
    private InputStream in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_mission_information);

        description_textview = findViewById(R.id.description_textview);
        finishdate_textview = findViewById(R.id.date_textView);

        if (checkAuthorized()){
            init();
        }
    }

    @Override
    void init(){


    }

    public void setDescription_textview() {

        try {
            JsonElement element = new JsonParser().parse(new InputStreamReader(in));
            JSONObject jsonObject = new JSONObject(element.getAsJsonObject().toString());

            String tag = jsonObject.getString("deadline");
            String content = new Gson().fromJson(tag, String.class);
            this.description_textview.setText(content);

        } catch (JSONException e){
            System.err.println("ERROR parsing InputStream into JSONObject: " + e.getMessage());
        }
    }
}
