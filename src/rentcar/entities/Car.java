package rentcar.entities;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import rentcar.Main;
import rentcar.bill.create.CreateBillController;

public class Car {
    public Integer id;
    public String name;
    public String brand;
    public Integer seat;
    public Integer price;
    public Integer qty;
    public Button action;

    public Car(Integer id, String name, String brand, Integer seat, Integer price, Integer qty) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.seat = seat;
        this.price = price;
        this.qty = qty;
        this.action = new Button("Create Bill");
        this.action.setOnAction(event -> {
            try {
                CreateBillController.createBill = this;
                Parent listBook = FXMLLoader.load(getClass().getResource("../bill/create/createBill.fxml"));
                rentcar.Main.rootStage.setTitle("Create Bill");
                Main.rootStage.setScene(new Scene(listBook,800,600));
            }catch (Exception e){
                System.out.println("ERROR");
            }
        });
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}
