package com.ebookfrenzy.finalproject1;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class coffeePage extends AppCompatActivity {

    RecyclerView recyclerView;
    //private ArrayList<juiceItem> juiceItems;
    private ArrayList<coffeeItem> coffeeItems;

    //int images[] = {R.drawable.apple, R.drawable.watermelon, R.drawable.carrot, R.drawable.mango};

    private static final String TAG = "coffeePage";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_page);

/*
        juiceItems = new ArrayList<>();
        juiceItems.add(new juiceItem(R.drawable.apple, "apple", "0", "0"));
        juiceItems.add(new juiceItem(R.drawable.watermelon, "watermelon", "1", "0"));
        juiceItems.add(new juiceItem(R.drawable.carrot, "carrot", "2", "0"));
*/
        coffeeItems = new ArrayList<>();
        coffeeItems.add(new coffeeItem(R.drawable.cappuccino, "cappuccino", "3", "1", "Coffee", "Malaysia"));
        coffeeItems.add(new coffeeItem(R.drawable.latte, "latte", "4", "1", "Coffee", "Japan"));
        coffeeItems.add(new coffeeItem(R.drawable.cappuccino, "cappuccino", "5", "1", "Health", "Taiwan"));

/*
        if(Tab1Fragment.click1 == true) {
            recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
            MyAdapterFruit adapterFruit = new MyAdapterFruit(this, juiceItems);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapterFruit);
        }
*/
        if(Tab1Fragment.click2 == true) {
            recyclerView = (RecyclerView) findViewById(R.id.recyclerView2);
            MyAdapterCoffee adapterCoffee = new MyAdapterCoffee(this, coffeeItems);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapterCoffee);
        }



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

        for(int i=0; i<coffeeItems.size(); i++)
        {
            //Log.d(TAG, "onCreate: title: " + juiceItems.get(i).getTitle() + "key_id: " + juiceItems.get(i).getKey_id() + juiceItems.get(i).getImageResourse());
            Log.d(TAG, "onCreate: title: " + coffeeItems.get(i).getTitle() + "key_id: " + coffeeItems.get(i).getKey_id() + coffeeItems.get(i).getImageResourse());
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