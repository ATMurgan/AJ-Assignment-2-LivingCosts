package org.example.livingcosts;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Country {

    // Field for city ID
    @SerializedName("city_id")
    private Integer cityId;

    // Field for city name
    @SerializedName("city_name")
    private String cityName;

    // Field for country name
    @SerializedName("country_name")
    private String countryName;

    // Field for a list of price-related data
    @SerializedName("prices")
    private List<Price> prices;


    // Constructor to initialize fields
    public Country(Integer cityId, String cityName, String countryName, List<Price> prices) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.countryName = countryName;
        this.prices = prices;
    }

    // Getters and Setters
    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }


    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    @Override
    public String toString() {
        return "Country{" +
                "cityId='" + cityId + '\'' +
                ", cityName='" + cityName + '\'' +
                ", countryName='" + countryName + '\'' +
                ", prices=" + prices +
                '}';
    }

}
