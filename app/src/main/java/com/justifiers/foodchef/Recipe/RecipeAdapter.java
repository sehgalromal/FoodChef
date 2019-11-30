package com.justifiers.foodchef.Recipe;

import android.content.Context;
import android.content.Intent;
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

import java.io.OutputStream;
import java.util.ArrayList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.recipeHolder> {

    ArrayList<Recipe> recipeList;
    private Context ctx;
    OutputStream outputStream;

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
    public void onBindViewHolder(final recipeHolder holder, final int position) {
        Picasso.get().load(recipeList.get(position).getrImage()).into(holder.recipeImage);
        holder.recipeName.setText(recipeList.get(position).getrName());
        holder.recipeTime.setText(recipeList.get(position).getrTime());
        holder.recipe_likes.setText(recipeList.get(position).getLikes());
        recipeList.get(position).getrTime();
        holder.recipe_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(ctx, holder.recipe_popup);
                popupMenu.getMenuInflater().inflate(R.menu.recipe_more_verc_items, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.recipe_menu_share:
//                                Toast.makeText(ctx, "Share Clicked!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Intent.ACTION_SEND);
                                intent.setType("text/plain");
                                intent.putExtra(Intent.EXTRA_TEXT,recipeList.get(position).getrName());
                                ctx.startActivity(intent.createChooser(intent, "Share Via"));

                                break;
                            case R.id.recipe_menu_download:
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
        TextView recipe_likes;
        ImageButton recipe_popup;

        public recipeHolder(@NonNull View itemView) {
            super(itemView);
            recipeImage = itemView.findViewById(R.id.recycler_popular_today_image_view);
            recipeName = itemView.findViewById(R.id.recycler_popular_recipe_desc);
            recipeTime = itemView.findViewById(R.id.recycler_popular_today_time);
            recipe_likes = itemView.findViewById(R.id.recycler_view_recipe_likes);
            recipe_popup = itemView.findViewById(R.id.recipe_popup);
        }
    }
}
