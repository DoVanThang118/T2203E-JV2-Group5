package rentcar.entities;

import rentcar.dao.impls.CarRepository;
import rentcar.dao.impls.CustomerRepository;
import rentcar.enums.RepoType;
import rentcar.factory.RepositoryFactory;

import java.time.LocalDate;
import java.util.Date;

public class Bill {
    private Integer id;
    private Integer customerId;
    private Integer carId;
    private Date date;
    private Date exp;
    private Integer deposits;
    private Integer cocId;

    public Bill(Integer id, Integer customerId, Integer carId, Date date, Date exp, Integer deposits, Integer cocId) {
        this.id = id;
        this.customerId = customerId;
        this.carId = carId;
        this.date = date;
        this.exp = exp;
        this.deposits = deposits;
        this.cocId = cocId;
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
    public Customer customer() {
        return ((CustomerRepository) RepositoryFactory.createRepository(RepoType.CUSTOMER))
                .findOne(this.getCustomerId());
    }
    public Car car() {
        return ((CarRepository) RepositoryFactory.createRepository(RepoType.CAR))
                .findOne(this.getCarId());
    }
}
