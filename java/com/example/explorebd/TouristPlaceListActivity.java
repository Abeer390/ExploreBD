package com.example.explorebd;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.explorebd.adapters.TouristSpotAdapter;
import com.example.explorebd.data.DataProvider;
import com.example.explorebd.models.TouristSpot;

import java.util.ArrayList;
import java.util.List;

public class TouristPlaceListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_list);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        String division = getIntent().getStringExtra("division");
        String district = getIntent().getStringExtra("district");

        List<TouristSpot> allSpots = DataProvider.getTouristSpots();
        List<TouristSpot> filteredSpots = new ArrayList<>();

        for (TouristSpot spot : allSpots) {
            if (spot.getDivision().equals(division) && spot.getDistrict().equals(district)) {
                filteredSpots.add(spot);
            }
        }

        ListView listView = findViewById(R.id.placeList);
        TouristSpotAdapter adapter = new TouristSpotAdapter(this, filteredSpots);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            TouristSpot selectedSpot = filteredSpots.get(position);
            Intent intent = new Intent(this, TouristSpotDetailsActivity.class);
            intent.putExtra("spot", selectedSpot);
            startActivity(intent);
        });
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // or finish();
        return true;
    }

}
