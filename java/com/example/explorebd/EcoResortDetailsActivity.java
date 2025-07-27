package com.example.explorebd;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.example.explorebd.models.EcoResort;

public class EcoResortDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spot_details);

        EcoResort resort = (EcoResort) getIntent().getSerializableExtra("resort");

        if (resort == null) {
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }
        Log.d("DEBUG_RESORT", "Contact: " + resort.getContactInfo());
        Toast.makeText(this, resort.getContactInfo(), Toast.LENGTH_LONG).show();

        ((TextView) findViewById(R.id.placeName)).setText(resort.getPlaceName());
        ((TextView) findViewById(R.id.placeDivision)).setText("Division: " + resort.getDivision());
        ((TextView) findViewById(R.id.placeDistrict)).setText("District: " + resort.getDistrict());
        ((TextView) findViewById(R.id.placeDescription)).setText(resort.getDescription());
        ((TextView) findViewById(R.id.resortContact)).setText("Contact: " + resort.getContactInfo());
        findViewById(R.id.hotelName).setVisibility(View.GONE);
        findViewById(R.id.hotelContact).setVisibility(View.GONE);

        findViewById(R.id.mapButton).setOnClickListener(v -> {
            String url = "https://www.google.com/maps/search/?api=1&query=" + Uri.encode(resort.getPlaceName());
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        });
    }
}