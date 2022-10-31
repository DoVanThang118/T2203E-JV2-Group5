package rentcar.customer.create;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import rentcar.Main;
import rentcar.dao.impls.CustomerRepository;
import rentcar.dao.impls.CustomerRepository;
import rentcar.entities.Car;
import rentcar.helper.Connector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CarCreateController {
    public TextField txtName;
    public TextField txtAuthor;
    public TextField txtQty;

    public void submit(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String author = txtAuthor.getText();
            Integer qty = Integer.parseInt(txtQty.getText());
            Car car = new Car(null,name,author,qty);
            CustomerRepository rp = new CustomerRepository();
            if(rp.create(car)){
                backToList();
            }else {
                System.out.println("Error");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void backToList() throws Exception{
        Parent listBook = FXMLLoader.load(getClass().getResource("../list/list.fxml"));
        Main.rootStage.setTitle("Cars");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }
}