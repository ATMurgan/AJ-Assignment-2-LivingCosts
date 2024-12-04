package org.example.livingcosts;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("search-country.fxml"));
        AnchorPane root = fxmlLoader.load();
        stage.setTitle("Welcome to Cost of Living!");
        stage.getIcons().add(new Image("file:icon.jpg"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {launch();}

}