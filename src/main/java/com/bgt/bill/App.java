package com.bgt.bill;

import com.bgt.bill.controller.TabController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/com/bgt/bill/main.fxml"));
//        VBox load = fxmlLoader.load();
//        TabPane lookup = (TabPane) load.lookup("#tabPane");
//        lookup.getTabs().get(0).setContent(new Button("sssssssss"));
//
//        Scene scene = new Scene(load, 600, 900);
//        stage.setTitle("记账本!");
//        stage.setScene(scene);
//        stage.show();


        // 创建 TabPane
        TabPane tabPane = new TabPane();

        // 创建三个 Tab 并添加到 TabPane 中
        Tab tab1 = createTab("明细", "/com/bgt/bill/bill.fxml");
        Tab tab2 = createTab("统计", "/com/bgt/bill/statistics.fxml");
        Tab tab3 = createTab("设置", "/com/bgt/bill/setup.fxml");

        tabPane.getTabs().addAll(tab1, tab2, tab3);

        Scene scene = new Scene(tabPane, 600, 900);
        stage.setTitle("记账本!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    private Tab createTab(String tabTitle, String fxmlPath) throws IOException {
        Tab tab = new Tab(tabTitle);
        // 加载 FXML 文件并设置为 Tab 的内容
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        tab.setContent(loader.load());

        // 获取控制器实例并调用加载数据的方法
        Object controller = loader.getController();
        if (controller instanceof TabController) {
            ((TabController) controller).loadData();
        }
        return tab;
    }
}