package com.ebookfrenzy.finalproject1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapterCoffee extends RecyclerView.Adapter<MyAdapterCoffee.MyViewHolder> {

    private ArrayList<coffeeItem> coffeeItems;
    private Context context;
    private coffeeFavDB favDB;

    public MyAdapterCoffee(Context context, ArrayList<coffeeItem> coffeeItems){
        this.context = context;
        this.coffeeItems = coffeeItems;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        favDB = new coffeeFavDB(context);
        SharedPreferences prefs = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart", true);
        if(firstStart){
            createTableOnFirstStart();
        }

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coffee_my_row,
                parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final coffeeItem coffeeItem = coffeeItems.get(position);

        readCursorData(coffeeItem, holder);

        holder.coffee_image.setImageResource(coffeeItem.getImageResourse());
        holder.coffee_listName_txt.setText(coffeeItem.getTitle());
        holder.coffee_category.setText("");
        holder.coffee_country.setText("");
        holder.coffee_instructions.setText("");
        holder.coffee_ingredient.setText("");
        holder.coffee_measure.setText("");
        /*
        holder.fruit_listName_txt.setText(data1[position]);
        holder.fruit_listDesc_txt.setText(data2[position]);
        holder.fruit_image.setImageResource(images[position]);
*/
        holder.coffee_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, juiceContent.class);

                intent.putExtra("image",coffeeItem.getImageResourse());
                intent.putExtra("name", coffeeItem.getTitle());
                intent.putExtra("category", coffeeItem.getCategory());
                intent.putExtra("country", coffeeItem.getCountry());
                intent.putExtra("instructions", coffeeItem.getInstructions());
                intent.putExtra("ingredient", coffeeItem.getIngredient());
                intent.putExtra("measure", coffeeItem.getMeasure());

                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return coffeeItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        //TextView fruit_listName_txt, fruit_listDesc_txt;
        TextView coffee_listName_txt, coffee_category, coffee_country, coffee_instructions, coffee_ingredient, coffee_measure ;
        ImageView coffee_image;
        CardView coffee_cardView;
        Button coffee_favBtn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            coffee_listName_txt = itemView.findViewById(R.id.coffee_listName_txt);
            //fruit_listDesc_txt = itemView.findViewById(R.id.fruit_listDesc_txt);
            coffee_image = itemView.findViewById(R.id.coffee_image);
            coffee_cardView = itemView.findViewById(R.id.coffee_cardView);
            coffee_category = itemView.findViewById(R.id.coffee_category);
            coffee_country = itemView.findViewById(R.id.coffee_country);
            //coffee_instructions = itemView.findViewById(R.id.coffee_instructions);
            //coffee_ingredient = itemView.findViewById(R.id.ingredient);
            //coffee_measure = itemView.findViewById(R.id.measure);
            coffee_favBtn = itemView.findViewById(R.id.coffee_favor);


            coffee_favBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    coffeeItem coffeeItem = coffeeItems.get(position);

                    if(coffeeItem.getFavStatus().equals("0")){
                        coffeeItem.setFavStatus("1");
                        favDB.insertIntoTheDatabase(coffeeItem.getTitle(), coffeeItem.getImageResourse(),
                                coffeeItem.getKey_id(), coffeeItem.getFavStatus(), coffeeItem.getCategory(), coffeeItem.getCountry(), coffeeItem.getInstructions(), coffeeItem.getIngredient(), coffeeItem.getMeasure());
                        coffee_favBtn.setBackgroundResource(R.drawable.ic_baseline_star_24);
                    }else{
                        coffeeItem.setFavStatus("0");
                        favDB.remove_fav(coffeeItem.getKey_id());
                        coffee_favBtn.setBackgroundResource(R.drawable.ic_baseline_star);
                    }
                }
            });
        }
    }

    private void createTableOnFirstStart(){
        favDB.insertEmpty();

        SharedPreferences prefs = context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstStart", false);
        editor.apply();
    }

    private void readCursorData(coffeeItem coffeeItem, MyViewHolder myViewHolder){
        Cursor cursor = favDB.read_all_data(coffeeItem.getKey_id());
        SQLiteDatabase db = favDB.getReadableDatabase();
        try{
            while(cursor.moveToNext()){
                String item_fav_status = cursor.getString(cursor.getColumnIndex(coffeeFavDB.FAVORITE_STATUS));
                coffeeItem.setFavStatus(item_fav_status);

                if(item_fav_status != null && item_fav_status.equals("1")){
                    myViewHolder.coffee_favBtn.setBackgroundResource(R.drawable.ic_baseline_star_24);
                }else if(item_fav_status != null && item_fav_status.equals("0")){
                    myViewHolder.coffee_favBtn.setBackgroundResource(R.drawable.ic_baseline_star);
                }
            }
        } finally {
            if(cursor != null && cursor.isClosed())
                cursor.close();
            db.close();
        }
    }
}
