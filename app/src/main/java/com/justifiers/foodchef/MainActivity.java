package com.justifiers.foodchef;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.justifiers.foodchef.BottomNavigationView.DownloadsFragment;
import com.justifiers.foodchef.BottomNavigationView.ProfileFragment;
import com.justifiers.foodchef.BottomNavigationView.SearchFragment;
import com.justifiers.foodchef.BottomNavigationView.ShoppingListFragment;

public class MainActivity extends AppCompatActivity {

    // Declare Variables here
    BottomNavigationView bottomNavigation;
    Toolbar fcTopToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing the variables
        bottomNavigation = findViewById(R.id.bottom_navigation_view);
        bottomNavigation.setOnNavigationItemSelectedListener(navListen);
        fcTopToolbar = findViewById(R.id.fcToolbar);
        // setting Search as default fragment
        fcTopToolbar.setTitle("Search");
        setSupportActionBar(fcTopToolbar);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new SearchFragment())
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings, menu);
        return true;
    }

    // listens to the selected navigation item and sets the fragment for it
    private BottomNavigationView.OnNavigationItemSelectedListener navListen = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem navItem) {
            Fragment selectedFrag = null;

            switch(navItem.getItemId()) {
                case R.id.nav_search:
                    fcTopToolbar.setTitle("Search");
                    selectedFrag = new SearchFragment();
                    break;
                case R.id.nav_downloads:
                    fcTopToolbar.setTitle("Downloads");
                    selectedFrag = new DownloadsFragment();
                    break;
                case R.id.nav_shopping_list:
                    fcTopToolbar.setTitle("Shopping List");
                    selectedFrag = new ShoppingListFragment();
                    break;
                case R.id.nav_profile:
                    fcTopToolbar.setTitle("Profile");
                    // make settings visible only for profile fragment
                    fcTopToolbar.getMenu().findItem(R.id.tool_settings).setVisible(true);
                    selectedFrag = new ProfileFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFrag).commit();
            return true;
        }
    };

}
