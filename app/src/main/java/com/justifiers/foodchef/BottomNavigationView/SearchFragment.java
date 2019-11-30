package com.justifiers.foodchef.BottomNavigationView;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.justifiers.foodchef.MainActivity;
import com.justifiers.foodchef.R;
import com.justifiers.foodchef.Recipe.Recipe;
import com.justifiers.foodchef.Recipe.RecipeAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class SearchFragment extends Fragment {

    // Declare Variables here
//    DatabaseReference ref;
//    ArrayList<Recipe> recipeList;
//    RecyclerView recyclerView;
//    RecipeAdapter recipeAdapter;
//    RecyclerView.LayoutManager layoutManager;
//    MaterialSearchView searchView;
//    ChipGroup chip_selection;
//    Toolbar toolbar;
//    SwipeRefreshLayout pullToRefresh;
//    List<String> recent_keywords = new ArrayList<String>(5);


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.search_fragment, container, false);

//        // Fetch the data from the collection source by getting the reference
//        ref = FirebaseDatabase.getInstance().getReference().child("Recipe");
//        // initializing the variables
//        recyclerView = view.findViewById(R.id.recycler_view);
//        pullToRefresh = view.findViewById(R.id.swipe_container);
//        chip_selection = view.findViewById(R.id.search_chips);
//        chip_selection.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(ChipGroup group, int checkedId) {
//                Chip chip = group.findViewById(checkedId);
//                if (chip != null) {
//                    //Toast.makeText(MainActivity.this, "Selected Chip is: " + chip.getText(), Toast.LENGTH_SHORT).show();
//                    ArrayList<Recipe> rlist = new ArrayList<>();
//                    for(Recipe object : recipeList)
//                    {
//                        if(object.getRtype().contains((chip.getText().toString().toLowerCase()))){
//                            rlist.add(object);
//                        }
//                    }
//                    layoutManager = new GridLayoutManager(getActivity(), 2);
//                    recyclerView.setLayoutManager(layoutManager);
//                    RecipeAdapter adapter = new RecipeAdapter(rlist, getActivity());
//                    recyclerView.setAdapter(adapter);
//                }
//            }
//        });
//        searchView = view.findViewById(R.id.search_view);
////        searchView.setVoiceSearch(true);
//        searchView.setEllipsize(true);
//
//        toolbar =  view.findViewById(R.id.toolbar);
//        toolbar.setSubtitle("Search");
//        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        return view;
    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setHasOptionsMenu(true);
//    }


//    @Override
//    public void onStart() {
//        super.onStart();
//        if (ref != null) {
//            ref.addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                    if (dataSnapshot.exists()) {
//                        recipeList = new ArrayList<>();
//                        for (DataSnapshot ds : dataSnapshot.getChildren())
//                            recipeList.add(ds.getValue(Recipe.class));
//
//                        for (Recipe object : recipeList) {
//                            recent_keywords.add(object.getRname());
//                        }
//                    }
//                    layoutManager = new GridLayoutManager(getActivity(), 2);
//                    recyclerView.setLayoutManager(layoutManager);
//                    recipeAdapter = new RecipeAdapter(recipeList, getActivity());
//                    Log.e("WDWD", "FIRST_ADAPTER");
//                    recyclerView.setAdapter(recipeAdapter);
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError databaseError) {
//                    Toast.makeText(getActivity(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            });
//        }
//        if(searchView != null) {
//
//            searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
//
//                @Override
//                public boolean onQueryTextSubmit(String query) {
//                    String[] str_recent_keywords = recent_keywords.toArray(new String[]{});
//                    searchView.setSuggestions(str_recent_keywords);
//                    searchView.setSuggestionIcon(getResources().getDrawable(R.drawable.ic_recent));
//                    search(query);
//                    return true;
//                }
//
//                @Override
//                public boolean onQueryTextChange(String newText) {
//                    String[] str_recent_keywords = recent_keywords.toArray(new String[]{});
//                    searchView.setSuggestions(str_recent_keywords);
//                    searchView.setSuggestionIcon(getResources().getDrawable(R.drawable.ic_recent));
//                    return true;
//                }
//            });
//        }
//   }

//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        MenuItem item = menu.findItem(R.id.tool_settings);
//        item.setVisible(false);
//        inflater.inflate(R.menu.search_bar, menu);
//        super.onCreateOptionsMenu(menu, inflater);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        if (id == R.id.sear) {
//            Intent i = new Intent(getActivity(), SettingsActivity.class);
//            startActivity(i);
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//        inflater.inflate(R.menu.search_bar, menu);
//        MenuItem item = menu.findItem(R.id.action_search);
//        super.onCreateOptionsMenu(menu, inflater);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.action_search:
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

//    private void search(String str)
//    {
//        ArrayList<Recipe> rlist = new ArrayList<>();
//        for(Recipe object : recipeList)
//        {
//            if(object.getRname().toLowerCase().contains(str.toLowerCase())){
//                rlist.add(object);
//            }
//        }
//        layoutManager = new GridLayoutManager(getActivity(), 2);
//        RecipeAdapter adapter = new RecipeAdapter(rlist, getActivity());
//        Log.e("WDWDWA","SECOND_ADAPTER");
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);
//        searchView.closeSearch();
//        Toast.makeText(getActivity(),"Recipes Fetched Successfully!",Toast.LENGTH_LONG).show();
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Toast toast = Toast.makeText(getActivity(),"Pull Down to load all Recipies back",Toast.LENGTH_LONG);
//                toast.show();
//            }
//        }, 2000);
//    }
//    @Override
//    public void onBackPressed() {
//        if (searchView.isSearchOpen()) {
//            searchView.closeSearch();
//        } else {
//            super.onBackPressed();
//        }
//    }
}
