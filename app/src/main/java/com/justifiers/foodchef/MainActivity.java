package com.justifiers.foodchef;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.appcompat.widget.Toolbar;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.justifiers.foodchef.BottomNavigationView.DownloadsFragment;
import com.justifiers.foodchef.BottomNavigationView.ProfileFragment;
import com.justifiers.foodchef.BottomNavigationView.SearchFragment;
import com.justifiers.foodchef.BottomNavigationView.ShoppingListFragment;

public class MainActivity extends AppCompatActivity {

    // Declare Variables here
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing the variables
        bottomNavigation = findViewById(R.id.bottom_navigation_view);
        bottomNavigation.setOnNavigationItemSelectedListener(navListen);
//        fcTopToolbar = findViewById(R.id.fcToolbar);
//        // setting Search as default fragment
//        fcTopToolbar.setTitle("Search");
//        setSupportActionBar(fcTopToolbar);
//        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#865730")));
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new SearchFragment())
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }

    // listens to the selected navigation item and sets the fragment for it
    private BottomNavigationView.OnNavigationItemSelectedListener navListen = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem navItem) {
            Fragment selectedFrag = null;

            switch(navItem.getItemId()) {
                case R.id.nav_search:
//                    fcTopToolbar.setTitle("Search");
                    selectedFrag = new SearchFragment();
                    break;
                case R.id.nav_downloads:
//                    fcTopToolbar.setTitle("Downloads");
                    selectedFrag = new DownloadsFragment();
                    break;
                case R.id.nav_shopping_list:
//                    fcTopToolbar.setTitle("Shopping List");
                    selectedFrag = new ShoppingListFragment();
                    break;
                case R.id.nav_profile:
//                    fcTopToolbar.setTitle("Profile");
                    // make settings visible only for profile fragment
                    selectedFrag = new ProfileFragment();
//                    selectedFrag = new LoginFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFrag).commit();
            return true;
        }
    };

}
