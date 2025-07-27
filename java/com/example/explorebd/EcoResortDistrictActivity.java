package com.example.explorebd;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

import com.example.explorebd.data.DataProvider;
public class EcoResortDistrictActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district); // reuse same layout
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        String division = getIntent().getStringExtra("division");
        List<String> districts = DataProvider.getEcoResortDistrictsByDivision(division);

        ListView listView = findViewById(R.id.districtList);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, districts);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(this, EcoResortListActivity.class);
            intent.putExtra("division", division);
            intent.putExtra("district", districts.get(i));
            startActivity(intent);
        });
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); // or finish();
        return true;
    }

}
