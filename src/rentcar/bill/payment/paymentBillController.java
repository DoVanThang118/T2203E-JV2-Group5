package rentcar.bill.payment;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import rentcar.bill.create.CreateBillController;

import java.net.URL;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;

public class paymentBillController implements Initializable {
    public TextField txtRentDate;
    public TextField txtExpDate;
    public TextField txtRentNumber;
    public TextField txtDeposits;
    public TextField txtMoney;
    public TextField txtPriceDay;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

//    long b = ChronoUnit.DAYS.between(date,date1);
    public void pay(ActionEvent actionEvent) {
    }
}
