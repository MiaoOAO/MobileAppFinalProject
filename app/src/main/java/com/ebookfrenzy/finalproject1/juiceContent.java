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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juice_content);

        name = (TextView) findViewById(R.id.juice_content_name);
        img = (ImageView) findViewById(R.id.juice_content_image);

        // Receive Data
        Intent intent = getIntent();
        String title = intent.getExtras().getString("name");
        int image = intent.getExtras().getInt("image");

        // Setting values
        name.setText(title);
        img.setImageResource(image);

    }

}