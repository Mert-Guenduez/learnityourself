package learnityourself.dhbw.learnityourself;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import learnityourself.dhbw.learnityourself.controller.CreateCustomRewardController;
import learnityourself.dhbw.learnityourself.model.User;

public class CreateCustomRewardActivity extends AppCompatActivity {

    private EditText rewardName, points;
    private CreateCustomRewardController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_custom_reward);

        controller = new CreateCustomRewardController((User)getIntent().getSerializableExtra("user"),this);

        init();
    }

    void init () {
        rewardName = findViewById(R.id.rewardName_editText);
        points = findViewById(R.id.points_editText);
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
                        controller.setPoints(Integer.parseInt(points.getText().toString()));

                        controller.checkClickHandler();
                    }
                    return false;
                }
            });
        }
        return true;
    }

    public boolean validEntry () {
        if (rewardName.getText().toString().isEmpty()) {
            rewardName.setError("Insert Rewardname.");
            return false;
        }
        // TODO check if rewardName already exists
        if (points.getText().toString().isEmpty()) {
            points.setError("Insert Points.");
            return false;
        }
        // TODO check if Input is a number (maybe)

        return true;
    }

    @Override
    public void onBackPressed() {
        controller.keyBackHandler();
    }
}
