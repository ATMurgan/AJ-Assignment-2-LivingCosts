module org.example.livingcosts {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires com.google.gson;
    requires java.net.http;
    requires java.sql;


    opens org.example.livingcosts to javafx.fxml,com.google.gson;
    exports org.example.livingcosts;
}