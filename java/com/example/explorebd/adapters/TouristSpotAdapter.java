package com.example.explorebd.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.explorebd.R;
import com.example.explorebd.TouristSpotDetailsActivity;
import com.example.explorebd.models.TouristSpot;

import org.w3c.dom.Text;

import java.util.List;

public class TouristSpotAdapter extends BaseAdapter {
    private Context context;
    private List<TouristSpot> spotList;

    public TouristSpotAdapter(Context context, List<TouristSpot> spotList) {
        this.context = context;
        this.spotList = spotList;
    }

    @Override
    public int getCount() {
        return spotList.size();
    }

    @Override
    public Object getItem(int position) {
        return spotList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TouristSpot spot = spotList.get(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_place, parent, false);
        }

        TextView name = convertView.findViewById(R.id.placeName);
        TextView division = convertView.findViewById(R.id.placeDivision);
        TextView district = convertView.findViewById(R.id.placeDistrict);
        TextView type = convertView.findViewById(R.id.placeType);
        TextView description = convertView.findViewById(R.id.placeDescription);
        TextView hotelName = convertView.findViewById(R.id.hotelName);
        TextView hotelContact = convertView.findViewById(R.id.hotelContact);
        convertView.findViewById(R.id.resortContact).setVisibility(View.GONE);

        name.setText(spot.getPlaceName());
        division.setText("Division: " + spot.getDivision());
        district.setText("District: " + spot.getDistrict());
        type.setText("Type: " + spot.getType());
        description.setText(spot.getDescription());
        hotelName.setText("Nearest Hotel-->\nHotel Name: " + spot.getHotelName());
        hotelContact.setText("Contact: " + spot.getHotelContact());

        // ✅ Click listener to open TouristSpotDetailsActivity
        convertView.setOnClickListener(v -> {
            Intent intent = new Intent(context, TouristSpotDetailsActivity.class);
            intent.putExtra("spot", spot); // Ensure TouristSpot implements Serializable
            context.startActivity(intent);
        });
        convertView.findViewById(R.id.mapButton).setOnClickListener(v -> {
            String url = "https://www.google.com/maps/search/?api=1&query=" + Uri.encode(spot.getPlaceName());
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        });

        return convertView;
    }
}
