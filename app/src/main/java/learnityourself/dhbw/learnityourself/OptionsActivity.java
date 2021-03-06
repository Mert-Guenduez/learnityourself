package learnityourself.dhbw.learnityourself;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import learnityourself.dhbw.learnityourself.controller.OptionsController;
import learnityourself.dhbw.learnityourself.model.User;

public class OptionsActivity extends AppCompatActivity {

    private EditText oldPassword_field;
    private EditText newPassword_field;
    private EditText newPasswordRepeat_field;
    private Button changePWButton;
    private OptionsController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        controller=new OptionsController((User)getIntent().getSerializableExtra("user"),this);
        oldPassword_field = findViewById(R.id.old_pw_field);
        newPassword_field = findViewById(R.id.new_pw_field);
        newPasswordRepeat_field = findViewById(R.id.new_pw_repeat_field);
        changePWButton = findViewById(R.id.change_pw_button);

        changePWButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    if(!controller.setNewPassword(oldPassword_field.getText().toString(), newPassword_field.getText().toString())){
                        oldPassword_field.setError("Wrong Password");
                    }
                }

            }
        }));
    }

    public boolean validate(){
        boolean valid = true;

        if (newPassword_field.getText().toString().isEmpty() ||
                !newPassword_field.getText().toString().equals(newPasswordRepeat_field.getText().toString())){
            newPassword_field.setError("Invalid Inputs");
            valid = false;
        }

        return valid;
    }

}
