package rentcar.entities;

public class Car {
    public Integer id;
    public String name;
    public String brand;
    public Integer seat;
    public Integer price;
    public Integer qty;

    public Car() {
    }

    public Car(Integer id, String name, String brand, Integer seat, Integer price, Integer qty) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.seat = seat;
        this.price = price;
        this.qty = qty;
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
