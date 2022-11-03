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
import rentcar.dao.impls.CustomerRepository;
import rentcar.entities.Customer;
import rentcar.enums.RepoType;
import rentcar.factory.RepositoryFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ListCustomerController implements Initializable {
    public TableView<Customer> tbCustomer;
    public TableColumn<Customer,Integer> cId;
    public TableColumn<Customer,String> cName;
    public TableColumn<Customer,Integer> cCmt;
    public TableColumn<Customer,Integer> cTel;
    public TableColumn<Customer,String> cEmail;
    public TableColumn<Customer,String> cAddress;
    public TableColumn<Customer, Button> cAction;
    public TableColumn<Customer,Button> cEdit;

    public void backToMenu(ActionEvent actionEvent) throws Exception {
        Parent menu = FXMLLoader.load(getClass().getResource("../../home.fxml"));
        Main.rootStage.setTitle("Menu");
        Main.rootStage.setScene(new Scene(menu,800,600));
    }

    public void goToCreate(ActionEvent actionEvent) throws Exception {
        Parent add = FXMLLoader.load(getClass().getResource("../create/createCustomer.fxml"));
        Main.rootStage.setTitle("Add Customer");
        Main.rootStage.setScene(new Scene(add,800,600));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cId.setCellValueFactory(new PropertyValueFactory<Customer,Integer>("id"));
        cName.setCellValueFactory(new PropertyValueFactory<Customer,String>("name"));
        cCmt.setCellValueFactory(new PropertyValueFactory<Customer,Integer>("cmt"));
        cTel.setCellValueFactory(new PropertyValueFactory<Customer,Integer>("tel"));
        cEmail.setCellValueFactory(new PropertyValueFactory<Customer,String>("email"));
        cAddress.setCellValueFactory(new PropertyValueFactory<Customer,String>("address"));
        cAction.setCellValueFactory(new PropertyValueFactory<Customer,Button>("action"));
        cEdit.setCellValueFactory(new PropertyValueFactory<Customer,Button>("edit"));

        ObservableList<Customer> ls = FXCollections.observableArrayList();

        CustomerRepository customerRepository = (CustomerRepository) RepositoryFactory.createRepository(RepoType.CUSTOMER);
        ls.addAll(customerRepository.all());
        tbCustomer.setItems(ls);
    }
}
