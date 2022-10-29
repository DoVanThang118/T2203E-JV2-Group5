package rentcar;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class HomeController {
    public void goToBookList(ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("customer/list/list.fxml"));
        Main.rootStage.setTitle("Customer");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }

}
