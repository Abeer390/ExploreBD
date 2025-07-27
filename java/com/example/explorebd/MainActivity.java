package com.example.explorebd;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.explorebd.utils.SessionManager;

public class MainActivity extends AppCompatActivity {

    Button touristButton, ecoResortButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // You will create this layout
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        SessionManager session = new SessionManager(this);
        if (!session.isLoggedIn()) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }

        touristButton = findViewById(R.id.touristButton);
        ecoResortButton = findViewById(R.id.ecoResortButton);

        touristButton.setOnClickListener(v ->
                startActivity(new Intent(this, TouristDivisionActivity.class)));

        ecoResortButton.setOnClickListener(v ->
                startActivity(new Intent(this, EcoResortDivisionActivity.class)));
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // or finish();
        return true;
    }

}
