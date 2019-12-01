package com.justifiers.foodchef.Instructions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.justifiers.foodchef.R;

import java.util.ArrayList;
import java.util.List;

public class InstructionsActivity extends AppCompatActivity {

    private ViewPager stepPager;
    private InstructionsViewPagerAdapter instructionsViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        String imageOne = "https://images.pexels.com/photos/5938/food-salad-healthy-lunch.jpg?auto=compress&cs=tinysrgb&dpr=2&w=500";
        String descOne = "Peel parsnips. Fill a large pot with cold water. Season with salt, then add parsnips and bring to a boil. Cook under very tender, approx. 15 min.";

        String imageTwo = "https://images.pexels.com/photos/1099680/pexels-photo-1099680.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500";
        String descTwo = "In the meantime, roughly chop Kalamata olives, capers, garlic, parsley, and mint, then add to a bowl. Zest the lemon over the bowl, then add the lemon juice and olive oil. Season with salt and pepper and mix to combine.";

        List<InstructionItem> steps = new ArrayList<>();
        steps.add(new InstructionItem(descOne, imageOne, 0));
        steps.add(new InstructionItem(descTwo, imageTwo, 0));

        stepPager = findViewById(R.id.steps_view_pager);
        instructionsViewPagerAdapter = new InstructionsViewPagerAdapter(this, steps);
        stepPager.setAdapter(instructionsViewPagerAdapter);
    }
}
