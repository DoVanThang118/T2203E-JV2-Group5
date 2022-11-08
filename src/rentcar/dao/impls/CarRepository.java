package rentcar.dao.impls;

import rentcar.dao.interfaces.IRepository;
import rentcar.entities.Car;
import rentcar.entities.Customer;
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
                int status = rs.getInt("status");
                Car c = new Car(id,name,brand,seat,price,number,status);
                ls.add(c);

            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return ls;
    }

    public ArrayList<Car> freeCar(){
        ArrayList<Car> ls = new ArrayList<>();
        try {
            String sql_txt ="select * from cars where status = 0";
            Connector conn =Connector.getInstance();
            ResultSet rs = conn.query(sql_txt);
            while (rs.next()){
                int id =rs.getInt("id");
                String name = rs.getString("name");
                String brand = rs.getString("brand");
                int seat = rs.getInt("seat");
                String number = rs.getString("number");
                int price = rs.getInt("price");
                int status = rs.getInt("status");
                Car c = new Car(id,name,brand,seat,price,number,status);
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
        try {
            String sql_txt = "select * from cars where id = ?";
            Connector connector = Connector.getInstance();
            ArrayList arrayList = new ArrayList();
            arrayList.add(id);
            ResultSet resultSet = connector.executeQuery(sql_txt,arrayList);
            while (resultSet.next()){
                int Id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Integer price = resultSet.getInt("price");
                String brand = resultSet.getString("brand");
                String number = resultSet.getString("number");
                Integer seat = resultSet.getInt("seat");
                Integer status = resultSet.getInt("status");
                return new Car(Id,name,brand,seat,price,number,status);
            }

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
