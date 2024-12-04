package org.example.livingcosts;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class CountryDetailsController implements Initializable {

    @FXML
    private Button backButton;

    @FXML
    private Label countryName;

    @FXML
    private Label cityId;

    @FXML
    private Label cityName;

    @FXML
    private Label latId;

    @FXML
    private Label lngId;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private Label priceDetailsLabel;

    @FXML
    private Label priceDetailsLabel2;

    private City selectedCity;

    private Country selectedCountry;

    // Sends user back to search country page
    @FXML
    void BackToSearch(ActionEvent event) {
        switchToPage("search-country.fxml");
    }

    // Gets new fxml file to swap to
    private void switchToPage(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            AnchorPane newPage = loader.load();

            Stage stage = (Stage) mainPane.getScene().getWindow();
            Scene scene = new Scene(newPage);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Takes all city info from API and prints to fxml page
    public void setCityDetails(City city, String countrySearchTerm) {
        this.selectedCity = city;

        // Sends city and country name to api
        APIResponse apiResponse = APIUtility.getCountry(city.getCityName(), countrySearchTerm);

        if (apiResponse != null && apiResponse.isCountryResponse()) {
            Country countryDetails = new Country(
                    apiResponse.getCityId(),
                    apiResponse.getCityName(),
                    apiResponse.getCountryName(),
                    apiResponse.getPrices()
            );

            // Adds basic city info to display
            countryName.setText(countryDetails.getCountryName());
            cityName.setText(city.getCityName());
            cityId.setText("City ID: " + city.getCityId());
            latId.setText("Latitude: " + city.getLatitude());
            lngId.setText("Longitude: " + city.getLongitude());

            // Display price details
            displayPriceDetails(countryDetails);
        }
    }

    // Displays all price related data in groups
    private void displayPriceDetails(Country countryDetails) {
        List<Integer> selectedGoodIds = Arrays.asList(28,29,38,40);
        StringBuilder priceDetails = new StringBuilder();

        List<Integer> selectedGoodIds2 = Arrays.asList(45,47,54,55);
        StringBuilder priceDetails2 = new StringBuilder();

        for (Price price : countryDetails.getPrices()) {
            if (selectedGoodIds.contains(price.getGoodId())) {
                priceDetails.append(price.getItemName()).append("\n");
                priceDetails.append("Category: ").append(price.getCategoryName()).append("\n");
                priceDetails.append("Average Price: ").append(price.getAvg()).append(" ").append(price.getCurrencyCode()).append("\n");
                priceDetails.append("Min Price: ").append(price.getMin()).append(" ").append(price.getCurrencyCode()).append("\n");
                priceDetails.append("Max Price: ").append(price.getMax()).append(" ").append(price.getCurrencyCode()).append("\n\n");
            }
        }

        for (Price price : countryDetails.getPrices()) {
            if (selectedGoodIds2.contains(price.getGoodId())) {
                priceDetails2.append(price.getItemName()).append("\n");
                priceDetails2.append("Category: ").append(price.getCategoryName()).append("\n");
                priceDetails2.append("Average Price: ").append(price.getAvg()).append(" ").append(price.getCurrencyCode()).append("\n");
                priceDetails2.append("Min Price: ").append(price.getMin()).append(" ").append(price.getCurrencyCode()).append("\n");
                priceDetails2.append("Max Price: ").append(price.getMax()).append(" ").append(price.getCurrencyCode()).append("\n\n");
            }
        }

        priceDetailsLabel.setText(priceDetails.toString());
        priceDetailsLabel2.setText(priceDetails2.toString());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {}
}

