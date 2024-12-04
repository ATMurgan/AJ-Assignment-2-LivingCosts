package org.example.livingcosts;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class APIResponse {

    @SerializedName("cities")
    private List<City> cities;

    @SerializedName("city_id")
    private Integer cityId;

    @SerializedName("city_name")
    private String cityName;

    @SerializedName("country_name")
    private String countryName;

    @SerializedName("prices")
    private List<Price> prices;

    // Getters and setters for City Objects
    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    // Getters and setters for Country Objects
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

    public boolean isCityResponse() {
        return cities != null && !cities.isEmpty();
    }

    public boolean isCountryResponse() {
        return cityId != null;
    }
}

