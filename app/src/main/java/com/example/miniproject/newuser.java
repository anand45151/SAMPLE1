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

public class newuser extends AppCompatActivity {
Button btn;
EditText fname,uname,phone,email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen

        setContentView(R.layout.activity_newuser);
        fname = findViewById(R.id.full_name);
        uname = findViewById(R.id.user_name);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);
    btn = findViewById(R.id.registerbtn);
    DBHelper DB  = new DBHelper(this);
    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String user = uname.getText().toString();
            String pas = password.getText().toString();
            if(user.equals("")||pas.equals("")){
                Toast.makeText(getApplicationContext(),"DEFINE THE FEILD ",Toast.LENGTH_SHORT).show();;
            }
            else {
                Boolean insert = DB.insertdata(user,pas);
                if(insert==true){
                    Toast.makeText(getApplicationContext(),"DATA HASE BEEN DONE ",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(),"ENTEE DATA ",Toast.LENGTH_SHORT).show();
                }
            }
            Intent i = new Intent(newuser.this,nextLog.class);
            startActivity(i);
        }
    });
    }
}