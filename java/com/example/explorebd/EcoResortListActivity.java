package com.example.explorebd;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.explorebd.adapters.EcoResortAdapter;
import com.example.explorebd.data.DataProvider;
import com.example.explorebd.models.EcoResort;

import java.util.ArrayList;
import java.util.List;

public class EcoResortListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_list);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        String division = getIntent().getStringExtra("division");
        String district = getIntent().getStringExtra("district");

        List<EcoResort> allResorts = DataProvider.getEcoResorts();
        List<EcoResort> filteredResorts = new ArrayList<>();

        for (EcoResort resort : allResorts) {
            if (resort.getDivision().equals(division) && resort.getDistrict().equals(district)) {
                filteredResorts.add(resort);
            }
        }

        ListView listView = findViewById(R.id.placeList);
        EcoResortAdapter adapter = new EcoResortAdapter(this, filteredResorts);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            EcoResort selectedResort = filteredResorts.get(position);
            Intent intent = new Intent(this, EcoResortDetailsActivity.class);
            intent.putExtra("resort", selectedResort);
            startActivity(intent);
        });
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // or finish();
        return true;
    }

}
