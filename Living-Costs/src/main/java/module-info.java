module org.example.livingcosts {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.livingcosts to javafx.fxml;
    exports org.example.livingcosts;
}