package learnityourself.dhbw.learnityourself;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText username_field = findViewById(R.id.username_field);
        final EditText password_field = findViewById(R.id.password_field);

        Button loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener(){
           public void onClick(View v){
               Toast.makeText(MainActivity.this, password_field.getText(), Toast.LENGTH_SHORT).show();
           }
        });
    }



}
