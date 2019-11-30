package com.justifiers.foodchef;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.justifiers.foodchef.LoginAndSignUp.LoginFragment;


public class SettingsActivity extends AppCompatActivity {

    TextView language_change;
    TextView video_quality_change;
    TextView data_usage_change;
    String[] language_items;
    String[] data_usage_items;
    String[] video_quality_change_items;
    Button content_type_video;
    Button content_type_pictures;
    Button measurements_imperial;
    Button measurements_metric;
    Toolbar sToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        content_type_video = findViewById(R.id.settings_video);
        content_type_pictures = findViewById(R.id.settings_pictures);
        measurements_imperial = findViewById(R.id.settings_imperial);
        measurements_metric = findViewById(R.id.settings_metric);

        sToolbar = findViewById(R.id.sToolbar);
        sToolbar.setTitle("Settings");
        sToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        setSupportActionBar(sToolbar);
        sToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new LoginFragment())
                        .commit();
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

        content_type_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                content_type_video.setBackgroundColor(Color.parseColor("#CEC5BEBE"));
                content_type_video.setBackgroundResource(R.drawable.button_semi_1);
                content_type_pictures.setBackgroundColor(Color.parseColor("#FFFFFF"));
                content_type_pictures.setBackgroundResource(R.drawable.button_semi_2);
            }
        });

        content_type_pictures.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                content_type_video.setBackgroundColor(Color.parseColor("#FFFFFF"));
                content_type_video.setBackgroundResource(R.drawable.button_semi_3);
                content_type_pictures.setBackgroundColor(Color.parseColor("#CEC5BEBE"));
                content_type_pictures.setBackgroundResource(R.drawable.button_semi_4);
            }
        });

        measurements_metric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                measurements_metric.setBackgroundColor(Color.parseColor("#CEC5BEBE"));
                measurements_metric.setBackgroundResource(R.drawable.button_semi_1);
                measurements_imperial.setBackgroundColor(Color.parseColor("#FFFFFF"));
                measurements_imperial.setBackgroundResource(R.drawable.button_semi_2);
            }
        });

        measurements_imperial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                measurements_imperial.setBackgroundColor(Color.parseColor("#CEC5BEBE"));
                measurements_imperial.setBackgroundResource(R.drawable.button_semi_4);
                measurements_metric.setBackgroundColor(Color.parseColor("#FFFFFF"));
                measurements_metric.setBackgroundResource(R.drawable.button_semi_3);
            }
        });
    }
}
