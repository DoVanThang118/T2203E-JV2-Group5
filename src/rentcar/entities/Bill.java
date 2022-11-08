package rentcar.entities;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import rentcar.Main;
import rentcar.bill.create.CreateBillController;
import rentcar.bill.payment.PaymentBillController;
import rentcar.dao.impls.CarRepository;
import rentcar.dao.impls.CocRepository;
import rentcar.dao.impls.CustomerRepository;
import rentcar.enums.RepoType;
import rentcar.factory.RepositoryFactory;

import java.util.Date;

public class Bill {
    private Integer id;
    private Integer customerId;
    private Integer carId;
    private Date date;
    private Date exp;
    private Integer deposits;
    private Integer cocId;
    private Button action;

    public Integer status;

    private String nameCustomer;
    private String nameCar;
    private String nameCoc;
    private String statusLabel;

    public Bill(Integer id, Integer customerId, Integer carId, Date date, Date exp, Integer deposits, Integer cocId, Integer status) {
        this.id = id;
        this.customerId = customerId;
        this.carId = carId;
        this.date = date;
        this.exp = exp;
        this.deposits = deposits;
        this.cocId = cocId;
        this.status = status;
        this.action = new Button("Payment");
        this.action.setOnAction(event -> {
            try {
                PaymentBillController.paymentBill = this;
                Parent pay = FXMLLoader.load(getClass().getResource("../bill/payment/payment.fxml"));
                rentcar.Main.rootStage.setTitle("Payment Bill");
                Main.rootStage.setScene(new Scene(pay,800,600));
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

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getExp() {
        return exp;
    }

    public void setExp(Date exp) {
        this.exp = exp;
    }

    public Integer getDeposits() {
        return deposits;
    }

    public void setDeposits(Integer deposits) {
        this.deposits = deposits;
    }

    public Integer getCocId() {
        return cocId;
    }

    public void setCocId(Integer cocId) {
        this.cocId = cocId;
    }

    public String getNameCustomer() {
        return ((this.customer().getName())+"\n"+(this.customer().getCmt()));
    }

    public String getNameCar() {
        return ((this.car().getName())+"\n"+(this.car().getNumber()));
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public void setNameCar(String nameCar) {
        this.nameCar = nameCar;
    }

    public String getNameCoc() {
        return this.coc().getCoc();
    }

    public void setNameCoc(String nameCoc) {
        this.nameCoc = nameCoc;
    }

    public String getStatusLabel() {
        return status==0?"Đang Thuê":"Không Thuê";
    }

    public void setStatusLabel(String statusLabel) {
        this.statusLabel = statusLabel;
    }

    public Customer customer() {
        return ((CustomerRepository) RepositoryFactory.createRepository(RepoType.CUSTOMER))
                .findOne(this.getCustomerId());
    }
    public Car car() {
        return ((CarRepository) RepositoryFactory.createRepository(RepoType.CAR))
                .findOne(this.getCarId());
    }
    public Coc coc() {
        return ((CocRepository) RepositoryFactory.createRepository(RepoType.Coc))
                .findOne(this.getCocId());
    }

    public Button getAction() {
        return action;
    }

    public void setAction(Button action) {
        this.action = action;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
