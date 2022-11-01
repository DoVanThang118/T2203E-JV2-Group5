package rentcar;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class HomeController {
    public void gotoCarlist(ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("car/list/list.fxml"));
        Main.rootStage.setTitle("Customer");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }

}
