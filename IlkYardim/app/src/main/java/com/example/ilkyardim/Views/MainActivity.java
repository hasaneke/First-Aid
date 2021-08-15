package com.example.ilkyardim.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.ilkyardim.Adapters.CustomAdapter;
import com.example.ilkyardim.Model.Aid;
import com.example.ilkyardim.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   ArrayList<Aid> aidArrayList;
   RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aidArrayList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);

        Aid heart_attack = new Aid("Kalp Krizi",R.drawable.heartattack);
        Aid chocking = new Aid("Boğulma",R.drawable.chocking);
        Aid passout = new Aid("Bayılma",R.drawable.passout);
        Aid brokenbone = new Aid("Kırık-Çıkık",R.drawable.brokenbone);
        //Aid throwup = new Aid("Yoğun Kusma",R.drawable.throwingup);
        Aid injured = new Aid("Kesik",R.drawable.injured);
        Aid stabbed = new Aid("Saplanma",R.drawable.stabbed);
        Aid epilepsi = new Aid("Epilepsi Krizi",R.drawable.epilepsi);

        aidArrayList.add(heart_attack);
        aidArrayList.add(chocking);
        aidArrayList.add(passout);
        aidArrayList.add(brokenbone);
        //aidArrayList.add(throwup);
        aidArrayList.add(injured);
        aidArrayList.add(stabbed);
        aidArrayList.add(epilepsi);

        CustomAdapter customAdapter = new CustomAdapter(MainActivity.this,aidArrayList);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
                intent.putExtra("Object",aidArrayList.get(i));
                intent.putExtra("Position",i);
                startActivity(intent);
            }
        });*/
    }

}