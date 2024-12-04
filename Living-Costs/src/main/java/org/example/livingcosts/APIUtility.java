package org.example.livingcosts;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class APIUtility {

    public static APIResponse getCountryFromJSON(String fileName){

        Gson gson = new Gson();
        APIResponse country = null;

        try(
                FileReader fileReader = new FileReader(fileName);
                JsonReader jsonReader = new JsonReader(fileReader);
                ) {

            country = gson.fromJson(jsonReader, APIResponse.class);

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(country);
        return country;
    }


    public static APIResponse getCity(String searchTerm){
        searchTerm = searchTerm.replace(" ", "%20");

        String uri = "https://cost-of-living-and-prices.p.rapidapi.com/cities?country_name=" + searchTerm;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("x-rapidapi-key", "8f61547b8fmsh0314dace005dd80p1a2dd9jsn6a132c20f7c1")
                .header("x-rapidapi-host", "cost-of-living-and-prices.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            String fileName = "javaAPIFetched.json";
            Files.write(Paths.get(fileName), responseBody.getBytes());

            return getCountryFromJSON(fileName);

        } catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }


    public static APIResponse getCountry(String cityName, String countryName){
        cityName = cityName.replace(" ", "%20");
        countryName = countryName.replace(" ", "%20");

        String uri = "https://cost-of-living-and-prices.p.rapidapi.com/prices?city_name=" + cityName + "&country_name=" + countryName;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("x-rapidapi-key", "8f61547b8fmsh0314dace005dd80p1a2dd9jsn6a132c20f7c1")
                .header("x-rapidapi-host", "cost-of-living-and-prices.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            String fileName = "javaAPIFetched.json";
            Files.write(Paths.get(fileName), responseBody.getBytes());

            return getCountryFromJSON(fileName);

        } catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

}




