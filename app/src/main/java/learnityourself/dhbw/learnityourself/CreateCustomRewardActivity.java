package learnityourself.dhbw.learnityourself;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.SeekBar;
import android.widget.TextView;

import learnityourself.dhbw.learnityourself.controller.CreateCustomRewardController;
import learnityourself.dhbw.learnityourself.model.Reward;
import learnityourself.dhbw.learnityourself.model.User;

public class CreateCustomRewardActivity extends AppCompatActivity {

    private EditText rewardName;
    private TextView pointsProgress, pointsError;
    private SeekBar points;
    private Reward[] rewards;
    private int pointsValue, rewardPosition;
    private CreateCustomRewardController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_custom_reward);

        rewards = (Reward[])getIntent().getSerializableExtra("rewardNames");
        rewardPosition = (int)getIntent().getSerializableExtra("reward");

        controller = new CreateCustomRewardController((User)getIntent().getSerializableExtra("user"),this, rewardPosition, rewards);

        init();
    }

    void init () {
        pointsValue = 0;

        rewardName = findViewById(R.id.rewardName_editText);
        pointsProgress = findViewById(R.id.pointsProgress_textview);
        pointsError = findViewById(R.id.pointsError_textView);
        points = findViewById(R.id.points_editText);

        if (rewardPosition > -1) {
            rewardName.setText(rewards[rewardPosition].getTitle());
            points.setProgress(rewards[rewardPosition].getCost());
        }

        points.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        pointsValue = progress;

                        int val = (progress * (seekBar.getWidth() - 2 * seekBar.getThumbOffset())) / seekBar.getMax();
                        pointsProgress.setText("" + progress);
                        pointsProgress.setX(seekBar.getX() + val + seekBar.getThumbOffset() / 2);
                        // TODO set value on TextItem
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        // TODO set value on TextItem

                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_check, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();

        if (id == R.id.check){
            item.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    if (validEntry()){
                        controller.setRewardName(rewardName.getText().toString());
                        controller.setPoints(pointsValue);
                        //controller.setCost(Integer.parseInt(points.getText().toString()));
                        controller.checkClickHandler();

                    }
                    return false;
                }
            });
        }
        return true;
    }

    public boolean validEntry () {
        String rewardNameValue = rewardName.getText().toString();

        if (rewardNameValue.isEmpty()) {
            rewardName.setError("Insert Rewardname.");
            return false;
        }
        if (pointsValue < 1) {
            pointsError.requestFocus();
            pointsError.setError("Insert Points.");
            return false;
        }

        for (Reward reward : rewards) {
            if (reward.equals(rewardNameValue)) {
                rewardName.setError("This Reward already exists.");
            }
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        controller.keyBackHandler();
    }
}
