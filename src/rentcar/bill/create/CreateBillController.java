package rentcar.bill.create;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import rentcar.Main;
import rentcar.dao.impls.BillRepository;
import rentcar.dao.impls.CocRepository;
import rentcar.dao.impls.CustomerRepository;
import rentcar.entities.Bill;
import rentcar.entities.Car;
import rentcar.entities.Coc;
import rentcar.entities.Customer;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class CreateBillController implements Initializable {
    public static Car createBillToCar;
    public static Customer createBillToCustomer;

    public TextField txtCustomer;
    public TextField txtCmt;
    public TextField txtTel;
    public TextField txtEmail;
    public TextField txtAddress;
    public TextField txtCar;
    public TextField txtBrand;
    public TextField txtSeat;
    public TextField txtPrice;
    public DatePicker txtDate;
    public TextField txtNumber;
    public DatePicker txtExp;
    public TextField txtCoc;
    public ComboBox<Coc> cbCoc;
    public TextField txtCustomerId;
    public TextField txtCarId;

    public void backToMenu(ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("../../home.fxml"));
        Main.rootStage.setTitle("Home");

        Main.rootStage.setScene(new Scene(listBook,800,600));
    }

    public void initialize(URL location, ResourceBundle resources) {
        if(createBillToCustomer != null){
            txtCustomerId.setText(createBillToCustomer.getId().toString());
            txtCustomer.setText(createBillToCustomer.getName());
            txtCmt.setText(createBillToCustomer.getCmt());
            txtTel.setText(createBillToCustomer.getTel());
            txtEmail.setText(createBillToCustomer.getEmail());
            txtAddress.setText(createBillToCustomer.getAddress());
        }
        if(createBillToCar != null){
            txtCarId.setText(createBillToCar.getId().toString());
            txtCar.setText(createBillToCar.getName());
            txtBrand.setText(createBillToCar.getBrand());
            txtSeat.setText(createBillToCar.getSeat().toString());
            txtPrice.setText(createBillToCar.getPrice().toString());
            txtNumber.setText(createBillToCar.getNumber());
        }

        CocRepository cocRepository = new CocRepository();
        ObservableList<Coc> list = FXCollections.observableArrayList();
        list.addAll(cocRepository.all());
        cbCoc.setItems(list);
    }
    public void backToList() throws Exception {
        Parent listCustomer = FXMLLoader.load(getClass().getResource("../list/listBill.fxml"));
        Main.rootStage.setTitle("List Bill");
        Main.rootStage.setScene(new Scene(listCustomer,800,600));
    }
    public void addBill(ActionEvent actionEvent) {
        try {
            Integer customerId = Integer.parseInt(txtCustomerId.getText());
            Integer carId = Integer.parseInt(txtCarId.getText());
            LocalDate date = txtDate.getValue();
            LocalDate exp = txtExp.getValue();
            Integer deposits = Integer.parseInt(txtCoc.getText());
            Coc coc = cbCoc.getSelectionModel().getSelectedItem();

            Bill bill = new Bill(null,customerId,carId,toString(date),toString(exp),deposits,coc.getId());
            BillRepository billRepository = new BillRepository();

            if (billRepository.create(bill)){
                backToList();
            }else {
                System.out.println("ERROR");
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private Date toString(LocalDate date) {
        return null;
    }

    public void payment(ActionEvent actionEvent) {
    }
}
