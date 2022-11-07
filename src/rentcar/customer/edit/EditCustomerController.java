package rentcar.customer.edit;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import rentcar.dao.impls.CarRepository;
import rentcar.entities.Car;
import sun.applet.Main;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class CarEditController implements Initializable {
    public TextField txtName;
    public TextField txtAuthor;
    public TextField txtQty;

    public static Car editedCar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(editedCar != null){
            txtName.setText(editedCar.getName());
            txtAuthor.setText(editedCar.getAuthor());
            txtQty.setText(editedCar.getQty().toString());
        }
    }

    public void submit(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String author = txtAuthor.getText();
            Integer qty = Integer.parseInt(txtQty.getText());
            editedCar.setName(name);
            editedCar.setAuthor(author);
            editedCar.setQty(qty);
            CarRepository rp = new CarRepository();
            if(rp.update(editedCar)){
                backToList(null);
            }else {
                System.out.println("Error");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void backToList(ActionEvent actionEvent) throws Exception{
        Parent listBook = FXMLLoader.load(getClass().getResource("../list/list.fxml"));
        Main.rootStage.setTitle("Cars");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }

    public void delete(ActionEvent event) {
        try{
            Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Book?");
            alert.setHeaderText("Are you sure delete book: "+editedCar.getName());
            Optional<ButtonType> option = alert.showAndWait();

            if(option.get() == ButtonType.OK){
                CarRepository rp = new CarRepository();
                if(rp.delete(editedCar)){
                    backToList(null);
                }else {
                    System.out.println("Error");
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}