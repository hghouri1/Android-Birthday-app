package com.example.hassa.birthday;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    private TextView name;
    private TextView password;
    private TextView info;
    private Button login;
    private Button forgotPass;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday_page);

        name = (TextView)findViewById(R.id.email);
        password = (TextView)findViewById(R.id.pass);
        info = (TextView)findViewById(R.id.attempts);
        login = (Button)findViewById(R.id.loginBtn);
        forgotPass = (Button)findViewById(R.id.passBtn);
        info.setText("No of remaining attempts:");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(name.getText().toString(), password.getText().toString());
            }
        });

    }

    private void validate(String Uname, String Upass){
        if((Uname.equals("Admin")) && (Upass.equals("1234"))){
            Intent intent = new Intent(Login.this , BirthdayPage.class);
            startActivity(intent);
        }else {
            counter--;
            info.setText("No of remaining attempts: " + String.valueOf(counter));
            if(counter == 0){
                login.setEnabled(false);
            }
        }
    }
}
