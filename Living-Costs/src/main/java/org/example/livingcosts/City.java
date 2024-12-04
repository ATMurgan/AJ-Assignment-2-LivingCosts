package org.example.livingcosts;

import com.google.gson.annotations.SerializedName;

public class City {
    @SerializedName("city_id")
    private String cityId;

    @SerializedName("city_name")
    private String cityName;

    @SerializedName("country_name")
    private String countryName;

    @SerializedName("lat")
    private String latitude;

    @SerializedName("lng")
    private String longitude;


    public City(String cityId, String cityName, String countryName, String latitude, String longitude) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.countryName = countryName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters
    public String getCityId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
}
