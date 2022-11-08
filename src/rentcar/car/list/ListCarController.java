package rentcar.car.list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import rentcar.Main;
import rentcar.dao.impls.CarRepository;
import rentcar.entities.Car;
import rentcar.enums.RepoType;
import rentcar.factory.RepositoryFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ListCarController  implements Initializable {
    public TableView <Car> tbCars;
    public TableColumn <Car,Integer> cId;
    public TableColumn<Car,String> cName;
    public TableColumn<Car,String> cBrand;
    public TableColumn<Car,Integer> cSeat;
    public TableColumn<Car,Integer> cPrice;
    public TableColumn<Car,String> cNumber;
    public TableColumn<Car, Button> cAction;
    public TableColumn<Car,String> cStatus;


    public void backToMenu(ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("../../home.fxml"));
        Main.rootStage.setTitle("Home");

        Main.rootStage.setScene(new Scene(listBook,800,600));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cId.setCellValueFactory(new PropertyValueFactory<Car,Integer>("id"));
        cName.setCellValueFactory(new PropertyValueFactory<Car,String>("name"));
        cBrand.setCellValueFactory(new PropertyValueFactory<Car,String>("brand"));
        cSeat.setCellValueFactory(new PropertyValueFactory<Car,Integer>("seat"));
        cPrice.setCellValueFactory(new PropertyValueFactory<Car,Integer>("price"));
        cNumber.setCellValueFactory(new PropertyValueFactory<Car,String>("number"));
        cStatus.setCellValueFactory(new PropertyValueFactory<Car,String>("statusLabel"));
        cAction.setCellValueFactory(new PropertyValueFactory<Car,Button>("action"));

        ObservableList<Car> ls = FXCollections.observableArrayList();

        CarRepository carRepository = (CarRepository) RepositoryFactory.createRepository(RepoType.CAR);
        ls.addAll(carRepository.all());
        tbCars.setItems(ls);
    }
}
