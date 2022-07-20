package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    ImageView img,insta;
    TextView header,description,fulldescr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        img = findViewById(R.id.image_details);
        header = findViewById(R.id.txt1);
        description = findViewById(R.id.txt2);
        fulldescr = findViewById(R.id.descriptionpalce);
        insta = findViewById(R.id.insta);
        img.setImageResource(getIntent().getIntExtra("imagename",0));
        header.setText(getIntent().getStringExtra("placename"));
        description.setText(getIntent().getStringExtra("description"));
        fulldescr.setText(getIntent().getStringExtra("fulldescription"));
        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}