package rentcar.car.list;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import rentcar.Main;
import rentcar.entities.Car;

import java.net.URL;
import java.util.ResourceBundle;

public class ListCarController  implements Initializable {
        public TableView <Car> tbCars;
        public TableColumn <Car,Integer> cId;
        public TableColumn<Car,String> cName;
        public TableColumn<Car,String> cBrand;
        public TableColumn<Car,Integer> cSeat;
        public TableColumn<Car,Integer> cPrice;
        public TableColumn<Car,Integer> cQty;



    public void backtoMenu(ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("/rentcar/home.fxml"));
        Main.rootStage.setTitle("Home");

        Main.rootStage.setScene(new Scene(listBook,800,600));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cId.setCellValueFactory(new );



    }
}
