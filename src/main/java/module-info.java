module com.example.batallademarycoral {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.batallademarycoral to javafx.fxml;
    exports com.example.batallademarycoral;
}