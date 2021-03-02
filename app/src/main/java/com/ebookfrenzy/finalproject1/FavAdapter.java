package com.ebookfrenzy.finalproject1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.ViewHolder> {

    private Context context;
    private List<juiceFavItem> favItemList;
    private juiceFavDB favDB;

    public FavAdapter(Context context, List<juiceFavItem> favItemList){
        this.context = context;
        this.favItemList = favItemList;
    }


    @NonNull
    @Override
    public FavAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.juice_fav_item, parent, false);
        favDB = new juiceFavDB(context);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavAdapter.ViewHolder holder, final int position) {

        final juiceFavItem juiceFavItem = favItemList.get(position);

        holder.favImageView.setImageResource(juiceFavItem.getItem_image());
        holder.favTextView.setText(juiceFavItem.getItemTitle());
        holder.favCategory.setText("");
        holder.favCountry.setText("");

        holder.favCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, juiceContent.class);

                intent.putExtra("name", juiceFavItem.getItemTitle());
                intent.putExtra("image", juiceFavItem.getItem_image());
                intent.putExtra("category", juiceFavItem.getItem_category());
                intent.putExtra("country", juiceFavItem.getItem_country());

                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return favItemList.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{

        TextView favTextView, favCategory, favCountry;
        Button favBtn;
        ImageView favImageView;
        CardView favCardView;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            favTextView = itemView.findViewById(R.id.favTextView);
            favBtn = itemView.findViewById(R.id.favBtn);
            favImageView = itemView.findViewById(R.id.favImageView);
            favCategory = itemView.findViewById(R.id.favCategory);
            favCountry = itemView.findViewById(R.id.favCountry);
            favCardView = itemView.findViewById(R.id.fruit_cardView);

            favBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    int position = getAdapterPosition();
                    final juiceFavItem favItem = favItemList.get(position);
                    favDB.remove_fav(favItem.getKey_id());
                    removeItem(position);
                }
            });
        }

    }

    private void removeItem(int position){
        favItemList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, favItemList.size());
    }
}
