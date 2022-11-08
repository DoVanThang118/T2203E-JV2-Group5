package rentcar.dao.impls;

import rentcar.dao.interfaces.IRepository;
import rentcar.entities.Bill;
import rentcar.helper.Connector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class BillRepository implements IRepository<Bill> {
    @Override
    public ArrayList<Bill> all() {
        ArrayList<Bill> arrayList = new ArrayList<>();
        try {
            String sql_txt = "select * from bills";
            Connector connector = Connector.getInstance();
            ResultSet resultSet = connector.query(sql_txt);
            while (resultSet.next()){
                arrayList.add(new Bill(
                        resultSet.getInt("id"),
                        resultSet.getInt("carId"),
                        resultSet.getInt("customerId"),
                        resultSet.getDate("rentDate"),
                        resultSet.getDate("expDate"),
                        resultSet.getInt("deposits"),
                        resultSet.getInt("cocId")
                ));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return arrayList;
    }

    @Override
    public boolean create(Bill bill) {
        try {
            String sql_txt = "insert into bills(carId,customerId,rentDate,expDate,deposits,cocId) values (?,?,?,?,?,?)";
            Connector connector = Connector.getInstance();
            ArrayList arrayList = new ArrayList<>();
            arrayList.add(bill.getCarId());
            arrayList.add(bill.getCustomerId());
            arrayList.add(bill.getDate());
            arrayList.add(bill.getExp());
            arrayList.add(bill.getDeposits());
            arrayList.add(bill.getCocId());
            if (connector.execute(sql_txt,arrayList)) {
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
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
