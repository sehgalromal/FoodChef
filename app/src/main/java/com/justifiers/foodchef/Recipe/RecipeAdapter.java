package com.justifiers.foodchef.Recipe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.justifiers.foodchef.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.recipeHolder> {

    ArrayList<Recipe> recipeList;
    private Context ctx;
    public RecipeAdapter(ArrayList<Recipe> recipeList, Context ctx) {
        this.recipeList = recipeList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public recipeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_holder, parent, false);
        return new recipeHolder(view);
    }

    @Override
    public void onBindViewHolder(final recipeHolder holder, int position) {
        Picasso.get().load(recipeList.get(position).getrImage()).into(holder.recipeImage);
        holder.recipeName.setText(recipeList.get(position).getRname());
        holder.recipeTime.setText(recipeList.get(position).getRtime());
        recipeList.get(position).getRtype();
        holder.recipe_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(ctx, holder.recipe_popup);
                popupMenu.getMenuInflater().inflate(R.menu.recipe_more_verc_items, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.recipe_menu_share:
                                Toast.makeText(ctx, "Share Clicked!", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.recipe_menu_download:
                                Toast.makeText(ctx, "Download Clicked!", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }


    public class recipeHolder extends RecyclerView.ViewHolder {
        ImageView recipeImage;
        TextView recipeName;
        TextView recipeTime;
        ImageButton recipe_popup;
        public recipeHolder(@NonNull View itemView) {
            super(itemView);
            recipeImage = itemView.findViewById(R.id.recycler_popular_today_image_view);
            recipeName = itemView.findViewById(R.id.recycler_popular_recipe_desc);
            recipeTime = itemView.findViewById(R.id.recycler_popular_today_time);
            recipe_popup = itemView.findViewById(R.id.recipe_popup);
        }
    }
}
