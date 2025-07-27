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
import com.example.explorebd.models.EcoResort;

import java.util.List;

public class EcoResortAdapter extends BaseAdapter {
    private Context context;
    private List<EcoResort> resortList;

    public EcoResortAdapter(Context context, List<EcoResort> resortList) {
        this.context = context;
        this.resortList = resortList;
    }

    @Override
    public int getCount() {
        return resortList.size();
    }

    @Override
    public Object getItem(int position) {
        return resortList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        EcoResort resort = resortList.get(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_place, parent, false);
        }

        TextView name = convertView.findViewById(R.id.placeName);
        TextView division = convertView.findViewById(R.id.placeDivision);
        TextView district = convertView.findViewById(R.id.placeDistrict);
        TextView type = convertView.findViewById(R.id.placeType);
        TextView description = convertView.findViewById(R.id.placeDescription);
        TextView contactInfo = convertView.findViewById(R.id.resortContact);
        convertView.findViewById(R.id.hotelName).setVisibility(View.GONE);
        convertView.findViewById(R.id.hotelContact).setVisibility(View.GONE);

        name.setText(resort.getPlaceName());
        division.setText("Division: " + resort.getDivision());
        district.setText("District: " + resort.getDistrict());
        type.setText("Type: " + resort.getType());
        description.setText(resort.getDescription());
        contactInfo.setText("Contact: " + resort.getContactInfo());


        // ✅ Add click listener to open details activity
        convertView.setOnClickListener(v -> {
            android.content.Intent intent = new android.content.Intent(context, com.example.explorebd.EcoResortDetailsActivity.class);
            intent.putExtra("resort", resort); // Make sure EcoResort implements Serializable
            context.startActivity(intent);
        });
        convertView.findViewById(R.id.mapButton).setOnClickListener(v -> {
            String url = "https://www.google.com/maps/search/?api=1&query=" + Uri.encode(resort.getPlaceName());
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        });

        return convertView;
    }

}
