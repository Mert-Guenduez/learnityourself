package learnityourself.dhbw.learnityourself;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.androidplot.util.PixelUtils;
import com.androidplot.xy.BarFormatter;
import com.androidplot.xy.BarRenderer;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYGraphWidget;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import learnityourself.dhbw.learnityourself.controller.MainController;
import learnityourself.dhbw.learnityourself.model.User;

public class MainActivity extends AppCompatActivity {

    private XYPlot plot;

    private TextView user_label,  points_label;
    private Button missions_button, logout_button, rewards_button, achievements_button;

    private MainController controller;
    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = new MainController( (User) getIntent().getSerializableExtra("user"),this);
        if(controller.getUser()!=null){
            createChart();
            init();
        }


     }

    private void createChart() {
        plot = (XYPlot) findViewById(R.id.plot2);
        Map<String, Integer> completedTaskFromUser = controller.fetchCompletedTaskDates();

        List<String> dateList = new ArrayList<>();
        dateList.addAll(completedTaskFromUser.keySet());
        final String[] dates = dateList.toArray(new String[dateList.size()]);

        Number[] amountOfCompletedTasks = new Number[dates.length];

        for (int i = 0; i < dateList.size(); i++) {
            amountOfCompletedTasks[i] = completedTaskFromUser.get(dates[i]);
        }

        XYSeries series1 = new SimpleXYSeries(
                Arrays.asList(amountOfCompletedTasks), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "");
        BarFormatter bf = new BarFormatter(Color.RED, Color.WHITE);
        plot.addSeries(series1, bf);
        BarRenderer renderer = plot.getRenderer(BarRenderer.class);
        renderer.setBarGroupWidth(BarRenderer.BarGroupWidthMode.FIXED_WIDTH, PixelUtils.dpToPix(10));

        plot.getGraph().getLineLabelStyle(XYGraphWidget.Edge.BOTTOM).setFormat(new Format() {
            @Override
            public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
                int i = Math.round(((Number) obj).intValue());
                return toAppendTo.append(dates[i]);
            }
            @Override
            public Object parseObject(String source, ParsePosition pos) {
                return null;
            }
        });
    }

    private void init() {

         user_label = findViewById(R.id.mainUserLabel);
         user_label.setText(controller.getUser().getUsername());

         controller.fetchUserPoints();
         points_label = findViewById(R.id.pointsLabel);
         points_label.setText(controller.getUser().getPoints() + " Points");

        rewards_button = findViewById(R.id.rewards_button);
        achievements_button = findViewById(R.id.achievements_button);
        logout_button = findViewById(R.id.logout_button);
        missions_button = findViewById(R.id.missions_button);
        
        achievements_button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 controller.viewAchiements();
             }
         });

        rewards_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.viewRewards();
            }
        });
        
        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.logout();
            }
        });
        missions_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.viewMissions();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.options){
            controller.openOptions();
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        controller.keyBackHandler();
    }
}
