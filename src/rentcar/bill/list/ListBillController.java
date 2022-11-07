package rentcar.bill.list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import rentcar.Main;
import rentcar.dao.impls.BillRepository;
import rentcar.entities.Bill;
import rentcar.enums.RepoType;
import rentcar.factory.RepositoryFactory;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class ListBillController implements Initializable {

    public TableView<Bill> tbBill;
    public TableColumn<Bill,Integer> cId;
    public TableColumn<Bill,Integer> cCustomer;
    public TableColumn<Bill,Integer> cCar;
    public TableColumn<Bill, Date> cRent;
    public TableColumn<Bill,Date> cExp;
    public TableColumn<Bill,Integer> cDeposits;
    public TableColumn<Bill,Integer> cCoc;

    public void backToMenu(ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("../../home.fxml"));
        Main.rootStage.setTitle("Home");

        Main.rootStage.setScene(new Scene(listBook,800,600));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cId.setCellValueFactory(new PropertyValueFactory<>("id"));
        cCar.setCellValueFactory(new PropertyValueFactory<>("carId"));
        cCustomer.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        cRent.setCellValueFactory(new PropertyValueFactory<>("rentDate"));
        cExp.setCellValueFactory(new PropertyValueFactory<>("expDate"));
        cDeposits.setCellValueFactory(new PropertyValueFactory<>("deposits"));
        cCoc.setCellValueFactory(new PropertyValueFactory<>("cocId"));

//        ObservableList<Bill> list = FXCollections.observableArrayList();
////        BillRepository bill =(BillRepository) RepositoryFactory.createRepository(RepoType.BILL);
////        list.addAll(bill.all());
////        tbBill.setItems(list);
        BillRepository bill = (BillRepository) RepositoryFactory.createRepository(RepoType.BILL);
        tbBill.getItems().addAll(bill.all());

    }
}
