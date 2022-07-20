package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.miniproject.adapter.TopPlacesAdapter;
import com.example.miniproject.model.TopPlacesData;

import java.util.ArrayList;
import java.util.List;

public class Seeall extends AppCompatActivity {
    TopPlacesAdapter topPlacesAdapter;
    RecyclerView topPlacesRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seeall);
        List<TopPlacesData> topPlacesDataList = new ArrayList<>();
        topPlacesDataList.add(new TopPlacesData("Old Goa","Goa","25000",R.drawable.t1));
        topPlacesDataList.add(new TopPlacesData("UmaidBhavanPalace","Jodhpur","30000",R.drawable.t2));
        topPlacesDataList.add(new TopPlacesData(" Jama Masjid","Delhi","4000",R.drawable.t3));
        topPlacesDataList.add(new TopPlacesData("Akshardham Temple","Delhi","12000",R.drawable.t4));
        topPlacesDataList.add(new TopPlacesData("Venice","Italy","1Lakh",R.drawable.w1));
        topPlacesDataList.add(new TopPlacesData("Banff National","Canada","1.5Lakh",R.drawable.w2));
        topPlacesDataList.add(new TopPlacesData("Marrakesh","Morocco","7.4lakh",R.drawable.wq3));
        topPlacesDataList.add(new TopPlacesData("Machu"," Picchu","3.2Lakh",R.drawable.w4));
        topPlacesDataList.add(new TopPlacesData("Turkey","Pamukkale","6Lakh",R.drawable.w5));
        topPlacesDataList.add(new TopPlacesData("Japan","Japan","12Lakh",R.drawable.w6));
        topPlacesDataList.add(new TopPlacesData("Pitons","Lucia","23Lakh",R.drawable.w6));

        setTopPlacesRecycler(topPlacesDataList);

    }
    private  void setTopPlacesRecycler(List<TopPlacesData> topPlacesDataList)
    {

        topPlacesRecycler = findViewById(R.id.top_places_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        topPlacesRecycler.setLayoutManager(layoutManager);
        topPlacesAdapter = new TopPlacesAdapter(this, topPlacesDataList);
        topPlacesRecycler.setAdapter(topPlacesAdapter);

    }
}