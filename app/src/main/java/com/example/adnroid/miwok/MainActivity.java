package com.example.adnroid.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the Views that represent different categories
        TextView numbers = findViewById(R.id.numbers);
        TextView family = findViewById(R.id.family);
        TextView colors = findViewById(R.id.colors);
        TextView phrases = findViewById(R.id.phrases);

        // Set a click listeners on each view
        numbers.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(numbersIntent);
            }
        });

        family.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the family View is clicked on.
            @Override
            public void onClick(View v) {
                Intent familyIntent = new Intent(MainActivity.this, FamilyActivity.class);
                startActivity(familyIntent);
            }
        });

        colors.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the colors View is clicked on.
            @Override
            public void onClick(View v) {
                Intent colorsIntent = new Intent(MainActivity.this, ColorsActivity.class);
                startActivity(colorsIntent);
            }
        });

        phrases.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the phrases View is clicked on.
            @Override
            public void onClick(View v) {
                Intent phrasesIntent = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(phrasesIntent);
            }
        });
    }
}
