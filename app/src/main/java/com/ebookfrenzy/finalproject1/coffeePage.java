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
        coffeeItems.add(new coffeeItem(R.drawable.cappuccino, "Cappuccino", "3", "1", "Refreshing", "Malaysia","Step 1\n\nPlace all ingredients in a blender and blend until fully combined and smooth.\n\n" +
                "Step 2\n\nServe immediately.","Coffee\nGhee\nCinnamon","12 ounces\n2 tablespoons\n1/2 teaspoon"));
        coffeeItems.add(new coffeeItem(R.drawable.latte, "latte", "4", "1", "Coffee", "Japan","Step 1\n\nHeat the milk for 30-45 seconds in your microwave in the cup you intend to drink your coffee from.\n\n" +
                "Step 2\n\nOnce the milk of your choice is heated, take a small whisk and vigoursly whisk back and forth for 15-30 seconds until the milk is frothy.\n\n" +
                "Step 3\n\nPour the coffee directly over the frothed milk or brew over the frothed milk.\n\n" +
                "Step 4\n\nAlternatively, you can heat the milk in a glass measuring cup and then froth. Pour coffee or espresso into a mug and then gently pour the frothed milk over the coffee. Spoon the remaining foam on top of your latte.","Milk\nStrong coffee","1/2 cup\n6 ounces"));
        coffeeItems.add(new coffeeItem(R.drawable.pumpkin, "Pumpkin Latte", "5", "1", "Refreshing", "USA","Step 1\n\nMake your espresso according to the directions on the package.\n\nStep 2\n\nPrepare your sauce by combining pumpkin puree, sugar, water, pumpkin pie spice, vanilla and ginger in a small sauce pan. Simmer over medium heat for 10 minutes.\n\n" +
                "Step 3\n\nFor the milk you can pour ½ cup cold milk into microwavable jar, screw lid on tight and shake shake shake! In about 30 seconds your milk will be frothy and doubled in size. Remove lid and place in microwave for 30 seconds to warm the milk and set the froth. Keep an eye out for over flow while heating." +
                "\n\nStep 4\n\nAdd one tablespoon pumpkin sauce and espresso to your favorite mug. Add frothed milk and gently swirl.Top with whipped topping and a sprinkle of nutmeg.","Pumpkin puree\nCane sugar\nWater\nPumpkin pie spice\nVanilla\nGinger\nMilk\nEspresso ","1 cup\nhalf vup\nhalf cup\n1 teaspoon\n1/4 teaspoon\n1/8 teaspoon\nhalf cup\nhalf cup"));
        coffeeItems.add(new coffeeItem(R.drawable.sweettea, "Sweet Tea", "4", "1", "Southern classic", "China","For the simple syrup:\nStep 1\n\nIn a small saucepan set over medium heat, bring water to a boil. Add sugar, and stir until the sugar has dissolved. Remove from the heat and pour the simple syrup into a heat-resistant, airtight jar to cool completely (and store)." +
                "\n\nFor the tea:\nStep 1\n\nIn a ½ gallon pitcher, pour 8 cups water over 2 family-size, cold brew tea bags. Allow the tea to infuse the water at least 5 minutes and up to 15 minutes. Discard the tea bags." +
                "\n\nFor serving sweet tea:\nStep 1\n\nPour sweet tea into glasses and allow each person to sweeten his/her own tea with the Simple Syrup. Stir and add ice." +
                "\n\nStep 2\n\nGarnish with lemon slices, orange slices, raspberries and/or mint leaves.","For the simple syrup:\nWater\nBrown sugar\n\nFor the iced tea:\nWater\nCold brew tea bag ","\n1 cup\n1 cup\n\n\n7 cups\n2-3 family-size"));
        coffeeItems.add(new coffeeItem(R.drawable.pineappletea, "Pineapple Tea", "4", "1", "Sweet Tea", "Japan","Step 1\n\nBring the 8 cups water to a boil and then remove from the heat. Add in the tea bags and cover, letting sit and steep for 15-20 minutes.\n\n" +
                "Step 2\n\nDiscard tea bags and pour tea into a large pitcher. Stir in the stevia and baking soda until fully dissolved.\n\n" +
                "Step 3\n\nStir in the pineapple juice. Place tea, covered, in the fridge until fully chilled. Pour over ice and garnish with fresh pineapple and mint.","Water\nTea bags\nOrganic Stevia\nBaking soda\nPineapple juice\nFresh mint","8 cups\n2 family sized\n2-4 tablespoons\n1/4 teaspoon\n2 cups\nsome"));
        coffeeItems.add(new coffeeItem(R.drawable.vanilla, "Vanilla Keto Coffee", "4", "1", "Refreshing", "Japan","Step 1\n\nBrew Coffee.Pour in 1 tablespoon Vanilla Omega PowerCreamer." +
                "\n\nStep 2\n\nBlend in a blender or use an immersion blender to blend until combined and frothy.Sprinkle with ground cinnamon if desired.","Strong coffee\nVanilla Omega PowerCreamer\ncinnamon","8 ounces\n1 tablespoon\nsome(optional)"));
        coffeeItems.add(new coffeeItem(R.drawable.thaicoffee, "Thai Iced Coffee ", "4", "1", "Refreshing", "Thai","" +
                "Step 1\n\nAdd the cardamom to the ground coffee. Brew the coffee according to makers instructions.\n\n" +
                "Step 2\n\nPour the coffee into a pitcher or large glass. Add the Amaretto (or almond extract), and stir to combine.\n\n" +
                "Step 3\n\nFill four 12 ounce glasses with crushed ice. Pour the coffee into each glass and top each with 1 tablespoon of sweetened condensed milk. Taste and add more sweetened condensed milk if desired.","Strong black coffee\nCardamom\nMilk\nAlmond extract\nIce","regular size\n2 teaspoons\n1/4 cup\n1 teaspoon\nsome"));
        coffeeItems.add(new coffeeItem(R.drawable.peachtea, "Peach Tea", "4", "1", "Health", "Taiwan","Step 1\n\nAdd the peaches to a quart sized (32 ounce) mason jar or large glass jar. The peaches should fill to the top. Add more or less as needed. Add in the lemon juice, no need to stir." +
                "\n\nStep 2\n\nPour in Everclear until it reaches the top of the jar. For me it was about 2 cups, but pour more or less to get to the top of the jar. Seal with an air tight lid and turn up and down a couple times to make sure the peaches are fully submerged and all parts touching the Everclear.\n\n" +
                "Step 3\n\nAdd the large tea bag or two small tea bags to the boiling water and dunk in and out, allowing the tea to infuse the boiling water. Once the tea seems to have infused the water, pour the cup boiling water (plus the tea bag) into the infused Everclear mixture and stir to combine. Seal and allow the tea bag to sit within the Everclear for 10 minutes.\n\n" +
                "Step 4\n\nMeanwhile, heat the 3/4 cup sugar and 3/4 cup water over medium high heat on the stove. This will make a simple syrup. Stir to combine until the mixture boils, then reduce to a simmer for the remaining time until the tea bag has fully infused.\n\n" +
                "Step 5\n\nAfter 10 minutes, remove the tea bag and pour in the simply syrup to the Everclear mixture. Stir to combine.","Peaches sliced\nLemon juice\nBoiling water\nBlack tea bags\nWater\nWhite sugar","20 ounce\n1 tablespoon\n1 cup\n1 large or 2 small\n3/4 cup\n3/4 cup"));

        coffeeItems.add(new coffeeItem(R.drawable.raspberry, "Raspberry Sweet Tea", "4", "1", "Health", "Japan","Step 1\n\nBring water to a boil, and pour into a pitcher. Add the tea bags, cover and let steep (soak) for 15 minutes.\n\n" +
                "Step 2\n\nRemove the tea bags then add the sugar and baking soda. Stir until the sugar dissolves.\n\n" +
                "Step 3\n\nLet the tea cool. Pour into ice-filled glasses. Garnish with raspberries and orange slices or fresh mint leaves.","Water\nTea bags\nSugar\nBaking soda\nmint","8 cups\n2 family-sized\n1/2 cup\n1/4 teaspoon\nsome"));

        coffeeItems.add(new coffeeItem(R.drawable.chaiteamilk, "Chai Tea Latte ", "4", "1", "Refreshing", "South Asia","Step 1 Prepare tea by heating milk in a medium saucepan over medium heat.\n\n" +
                "Step 2 Add cinnamon and tea bags and allow to simmer for about 5 minutes. Remove from heat and allow to steep for five more minutes before removing cinnamon and tea bags.\n\n" +
                "Step 3 Allow to cool for 20 minutes, then add tea and ice cream (and Bailey's if you're over 21) to a blender and pulse until well combined. If too thin, add more ice cream or ice to the mixture.\n\n" +
                "Step 4 Serve topped with whipped cream and ground nutmeg. ","Milk\nChai tea bags\nCinnamon stick\nCoffee ice cream\nWhipped cream","1 cup\n4 bags\n1 stick\n2 cups\nsome\n"));
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