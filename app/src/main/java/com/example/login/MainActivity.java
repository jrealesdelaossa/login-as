package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userName;
    EditText userPassword;
    TextView linkRegister;
    Button btnSingIn;

    // user and password for login
    String user = "admin";
    String password = "admin";

    @SuppressLint({"SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (EditText) findViewById(R.id.userName);
        userPassword = (EditText) findViewById(R.id.userPassword);
        btnSingIn = (Button) findViewById(R.id.btnSignIn);
        linkRegister = (TextView) findViewById(R.id.textRegister);

        // userName.setText("User name");

        btnSingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String userInput = userName.getText().toString();
               String passInput = userPassword.getText().toString();

               if (userInput.equals(user)) {
                   if (passInput.equals(password)) {
                       Toast.makeText(MainActivity.this, "Welcome " + user, Toast.LENGTH_LONG).show();
                   } else {
                       Toast.makeText(MainActivity.this, "Password incorrect", Toast.LENGTH_LONG).show();
                   }
               } else {
                   Toast.makeText(MainActivity.this, "User incorrect", Toast.LENGTH_LONG).show();
               }
            }
        });

        linkRegister.setOnClickListener(v ->
                startActivities(new Intent[]{new Intent(MainActivity.this, viewRegister.class)})
        );
    }
}