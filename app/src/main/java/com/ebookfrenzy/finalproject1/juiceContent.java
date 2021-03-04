package com.ebookfrenzy.finalproject1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class juiceContent extends AppCompatActivity {

    private TextView name;
    private ImageView img;
    private TextView category;
    private TextView country;
    private TextView instructions;
    private TextView ingredient;
    private TextView measure;
    private juiceFavDB favDB;
    private ArrayList<juiceItem> juiceItems;
    private MyAdapterFruit adapterFruit;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juice_content);


        //final juiceItem juiceItem = juiceItems.get(1);

        //Cursor cursor = favDB.read_all_data(juiceItem.getKey_id());
        //SQLiteDatabase db = favDB.getReadableDatabase();
        /*
        adapterFruit.onBindViewHolder(@NonNull adapterFruit.MyViewHolder holder, int position){
            final juiceItem juiceItem = juiceItems.get(position);
        }
*/
        name = (TextView) findViewById(R.id.juice_content_name);
        img = (ImageView) findViewById(R.id.juice_content_image);
        category = (TextView) findViewById(R.id.juice_content_category);
        country = (TextView) findViewById(R.id.juice_content_country);
        instructions = (TextView) findViewById(R.id.juice_content_instructions);
        ingredient = (TextView) findViewById(R.id.juice_content_ingredient);
        measure = (TextView) findViewById(R.id.juice_content_measure);

        // Receive Data
        Intent intent = getIntent();
        String title = intent.getExtras().getString("name");
        int image = intent.getExtras().getInt("image");
        String j_category = intent.getExtras().getString("category");
        String j_country = intent.getExtras().getString("country");
        String j_instructions = intent.getExtras().getString("instructions");
        String j_ingredient = intent.getExtras().getString("ingredient");
        String j_measure = intent.getExtras().getString("measure");


        // Setting values
        name.setText(title);
        img.setImageResource(image);
        category.setText(j_category);
        country.setText(j_country);
        instructions.setText(j_instructions);
        ingredient.setText(j_ingredient);
        measure.setText(j_measure);


    }

}