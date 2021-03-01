package com.ebookfrenzy.finalproject1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class juiceFavContent extends AppCompatActivity {

    private TextView name;
    private ImageView img;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juice_fav_content);

        name = (TextView) findViewById(R.id.juice_content_fav_name);
        img = (ImageView) findViewById(R.id.juice_content_fav_image);

        // Receive Data
        Intent intent = getIntent();
        String title = intent.getExtras().getString("name");
        int image = intent.getExtras().getInt("image");

        // Setting values
        name.setText(title);
        img.setImageResource(image);

    }
}