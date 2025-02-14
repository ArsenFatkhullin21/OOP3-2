module ru.arsen.oop32 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.arsen.oop32 to javafx.fxml;
    exports ru.arsen.oop32;
}