package com.bgt.bill.controller;

import com.bgt.bill.cell.BillCell;
//import com.bgt.bill.dao.UserDao;
import com.bgt.bill.util.TestUtil;
import com.bgt.bill.vo.BillDay;
import com.bgt.bill.vo.BillDetail;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class BillController implements TabController{

//    private UserDao userDao = new UserDao();
    @FXML
    private ListView billsListView;
    //测试数据
    private List<BillDay> datas = new ArrayList<>();
    @FXML
    private void addBillAction() {

    }

    @Override
    public void loadData() {
        datas = TestUtil.getDatas();
        // 创建一个 ObservableList 并添加集合元素
        ObservableList<BillDay> observableBillList = FXCollections.observableArrayList(datas);
        billsListView.getItems().addAll(observableBillList);
        //设置每行都可选择
        billsListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        billsListView.setCellFactory(d -> new BillCell(datas));
    }
}