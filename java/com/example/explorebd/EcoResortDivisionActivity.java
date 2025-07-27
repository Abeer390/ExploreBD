package com.example.explorebd;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class EcoResortDivisionActivity extends AppCompatActivity {

    private String[] divisions = {"Dhaka", "Chittagong", "Khulna", "Rajshahi", "Barisal", "Sylhet", "Rangpur", "Mymensingh"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_division);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        GridView gridView = findViewById(R.id.divisionGrid);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.grid_item_division,
                R.id.divisionName,
                divisions
        );

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener((adapterView, view, position, id) -> {
            Intent intent = new Intent(this, EcoResortDistrictActivity.class);
            intent.putExtra("division", divisions[position]);
            startActivity(intent);
        });

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // or finish();
        return true;
    }

}
