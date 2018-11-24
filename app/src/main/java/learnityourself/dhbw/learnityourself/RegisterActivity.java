package learnityourself.dhbw.learnityourself;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.InputStream;
import java.util.concurrent.ExecutionException;

import learnityourself.dhbw.learnityourself.utility.HTTPRequestHandler;

public class RegisterActivity extends AppCompatActivity {

    private EditText username_field;
    private EditText password_field;
    private EditText passwordRepeat_field;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username_field = findViewById(R.id.username_field);
        password_field = findViewById(R.id.password_field);
        passwordRepeat_field = findViewById(R.id.passwordRepeat_field);
        registerButton = findViewById(R.id.register_button);

        registerButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        }));
    }

    public void register(){
        HTTPRequestHandler handler = new HTTPRequestHandler();
        InputStream in = null;

        if (validate()){
            try {
                in = handler.execute("https://91.205.172.109/register.php","username",
                        username_field.getText().toString(),
                        "password", password_field.getText().toString()).get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String inputString=HTTPRequestHandler.getStringFromInputStream(in);

            if (inputString.equals("{\"response\":\"User already exists\"}")){
                username_field.setError("User already exists. Please enter another Username.");
            } else {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        }

    }

    public boolean validate(){
        boolean valid = true;

        if (username_field.getText().toString().isEmpty()){
            username_field.setError("Please enter valid Username.");
            valid = false;
        }
        if (password_field.getText().toString().isEmpty() ||
                !password_field.getText().toString().equals(passwordRepeat_field.getText().toString())){
            password_field.setError("Please repeat your Password.");
            valid = false;
        }

        return valid;
    }

}
