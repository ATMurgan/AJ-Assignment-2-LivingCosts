package org.example.livingcosts;

import com.google.gson.Gson;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SearchCountryController implements Initializable {

    @FXML
    private TableView<City> countryCol;

    @FXML
    private TableColumn<City, String> cityNameCol;

    @FXML
    private TextField countryInput;

    @FXML
    private Button searchCountryB;

    @FXML
    private Button selectCityB;

    @FXML
    private AnchorPane mainPane;

    private ObservableList<City> cityList  = FXCollections.observableArrayList();

    private City selectedCity;

    private String selectedCountry;


    // Button to send user to country detail page about selected city
    @FXML
    void findCity(ActionEvent event) {
        if (selectedCity != null) {
            switchToPage("country-details.fxml");
        } else {
            System.out.println("No city selected!");
        }
    }


    // Gets all the cities with the country name associated
    @FXML
    void searchCountry(ActionEvent event) {
        String countrySearchTerm = countryInput.getText().trim();
        selectedCountry = countrySearchTerm;

        if (!countrySearchTerm.isEmpty()) {
            APIResponse apiResponse = APIUtility.getCity(countrySearchTerm);
            if (apiResponse != null) {
                // Filter cities by country and populate the table
                cityList.clear();
                for (City city : apiResponse.getCities()) {
                    // Add city to list if country matches the search term
                    if (city.getCountryName().equalsIgnoreCase(countrySearchTerm)) {
                        cityList.add(city);
                    }
                }

                countryCol.setItems(cityList);
            }
            else {
                System.out.println("No data found for the country: " + countrySearchTerm);
            }
        }
    }

    // Gets new fxml file to swap to
    private void switchToPage(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            AnchorPane newPage = loader.load();

            CountryDetailsController controller = loader.getController();

            // Pass selected city & country to the new controller
            if (selectedCity != null) {
                controller.setCityDetails(selectedCity, selectedCountry);
            }

            Stage stage = (Stage) mainPane.getScene().getWindow();
            Scene scene = new Scene(newPage);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Prints all city names onto the table view and gets the value of selected city
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        cityNameCol.setCellValueFactory(new PropertyValueFactory<>("cityName"));

        countryCol.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedCity = newValue;
        });
    }
}
