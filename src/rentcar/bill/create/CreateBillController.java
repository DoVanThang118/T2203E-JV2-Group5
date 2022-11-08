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
import javafx.scene.text.Text;
import rentcar.Main;
import rentcar.dao.impls.BillRepository;
import rentcar.dao.impls.CarRepository;
import rentcar.dao.impls.CocRepository;
import rentcar.dao.impls.CustomerRepository;
import rentcar.entities.Bill;
import rentcar.entities.Car;
import rentcar.entities.Coc;
import rentcar.entities.Customer;

import java.net.URL;
import java.sql.Date;
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
    public Text error;
    public ComboBox<Customer> cbCustomer;
    public ComboBox<Car> cbCar;

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

        CustomerRepository customerRepository = new CustomerRepository();
        ObservableList<Customer> customers = FXCollections.observableArrayList();
        customers.addAll(customerRepository.all());
        cbCustomer.setItems(customers);


        CarRepository carRepository = new CarRepository();
        ObservableList<Car> cars = FXCollections.observableArrayList();
        cars.addAll(carRepository.freeCar());
        cbCar.setItems(cars);

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
//            error.setVisible(false);
//            if(Integer.parseInt(txtCustomerId.getText()) <=0 ||
//                    txtCustomer.getText().isEmpty() ||
//                    txtCmt.getText().isEmpty() ||
//                    txtTel.getText().isEmpty() ||
//                    txtEmail.getText().isEmpty() ||
//                    txtAddress.getText().isEmpty() ||
//                    Integer.parseInt(txtCar.getText())<=0 ||
//                    Integer.parseInt(txtBrand.getText())<=0 ||
//                    Integer.parseInt(txtSeat.getText())<=0 ||
//                    txtCar.getText().isEmpty() ||
//                    txtNumber.getText().isEmpty() ||
//                    txtPrice.getText().isEmpty()){
//                throw new Exception("Vui Lòng Nhập Đầy Đủ Các Thông Tin !!!!");
//            }

            Customer customer = cbCustomer.getSelectionModel().getSelectedItem();
            Car car = cbCar.getSelectionModel().getSelectedItem();
            Date date = Date.valueOf(txtDate.getValue());
            Date exp = Date.valueOf(txtExp.getValue());
            Integer deposits = Integer.parseInt(txtCoc.getText());
            Coc coc = cbCoc.getSelectionModel().getSelectedItem();

            Bill bill = new Bill(null,car.getId(),customer.getId(),date,exp,deposits, coc.getId(),null);
            BillRepository billRepository = new BillRepository();


            if (billRepository.create(bill)){
                billRepository.update(bill);
                backToList();
            }else {
                System.out.println("ERROR");
            }
        }
        catch (Exception e){
//            error.setVisible(true);
        }
    }

    public void payment(ActionEvent actionEvent) {
        try {
            error.setVisible(false);
            if(Integer.parseInt(txtCustomerId.getText()) <=0 ||
                    txtCustomer.getText().isEmpty() ||
                    txtCmt.getText().isEmpty() ||
                    txtTel.getText().isEmpty() ||
                    txtEmail.getText().isEmpty() ||
                    txtAddress.getText().isEmpty() ||
                    Integer.parseInt(txtCar.getText())<=0 ||
                    Integer.parseInt(txtBrand.getText())<=0 ||
                    Integer.parseInt(txtSeat.getText())<=0 ||
                    txtCar.getText().isEmpty() ||
                    txtNumber.getText().isEmpty() ||
                    txtPrice.getText().isEmpty()){
                throw new Exception("Vui Lòng Nhập Đầy Đủ Các Thông Tin !!!!");
            }
            addBill(null);

            Parent listCustomer = FXMLLoader.load(getClass().getResource("../payment/payment.fxml"));
            Main.rootStage.setTitle("Payment");
            Main.rootStage.setScene(new Scene(listCustomer,800,600));
        }
        catch (Exception e){
            error.setVisible(true);
        }
    }


    public void choose(ActionEvent actionEvent) {
        Customer c = cbCustomer.getSelectionModel().getSelectedItem();
        txtCustomerId.setText(c.getId().toString());
        txtCustomer.setText(c.getName());
        txtCmt.setText(c.getCmt());
        txtTel.setText(c.getTel());
        txtEmail.setText(c.getEmail());
        txtAddress.setText(c.getAddress());
    }

    public void chooseCar(ActionEvent actionEvent) {
        Car car = cbCar.getSelectionModel().getSelectedItem();
        txtCarId.setText(car.getId().toString());
        txtCar.setText(car.getName());
        txtBrand.setText(car.getBrand());
        txtSeat.setText(car.getSeat().toString());
        txtPrice.setText(car.getPrice().toString());
        txtNumber.setText(car.getNumber());
    }
}
