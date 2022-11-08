package rentcar.entities;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import rentcar.Main;
import rentcar.bill.create.CreateBillController;

public class Customer {

    public Integer id;

    public String name;
    public String cmt;
    public String tel;
    public String email;
    public String address;
    public Button action;
    public Button edit;

    public Customer(Integer id, String name, String cmt, String tel, String email, String address) {
        this.id = id;
        this.name = name;
        this.cmt = cmt;
        this.tel = tel;
        this.email = email;
        this.address = address;
        this.action = new Button("Rent Car");
        this.action.setOnAction(event -> {
            try {
                CreateBillController.createBillToCustomer = this;
                Parent listBook = FXMLLoader.load(getClass().getResource("../bill/create/createBill.fxml"));
                rentcar.Main.rootStage.setTitle("Create Bill");
                Main.rootStage.setScene(new Scene(listBook,800,600));
            }catch (Exception e){
                System.out.println("ERROR");
            }
        });
        this.edit = new Button("Edit");
        this.edit.setOnAction(event -> {});
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCmt() {
        return cmt;
    }

    public void setCmt(String cmt) {
        this.cmt = cmt;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Button getAction() {
        return action;
    }

    public void setAction(Button action) {
        this.action = action;
    }

    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }

    public String toString() {
        return getName()+"-"+getCmt();
    }
}
