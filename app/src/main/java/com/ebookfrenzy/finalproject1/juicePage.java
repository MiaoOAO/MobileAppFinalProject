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
        juiceItems.add(new juiceItem(R.drawable.apple, "Apple Juice", "0", "0","Health","Malaysia","Step 1\n\n" +
                "Start by washing and then coring the apple to remove seeds. Cut the apples into slices. There is no need to peel the apples.\n\n" +
                "Step 2\n\n" +
                "Add the apples to the pot and add enough water to just cover them. Too much water and you’ll have pretty diluted juice. This juice may come out a bit strong, but it’s a lot easier to dilute the juice with extra water rather than trying to make the flavor stronger.\n\n" +
                "Step 3\n\n" +
                "Slowly boil the apples for about 20-25 minutes or until the apples are quite soft. Place a coffee filter or piece of cheesecloth in your fine mesh strainer and place over a bowl.\n\n"
                ,"Apples\n" +
                "Cinnamon (optional)\n" +
                "Sugar (optional)","5 pieces \n30g \n50g"));
        juiceItems.add(new juiceItem(R.drawable.watermelon, "Watermelon Juice", "1", "0","Refreshing","Japan","Step 1\n\nBlend the watermelon, ice cubes, soda water, yogurt, lime juice, honey, white pepper, and salt in a blender until well combined. Pour into a glass and serve immediately.","Cubed watermelon\nIce cubes\nSoda water\nPlain yogurt\nFresh lime\nHoney\nWhite pepper\nSalt","1/2 cups\n1 generous cup\n1 cup\n1/2 cup\n1/4 cup\n2 Tbsp\n1/8 tsp\npinch"));
        juiceItems.add(new juiceItem(R.drawable.carrot, "carrot Smoothie", "2", "0","Health","Taiwan","Step 1\n\nWash carrots and peel banana.\n\nStep 2\n\nAdd all ingredients to blender and blend until smooth.\n\nStep 3\n\nAdd more milk for a thinner consistency and less for a thicker juice.","Carrots\nBanana\nMilk\nCinnamon","6\n1\n1 half cup\n1 tsp"));

        juiceItems.add(new juiceItem(R.drawable.kale, "Kale Juice", "3", "0","Health","Taiwan","Step 1\n\nUsing a small sharp knife, peel the lemon, removing all of the bitter white pith. In an electric juicer, juice the kale with the lemon, cucumbers, ginger, cilantro and, if using, the jalapeño. Season the juice with a pinch of salt and serve over ice. ","Small lemon\nCurly kale\nCucumbers\nFresh ginger\nCilantro leaves\nJalapefio piece\nSalt\nIce","1\none medium bunch\n3\none 1-inch\n3/4 cup\n1/4-inch\nkosher\nfor serving"));
        juiceItems.add(new juiceItem(R.drawable.strawberry, "Strawberry Smoothie", "4", "0","Improve Digestion","Malaysia","Step 1 \n\n "+"Start by washing strawberries, then cut the into slices and frozen the strawberries to 10 hur. \n\n"+"Step 2 \n\nBlend all ingredients until smooth.","Frozen strawberries \nBanana\nLemon juice\nWater","1 cup\n1\n1 teaspoon\n3/4 cup"));
        juiceItems.add(new juiceItem(R.drawable.cantaloupe, "Cantaloupe Juice", "5", "0","Refreshing","Taiwan","Step 1\n\nOn a rimmed baking sheet lined with parchment paper, spread the cantaloupe and pineapple in an even layer and freeze until just frozen, about 30 minutes.\n\nStep 2\n\nIn an electric juicer, juice the frozen fruit with the ginger and lime. Serve immediately.","Chopped cantaloupe\nChopped pineapple\nFresh ginger\nLime","2 cups\n2 cups\n2-inch piece\n1/2"));
        juiceItems.add(new juiceItem(R.drawable.beet, "Purple Haze", "6", "0","Health","Taiwan","Step 1\n\nUsing an electric juicer, juice the beet, apple, carrot, orange and ginger. Stir in the salt and chill for at least 15 minutes before serving.","Beet(peeled)\nApple\nCarrot\nOrange\nFresh ginger\nSea salt","1 medium\n1 large\n1 medium\n1 medium\none 4-nich piece\n1/8 teaspoon"));
        juiceItems.add(new juiceItem(R.drawable.fennel, "Electro Shot", "7", "0","Immunity Booster","USA","Step 1\n\nPrepare one large fennel bulb to trimmed, cored and quartered,next one medium Granny Smith apple quartered\n\nStep 2\n\nFill a large glass measuring cup with ice and place it underneath the spout of an electric juicer. Juice the fennel and apple over the ice. Strain the juice into four 2-ounce glasses and serve immediately.","Ice\nFennel bulb\nGranny Smith apple","somw\n1 large\n1 medium"));
        juiceItems.add(new juiceItem(R.drawable.citrus, "Citrus-Prickly Pear", "8", "0","Health","USA","Step 1\n\nPeel 1 grapefruit, 1 blood or navel orange, 1 lemon, and 1 lime; coarsely chop flesh. Pass citrus, 2 prickly pears, cut into pieces, 1 bunch mint, 1 Fresno chile (if desired), a chopped 2\" piece unpeeled ginger, and 1/2 cup chopped unpeeled turmeric (from about 2 ounces whole) through a juicer; strain, if desired, into a pint jar or large glass. Chase with a full glass of water.","Grapefruith\nOrange\nLemon\nLime\nPears\nMint\nGinger\nTurmeric","1\n1 blood\n1\n1\n2 prickly\n1 bunch\n1-2 piece\n1/2 cup chopped"));
        juiceItems.add(new juiceItem(R.drawable.sun, "Uprising Sun Refresher", "9", "0","Antioxidant","Japan","Step 1\n\nPut the mint and sugar in a tall glass and mash them together to muddle. Stir in the pineapple juice. Add enough ice to fill the glass. Add the pomegranate juice and do not stir. Serve.","Mint leaves\nSugar\nPineapple juice\nIce\nPomegranate juice","3 large\n1 teaspoon\n1 cup\nsome\n1 tablespoon"));
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