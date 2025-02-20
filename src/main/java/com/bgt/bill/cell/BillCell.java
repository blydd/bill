package com.bgt.bill.cell;

import com.bgt.bill.vo.BillDay;
import com.bgt.bill.vo.BillDetail;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;

/**
 * @author: bgt
 * @Date: 2025/2/5 14:52
 * @Desc: 每日账单,含日期\日总收支额\日账单列表详情
 */
public class BillCell extends ListCell<BillDay> {

    private List<BillDay> datas;
    //通过构造方法把数据传来
    public BillCell(List<BillDay> datas) {
        this.datas = datas;
    }

    @Override
    protected void updateItem(BillDay billDay, boolean empty) {
        super.updateItem(billDay, empty);
        if (empty || billDay == null) {
            setGraphic(null);
        } else {
            try {
                //创建一个父容器，将两个 FXML 文件的根节点添加到父容器中
                VBox mainRoot = new VBox();
                /*每日统计*/
                FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/com/bgt/bill/billListView.fxml"));
                BorderPane dayView = loader1.load();
                //根据id获取元素
                //日期
                ((Label) dayView.lookup("#date")).setText(billDay.getDate());
                //日总支出
                ((Label) dayView.lookup("#dayTotalOut")).setText(String.valueOf(billDay.getDayTotalOut()));;
                //日总收入
                ((Label) dayView.lookup("#dayTotalIn")).setText(String.valueOf(billDay.getDayTotalIn()));;
                mainRoot.getChildren().addAll(dayView);

                /*再使用一个listView展示每日账单列表*/
                ObservableList<BillDetail> observableBillList = FXCollections.observableArrayList(billDay.getBillDetailList());
                ListView billsDetail = (ListView) dayView.lookup("#billsDetail");
                billsDetail.getItems().addAll(observableBillList);
                billsDetail.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                billsDetail.setCellFactory(d->new BillDetailCell(billDay.getBillDetailList()));


                //添加每日账单列表
                mainRoot.getChildren().addAll(billsDetail);
                setGraphic(mainRoot);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
