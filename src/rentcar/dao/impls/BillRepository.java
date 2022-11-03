package rentcar.dao.impls;

import rentcar.dao.interfaces.IRepository;
import rentcar.entities.Bill;

import java.util.ArrayList;

public class BillRepository implements IRepository<Bill> {
    @Override
    public ArrayList all() {
        return null;
    }

    @Override
    public boolean create(Bill bill) {
        return false;
    }

    @Override
    public boolean update(Bill bill) {
        return false;
    }

    @Override
    public boolean delete(Bill bill) {
        return false;
    }

    @Override
    public Bill findOne(Integer id) {
        return null;
    }
}
