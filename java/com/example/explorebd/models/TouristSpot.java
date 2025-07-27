package com.example.explorebd.models;

import java.io.Serializable;

public class TouristSpot implements Serializable {
    private String placeName, division, district, type, description, hotelName, hotelContact;

    public TouristSpot(String placeName, String division, String district, String type,
                       String description, String hotelName, String hotelContact) {
        this.placeName = placeName;
        this.division = division;
        this.district = district;
        this.type = type;
        this.description = description;
        this.hotelName = hotelName;
        this.hotelContact = hotelContact;
    }

    public String getPlaceName() { return placeName; }
    public String getDivision() { return division; }
    public String getDistrict() { return district; }
    public String getType() { return type; }
    public String getDescription() { return description; }
    public String getHotelName() { return hotelName; }
    public String getHotelContact() { return hotelContact; }
}
