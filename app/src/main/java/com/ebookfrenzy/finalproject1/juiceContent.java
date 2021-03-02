package com.ebookfrenzy.finalproject1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class juiceContent extends AppCompatActivity {

    private TextView name;
    private ImageView img;
    private TextView category;
    private TextView country;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juice_content);

        name = (TextView) findViewById(R.id.juice_content_name);
        img = (ImageView) findViewById(R.id.juice_content_image);
        category = (TextView) findViewById(R.id.juice_content_category);
        country = (TextView) findViewById(R.id.juice_content_country);

        // Receive Data
        Intent intent = getIntent();
        String title = intent.getExtras().getString("name");
        int image = intent.getExtras().getInt("image");
        String j_category = intent.getExtras().getString("category");
        String j_country = intent.getExtras().getString("country");


        // Setting values
        name.setText(title);
        img.setImageResource(image);
        category.setText(j_category);
        country.setText(j_country);

    }

}