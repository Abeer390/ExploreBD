package com.example.explorebd;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.example.explorebd.models.TouristSpot;

public class TouristSpotDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spot_details);

        TouristSpot spot = (TouristSpot) getIntent().getSerializableExtra("spot");

        if (spot == null) {
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }
        Log.d("DEBUG_SPOT", "Hotel: " + spot.getHotelName() + ", Contact: " + spot.getHotelContact());
        Toast.makeText(this, "Hotel: " + spot.getHotelName(), Toast.LENGTH_LONG).show();

        ((TextView) findViewById(R.id.placeName)).setText(spot.getPlaceName());
        ((TextView) findViewById(R.id.placeDivision)).setText("Division: " + spot.getDivision());
        ((TextView) findViewById(R.id.placeDistrict)).setText("District: " + spot.getDistrict());
        ((TextView) findViewById(R.id.placeDescription)).setText(spot.getDescription());
        ((TextView) findViewById(R.id.hotelName)).setText("Hotel: " + spot.getHotelName());
        ((TextView) findViewById(R.id.hotelContact)).setText("Contact: " + spot.getHotelContact());
        findViewById(R.id.resortContact).setVisibility(View.GONE);

        findViewById(R.id.mapButton).setOnClickListener(v -> {
            String url = "https://www.google.com/maps/search/?api=1&query=" + Uri.encode(spot.getPlaceName());
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        });
    }
}
