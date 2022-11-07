package rentcar.dao.impls;

import rentcar.dao.interfaces.IRepository;
import rentcar.entities.Car;
import rentcar.helper.Connector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class CarRepository implements IRepository<Car> {

    @Override
    public ArrayList<Car> all() {
        ArrayList<Car> ls = new ArrayList<>();
        try {
            String sql_txt ="select * from cars";
            Connector conn =Connector.getInstance();
            ResultSet rs = conn.query(sql_txt);
            while (rs.next()){
                int id =rs.getInt("id");
                String name = rs.getString("name");
                String brand = rs.getString("brand");
                int seat = rs.getInt("seat");
                String number = rs.getString("number");
                int price = rs.getInt("price");
                Car c = new Car(id,name,brand,seat,price,number);
                ls.add(c);

            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return ls;
    }

    @Override
    public boolean create(Car car) {
        return false;
    }

    @Override
    public boolean update(Car car) {
        return false;
    }

    @Override
    public boolean delete(Car car) {
        return false;
    }

    @Override
    public Car findOne(Integer id) {
        return null;
    }
}
