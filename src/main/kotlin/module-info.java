module com.example.javafx_weather {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires org.json;
    requires com.google.gson;


    opens com.example.javafx_weather to javafx.fxml;
    exports com.example.javafx_weather;
}