module edu.bsu.cs.finalproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires org.apache.logging.log4j;


    opens edu.bsu.cs.finalproject to javafx.fxml;
    exports edu.bsu.cs.finalproject;

}