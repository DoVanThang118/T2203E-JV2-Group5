package rentcar;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class HomeController {
    public void goToCar(ActionEvent actionEvent) throws Exception {
        Parent listCar = FXMLLoader.load(getClass().getResource("car/list/listCar.fxml"));
        Main.rootStage.setTitle("List Car");
        Main.rootStage.setScene(new Scene(listCar,800,600));
    }

    public void goToCustomer(ActionEvent actionEvent) throws Exception {
        Parent listCustomer = FXMLLoader.load(getClass().getResource("customer/list/listCustomer.fxml"));
        Main.rootStage.setTitle("List Customer");
        Main.rootStage.setScene(new Scene(listCustomer,800,600));
    }

    public void goToBill(ActionEvent actionEvent) throws Exception {
        Parent listBill = FXMLLoader.load(getClass().getResource("bill/list/listBill.fxml"));
        Main.rootStage.setTitle("List Bill");
        Main.rootStage.setScene(new Scene(listBill,800,600));
    }
}
