module com.bgt.bill {
    requires javafx.controls;
    requires javafx.fxml;
//    requires com.zaxxer.hikari;
//    requires java.sql;
//    requires com.h2database;
    requires javafx.graphics;


    opens com.bgt.bill to javafx.fxml;
    exports com.bgt.bill;
    exports com.bgt.bill.vo;
    opens com.bgt.bill.vo to javafx.fxml;
    exports com.bgt.bill.cell;
    opens com.bgt.bill.cell to javafx.fxml;
    exports com.bgt.bill.controller;
    opens com.bgt.bill.controller to javafx.fxml;
}