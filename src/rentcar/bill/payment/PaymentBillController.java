package rentcar.bill.payment;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import rentcar.Main;
import rentcar.dao.impls.BillRepository;
import rentcar.dao.impls.CarRepository;
import rentcar.dao.impls.CocRepository;
import rentcar.dao.impls.CustomerRepository;
import rentcar.entities.Bill;
import rentcar.entities.Car;
import rentcar.entities.Coc;
import rentcar.entities.Customer;
import rentcar.enums.RepoType;
import rentcar.factory.RepositoryFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class PaymentBillController implements Initializable {
    public static Bill paymentBill;
    public TextField txtDate;
    public TextField txtExp;
    public TextField txtCoc;
    public TextField txtCustomerId;
    public TextField txtCarId;
    public TextField txtDeposits;
    public TextField txtCustomer;
    public TextField txtCmt;
    public TextField txtTel;
    public TextField txtEmail;
    public TextField txtAddress;
    public TextField txtCar;
    public TextField txtBrand;
    public TextField txtSeat;
    public TextField txtPrice;
    public TextField txtNumber;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (paymentBill != null){
            txtCustomerId.setText(paymentBill.getCustomerId().toString());
            Customer cus = ((CustomerRepository) RepositoryFactory.createRepository(RepoType.CUSTOMER)).findOne(paymentBill.getCustomerId());
            txtCustomer.setText(cus.getName());
            txtCmt.setText(cus.getCmt());
            txtTel.setText(cus.getTel());
            txtEmail.setText(cus.getEmail());
            txtAddress.setText(cus.getAddress());
            txtCarId.setText(paymentBill.getId().toString());
            Car car = ((CarRepository) RepositoryFactory.createRepository(RepoType.CAR)).findOne(paymentBill.getCarId());
            txtCar.setText(car.getName());
            txtBrand.setText(car.getBrand());
            txtSeat.setText(car.getSeat().toString());
            txtPrice.setText(car.getPrice().toString());
            txtNumber.setText(car.getNumber());
            txtDate.setText(paymentBill.getDate().toString());
            txtExp.setText(paymentBill.getExp().toString());
            txtDeposits.setText(paymentBill.getDeposits().toString());
            Coc coc = ((CocRepository) RepositoryFactory.createRepository(RepoType.Coc)).findOne(paymentBill.getCocId());
            txtCoc.setText(paymentBill.getNameCoc());

        }
    }

    public void payment(ActionEvent actionEvent) throws Exception {
        BillRepository bill = new BillRepository();
        bill.updatePay(paymentBill);
        backToList();
    }

    public void backToList() throws Exception {
        Parent listCustomer = FXMLLoader.load(getClass().getResource("../list/listBill.fxml"));
        Main.rootStage.setTitle("List Customer");
        Main.rootStage.setScene(new Scene(listCustomer,800,600));
    }
}
