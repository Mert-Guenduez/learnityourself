package learnityourself.dhbw.learnityourself;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import learnityourself.dhbw.learnityourself.controller.LoginController;

public class LoginActivity extends AppCompatActivity {

    private EditText username_field;
    private EditText password_field;
    private Button registerButton;
    private Button loginButton;
    private LoginController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        controller= new LoginController(this);
        username_field = findViewById(R.id.username_field);
        password_field = findViewById(R.id.password_field);

        registerButton = findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.register();
            }
        });

        loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                controller.login(username_field, password_field);
            }
        });
    }




}

