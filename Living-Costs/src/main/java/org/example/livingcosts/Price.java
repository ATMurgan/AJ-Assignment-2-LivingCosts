package org.example.livingcosts;

import com.google.gson.annotations.SerializedName;

public class Price {

    // Field for item name
    @SerializedName("item_name")
    private String itemName;

    // Field for category name
    @SerializedName("category_name")
    private String categoryName;

    // Field for minimum value
    @SerializedName("min")
    private double min;

    // Field for average value
    @SerializedName("avg")
    private double avg;

    // Field for maximum value
    @SerializedName("max")
    private double max;

    // Field for measure
    @SerializedName("measure")
    private String measure;

    // Field for currency code
    @SerializedName("currency_code")
    private String currencyCode;

    @SerializedName("good_id")
    private int goodId;

    // Constructor to initialize the fields
    public Price(String itemName, String categoryName, double min, double avg, double max, String measure, String currencyCode, int goodId) {
        this.itemName = itemName;
        this.categoryName = categoryName;
        this.min = min;
        this.avg = avg;
        this.max = max;
        this.measure = measure;
        this.currencyCode = currencyCode;
        this.goodId = goodId;
    }

    // Getters and Setters for each field
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
    public int getGoodId() {
        return goodId;
    }
    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    @Override
    public String toString() {
        return "Price{" +
                "itemName='" + itemName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", min=" + min +
                ", avg=" + avg +
                ", max=" + max +
                ", measure='" + measure + '\'' +
                ", currencyCode='" + currencyCode + '\'' +
                '}';
    }

}
