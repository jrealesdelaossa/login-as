package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;



public class viewRegister extends AppCompatActivity {

    Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_register);

        btnReturn = (Button) findViewById(R.id.btnReturnToLogin);

        btnReturn.setOnClickListener(v ->
                startActivities(new Intent[]{new Intent(viewRegister.this, MainActivity.class)})
        );
    }

}