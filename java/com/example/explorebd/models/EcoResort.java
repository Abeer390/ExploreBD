package com.example.explorebd.models;

import java.io.Serializable;

public class EcoResort implements Serializable {
    private String placeName, division, district, type, description, contactInfo;

    public EcoResort(String placeName, String division, String district, String type,
                     String description, String contactInfo) {
        this.placeName = placeName;
        this.division = division;
        this.district = district;
        this.type = type;
        this.description = description;
        this.contactInfo = contactInfo;
    }

    public String getPlaceName() { return placeName; }
    public String getDivision() { return division; }
    public String getDistrict() { return district; }
    public String getType() { return type; }
    public String getDescription() { return description; }
    public String getContactInfo() { return contactInfo; }
}
