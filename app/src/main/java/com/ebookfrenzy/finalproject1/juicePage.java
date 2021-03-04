package com.ebookfrenzy.finalproject1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class juicePage extends AppCompatActivity{

    RecyclerView recyclerView;
    private ArrayList<juiceItem> juiceItems;
    //private ArrayList<juiceItem> coffeeItems;


    private static String TABLE_NAME = "favoriteTable";
    public static String FAVORITE_STATUS = "fStatus";

    //int images[] = {R.drawable.apple, R.drawable.watermelon, R.drawable.carrot, R.drawable.mango};

    private static final String TAG = "juicePage";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juice_page);

        juiceItems = new ArrayList<>();
        juiceItems.add(new juiceItem(R.drawable.apple, "Apple Juice", "0", "0","Health","Malaysia","1.  " +
                "Start by washing and then coring the apple to remove seeds. Cut the apples into slices. There is no need to peel the apples.\n\n" +
                "2.  " +
                "Add the apples to the pot and add enough water to just cover them. Too much water and you’ll have pretty diluted juice. This juice may come out a bit strong, but it’s a lot easier to dilute the juice with extra water rather than trying to make the flavor stronger.\n\n" +
                "3.  " +
                "Slowly boil the apples for about 20-25 minutes or until the apples are quite soft. Place a coffee filter or piece of cheesecloth in your fine mesh strainer and place over a bowl.\n\n"
                ,"Apples\n" +
                "Cinnamon (optional)\n" +
                "Sugar (optional)","5 pieces \n30g \n50g"));
        juiceItems.add(new juiceItem(R.drawable.watermelon, "watermelon", "1", "0","Health","Japan","","",""));
        juiceItems.add(new juiceItem(R.drawable.carrot, "carrot", "2", "0","Health","Taiwan","","",""));

        juiceItems.add(new juiceItem(R.drawable.carrot, "KALE JUICE", "2", "0","Health","Taiwan","","",""));

        /*
        coffeeItems = new ArrayList<>();
        coffeeItems.add(new juiceItem(R.drawable.cappuccino, "cappuccino", "3", "1"));
        coffeeItems.add(new juiceItem(R.drawable.cappuccino, "cappuccino", "4", "1"));
        coffeeItems.add(new juiceItem(R.drawable.cappuccino, "cappuccino", "5", "1"));
        //coffeeItems.add(new juiceItem(R.drawable.cappuccino, "cappuccino", "6", "1"));
        //coffeeItems.add(new juiceItem(R.drawable.cappuccino, "cappuccino", "6", "1"));
        //coffeeItems.add(new juiceItem(R.drawable.cappuccino, "cappuccino", "6", "1"));
*/



        if(Tab1Fragment.click1 == true) {
            recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

            MyAdapterFruit adapterFruit = new MyAdapterFruit(this, juiceItems);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapterFruit);

        }
/*
        if(Tab1Fragment.click2 == true) {
            recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

            MyAdapterFruit adapterFruit = new MyAdapterFruit(this, coffeeItems);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapterFruit);

        }
*/



/*
        if(Tab1Fragment.click1 == true) {
            juiceItems.add(new juiceItem(R.drawable.apple, "apple", "0", "0"));
            juiceItems.add(new juiceItem(R.drawable.watermelon, "watermelon", "1", "0"));
            juiceItems.add(new juiceItem(R.drawable.carrot, "carrot", "2", "0"));
        }

        if(Tab1Fragment.click2 == true) {
            juiceItems.add(new juiceItem(R.drawable.cappuccino, "cappuccino", "0", "0"));
        }

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        MyAdapterFruit adapterFruit = new MyAdapterFruit(this, juiceItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterFruit);
*/


        for(int i=0; i<juiceItems.size(); i++)
        {
            Log.d(TAG, "onCreate: title: " + juiceItems.get(i).getTitle() + "key_id: " + juiceItems.get(i).getKey_id() + juiceItems.get(i).getImageResourse());
            //Log.d(TAG, "onCreate: title: " + coffeeItems.get(i).getTitle() + "key_id: " + coffeeItems.get(i).getKey_id() + coffeeItems.get(i).getImageResourse());

        }





        /*
        MyAdapterFruit adapterFruit = new MyAdapterFruit(this, juiceItems);
        recyclerView.setAdapter(adapterFruit);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
*/
        //s1 = getResources().getStringArray(R.array.fruit_listName);
        //s2 = getResources().getStringArray(R.array.fruit_listDesc);
/*
        MyAdapterFruit adapterFruit = new MyAdapterFruit(juiceItems, context);
        recyclerView.setAdapter(adapterFruit);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        juiceItems.add(new juiceItem(R.drawable.apple, "apple", "0", "0"));*/
    }


}