package com.justifiers.foodchef;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.justifiers.foodchef.BottomNavigationView.ProfileFragment;
import com.justifiers.foodchef.BottomNavigationView.SearchFragment;
import com.justifiers.foodchef.LoginAndSignUp.LoginFragment;


public class SettingsActivity extends AppCompatActivity {

    TextView language_change;
    TextView video_quality_change;
    TextView data_usage_change;
    String[] language_items;
    String[] data_usage_items;
    String[] video_quality_change_items;
    Toolbar fcTopToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        fcTopToolbar = findViewById(R.id.fcToolbar);
        fcTopToolbar.setTitle("Settings");
        fcTopToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        setSupportActionBar(fcTopToolbar);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#865730")));
        fcTopToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        language_change = findViewById(R.id.settings_lang_change);
        language_items = getResources().getStringArray(R.array.settings_language_items);

        language_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder language_builder = new AlertDialog.Builder(SettingsActivity.this);
                language_builder.setSingleChoiceItems(language_items, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                             language_change.setText(language_items[i]);
                             dialogInterface.dismiss();
                    }
                });
                AlertDialog lDialog = language_builder.create();
                lDialog.show();
            }
        });

        data_usage_change = findViewById(R.id.settings_data_usage_change);
        data_usage_items = getResources().getStringArray(R.array.settings_data_usage_items);

        data_usage_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder data_usage_builder = new AlertDialog.Builder(SettingsActivity.this);
                data_usage_builder.setSingleChoiceItems(data_usage_items, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        data_usage_change.setText(data_usage_items[i]);
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog lDialog = data_usage_builder.create();
                lDialog.show();
            }
        });

        video_quality_change = findViewById(R.id.settings_video_quality_change);
        video_quality_change_items = getResources().getStringArray(R.array.settings_video_quality_values);

        video_quality_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder video_quality_builder = new AlertDialog.Builder(SettingsActivity.this);
                video_quality_builder.setSingleChoiceItems(video_quality_change_items, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        video_quality_change.setText(video_quality_change_items[i]);
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog lDialog = video_quality_builder.create();
                lDialog.show();
            }
        });



    }
}
