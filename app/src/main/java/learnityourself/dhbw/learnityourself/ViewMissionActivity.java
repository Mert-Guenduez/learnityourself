package learnityourself.dhbw.learnityourself;

import android.content.Context;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.androidplot.util.PixelUtils;
import com.androidplot.xy.BarFormatter;
import com.androidplot.xy.BarRenderer;
import com.androidplot.xy.CatmullRomInterpolator;
import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYGraphWidget;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import learnityourself.dhbw.learnityourself.controller.ViewMissionController;
import learnityourself.dhbw.learnityourself.model.Mission;
import learnityourself.dhbw.learnityourself.model.TaskAdapter;
import learnityourself.dhbw.learnityourself.model.User;

public class ViewMissionActivity extends AppCompatActivity {

    private XYPlot plot;

    private ActionBar actionBar;
    private ListView taskListView;
    private ViewMissionController controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_mission);
        controller=new ViewMissionController((User)getIntent().getSerializableExtra("user"),this);
        controller.setMission((Mission) getIntent().getSerializableExtra("mission"));
        controller.loadTasks();
        generateActionBar();
        createChart();
        init();

    }

    private void createChart() {
        plot = (XYPlot) findViewById(R.id.plot);
        Map<String, Integer> userToTasks = controller.getUserTasksMap();
        List<String> userNameList = new ArrayList<>();
        userNameList.addAll(userToTasks.keySet());
        final String[] userNames = userNameList.toArray(new String[userNameList.size()]);
        Number[] amountOfTasks = new Number[userNames.length];
        for(int i=0; i<userNameList.size(); i++){
            amountOfTasks[i] = userToTasks.get(userNames[i]);
        }

        XYSeries series1 = new SimpleXYSeries(
                Arrays.asList(amountOfTasks), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "");
        BarFormatter bf = new BarFormatter(Color.RED, Color.WHITE);
        plot.addSeries(series1, bf);
        BarRenderer renderer = plot.getRenderer(BarRenderer.class);
        renderer.setBarGroupWidth(BarRenderer.BarGroupWidthMode.FIXED_WIDTH, PixelUtils.dpToPix(10));
        plot.getGraph().getLineLabelStyle(XYGraphWidget.Edge.BOTTOM).setFormat(new Format() {
            @Override
            public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
                int i = Math.round(((Number) obj).floatValue());
                return toAppendTo.append(userNames[i]);
            }
            @Override
            public Object parseObject(String source, ParsePosition pos) {
                return null;
            }
        });
    }


    public void generateActionBar(){

        actionBar = getSupportActionBar();

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.mission_action_bar, null);

        view.findViewById(R.id.title).setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        controller.titleClickHandler();
                    }
                });

        actionBar.setCustomView(view);
        actionBar.setDisplayShowCustomEnabled(true);
    }

    void init() {

        actionBarSetTitle();
        taskListView = (ListView) findViewById(R.id.task_list);
        taskListView.setAdapter(new TaskAdapter(this, controller.getTasks()));

        taskListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> arg0, View view,int position, long arg3) {
                        // TODO Auto-generated method stub
                        controller.clickTask(position);
                    }
                }
        );

    }

    public void actionBarSetTitle(){
        TextView textView = (TextView)findViewById(R.id.title);
        textView.setText(controller.getMission().getMissionname());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.add){
            controller.createTask();
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        controller.keyBackHandler();
    }

}
