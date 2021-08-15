package com.example.ilkyardim.Views;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ilkyardim.Model.Aid;
import com.example.ilkyardim.R;

public class DetailActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView,description;
    Resources res;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        Aid aid = (Aid) intent.getSerializableExtra("Object");
        int position = intent.getIntExtra("Position",0);

        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);
        description = findViewById(R.id.description);

        textView.setText(aid.getAidName());
        imageView.setImageResource(aid.getImageInt());
        String[] first_aid = getResources().getStringArray(R.array.first_aid);
        String bodyData = first_aid[position];


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            description.setText(Html.fromHtml(bodyData,Html.FROM_HTML_MODE_LEGACY));
        } else {
            description.setText(Html.fromHtml(bodyData));
        }
    }
}