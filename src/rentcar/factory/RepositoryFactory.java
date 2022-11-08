package rentcar.factory;

import rentcar.dao.impls.BillRepository;
import rentcar.dao.impls.CarRepository;
import rentcar.dao.impls.CocRepository;
import rentcar.dao.impls.CustomerRepository;
import rentcar.dao.interfaces.IRepository;
import rentcar.enums.RepoType;

public class RepositoryFactory {
    private RepositoryFactory(){

    }
    public static IRepository createRepository(RepoType type){
        switch (type){
            case CAR: return new CarRepository();
            case CUSTOMER: return new CustomerRepository();
            case BILL: return new BillRepository();
            case Coc: return new CocRepository();
            default: throw new IllegalArgumentException("ohhh noooo !!!!");
        }
    }
}

