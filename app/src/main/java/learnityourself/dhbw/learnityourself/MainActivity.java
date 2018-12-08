package learnityourself.dhbw.learnityourself;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.concurrent.ExecutionException;

import learnityourself.dhbw.learnityourself.controller.MainController;
import learnityourself.dhbw.learnityourself.model.User;
import learnityourself.dhbw.learnityourself.utility.HTTPRequestHandler;
import learnityourself.dhbw.learnityourself.utility.SSLHandler;

public class MainActivity extends AppCompatActivity {

    private TextView user_label;
    private Button missions_button, logout_button;
    private MainController controller;
    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = new MainController( (User) getIntent().getSerializableExtra("user"),this);
        if(controller.getUser()!=null){
            init();
        }


    }

    private void init() {

        user_label = findViewById(R.id.mainUserLabel);
        missions_button = findViewById(R.id.missions_button);
        user_label.setText(controller.getUser().getUsername());
        missions_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.viewMissions();
            }
        });

        logout_button = findViewById(R.id.logout_button);
        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.logout();
            }
        });
    }

    @Override
    public void onBackPressed() {
        controller.keyBackHandler();
    }
}
