package rentcar.customer.list;

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
import sun.applet.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class CarListController implements Initializable {
    public TableView<Car> tbCars;
    public TableColumn<Car,Integer> tdId;
    public TableColumn<Car,String> tdName;
    public TableColumn<Car,String> tdAuthor;
    public TableColumn<Car,Integer> tdQty;
    public TableColumn<Car, Button> tdEdit;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tdId.setCellValueFactory(new PropertyValueFactory<Car,Integer>("id"));
        tdName.setCellValueFactory(new PropertyValueFactory<Car,String>("name"));
        tdAuthor.setCellValueFactory(new PropertyValueFactory<Car,String>("author"));
        tdQty.setCellValueFactory(new PropertyValueFactory<Car,Integer>("qty"));
        tdEdit.setCellValueFactory(new PropertyValueFactory<Car,Button>("edit"));

        ObservableList<Car> ls = FXCollections.observableArrayList();
        CarRepository rp = (CarRepository)RepositoryFactory.createRepository(RepoType.CAR);
        ls.addAll(rp.all());
        tbCars.setItems(ls);
    }

    public void createNewCar(ActionEvent actionEvent)  throws Exception{
        Parent listCar = FXMLLoader.load(getClass().getResource("../create/create.fxml"));
        Main.rootStage.setTitle("Cars");
        Main.rootStage.setScene(new Scene(listCar,800,600));
    }
}