package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
Button newuse,dashbord;
EditText username,password;
DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_login);
  dashbord = findViewById(R.id.letsgo);
      newuse = findViewById(R.id.newsignup);
       DB = new DBHelper(this);
        newuse.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent i = new Intent(Login.this,newuser.class);
            startActivity(i);
        }
    });
        dashbord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if(user.equals("")||pass.equals("")){
                    Toast.makeText(Login.this, "ENTER THE DETAILS", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean checksuer = DB.checkuser(user);
                    if(checksuer==true) {
                        Toast.makeText(Login.this, "SIGN IS DONE", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(Login.this,lastlog.class);
                        startActivity(i);

                    }
                    else {
                        Toast.makeText(Login.this, "INVALID THINGS", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}