package rentcar.customer.edit;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import rentcar.Main;
import rentcar.dao.impls.CustomerRepository;
import rentcar.entities.Customer;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class EditCustomerController implements Initializable {
    public TextField txtName;
    public TextField txtCmt;
    public TextField txtTel;
    public TextField txtEmail;
    public TextField txtAddress;

    public static Customer editedCustomer;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(editedCustomer != null){
            txtName.setText(editedCustomer.getName());
            txtCmt.setText(editedCustomer.getCmt());
            txtTel.setText(editedCustomer.getTel());
            txtEmail.setText(editedCustomer.getEmail());
            txtAddress.setText(editedCustomer.getAddress());
        }

    }
    public void submit(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String cmt = txtCmt.getText();
            String tel = txtTel.getText();
            String email = txtEmail.getText();
            String address = txtAddress.getText();

            editedCustomer.setName(name);
            editedCustomer.setCmt(cmt);
            editedCustomer.setTel(tel);
            editedCustomer.setEmail(email);
            editedCustomer.setAddress(address);

            CustomerRepository rp = new CustomerRepository();
            if(rp.update(editedCustomer)){
                backtoList(null);
            }else {
                System.out.println("Error");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void backtoList(ActionEvent actionEvent) throws Exception{
        Parent edit = FXMLLoader.load(getClass().getResource("../list/listCustomer.fxml"));
        Main.rootStage.setTitle("edit");
        Main.rootStage.setScene(new Scene(edit,800,600));
    }
    public void delete(ActionEvent event) {
        try{
            Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Customer?");
            alert.setHeaderText("Are you sure delete customer: "+editedCustomer.getName());
            Optional<ButtonType> option = alert.showAndWait();

            if(option.get() == ButtonType.OK){
                CustomerRepository rp = new CustomerRepository();
                if(rp.delete(editedCustomer)){
                    backtoList(null);
                }else {
                    System.out.println("Error");
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


}