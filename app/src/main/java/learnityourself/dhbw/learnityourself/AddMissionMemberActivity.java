package learnityourself.dhbw.learnityourself;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

public class AddMissionMemberActivity extends AppCompatActivity {

    private TextView username_field;
    private SearchView searchView;
    private ListView searchUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_missionmember);

        username_field = findViewById(R.id.search_username_label);
        searchView = findViewById(R.id.user_searchView);
        searchUsername = findViewById(R.id.search_user_listview);

    }


}
