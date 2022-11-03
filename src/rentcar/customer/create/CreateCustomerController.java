package rentcar.customer.create;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import rentcar.Main;
import rentcar.dao.impls.CustomerRepository;
import rentcar.entities.Customer;

public class CreateCustomerController {
    public TextField txtName;
    public TextField txtCmt;
    public TextField txtTel;
    public TextField txtEmail;
    public TextField txtAddress;

    public void add(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String cmt = txtCmt.getText();
            String tel = txtTel.getText();
            String email = txtEmail.getText();
            String address = txtAddress.getText();
            Customer customer = new Customer(null,name,cmt,tel,email,address);
            CustomerRepository customerRepository = new CustomerRepository();
            if (customerRepository.create(customer)){
                backToList();
            }else {
                System.out.println("ERROR");
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void backToList() throws Exception {
        Parent listCustomer = FXMLLoader.load(getClass().getResource("../list/listCustomer.fxml"));
        Main.rootStage.setTitle("List Customer");
        Main.rootStage.setScene(new Scene(listCustomer,800,600));
    }
}
