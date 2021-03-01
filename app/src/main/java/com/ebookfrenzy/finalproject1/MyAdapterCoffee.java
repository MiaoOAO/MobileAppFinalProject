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

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row,
                parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final coffeeItem coffeeItem = coffeeItems.get(position);

        readCursorData(coffeeItem, holder);

        holder.fruit_image.setImageResource(coffeeItem.getImageResourse());
        holder.fruit_listName_txt.setText(coffeeItem.getTitle());
        /*
        holder.fruit_listName_txt.setText(data1[position]);
        holder.fruit_listDesc_txt.setText(data2[position]);
        holder.fruit_image.setImageResource(images[position]);
*/
        holder.fruit_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, juiceContent.class);

                intent.putExtra("image",coffeeItem.getImageResourse());
                intent.putExtra("name", coffeeItem.getTitle());

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
        TextView fruit_listName_txt;
        ImageView fruit_image;
        CardView fruit_cardView;
        Button fruit_favBtn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            fruit_listName_txt = itemView.findViewById(R.id.fruit_listName_txt);
            //fruit_listDesc_txt = itemView.findViewById(R.id.fruit_listDesc_txt);
            fruit_image = itemView.findViewById(R.id.fruit_image);
            fruit_cardView = itemView.findViewById(R.id.fruit_cardView);
            fruit_favBtn = itemView.findViewById(R.id.fruit_favor);

            fruit_favBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    coffeeItem coffeeItem = coffeeItems.get(position);

                    if(coffeeItem.getFavStatus().equals("0")){
                        coffeeItem.setFavStatus("1");
                        favDB.insertIntoTheDatabase(coffeeItem.getTitle(), coffeeItem.getImageResourse(),
                                coffeeItem.getKey_id(), coffeeItem.getFavStatus());
                        fruit_favBtn.setBackgroundResource(R.drawable.ic_baseline_star_24);
                    }else{
                        coffeeItem.setFavStatus("0");
                        favDB.remove_fav(coffeeItem.getKey_id());
                        fruit_favBtn.setBackgroundResource(R.drawable.ic_baseline_star);
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
                    myViewHolder.fruit_favBtn.setBackgroundResource(R.drawable.ic_baseline_star_24);
                }else if(item_fav_status != null && item_fav_status.equals("0")){
                    myViewHolder.fruit_favBtn.setBackgroundResource(R.drawable.ic_baseline_star);
                }
            }
        } finally {
            if(cursor != null && cursor.isClosed())
                cursor.close();
            db.close();
        }
    }
}
