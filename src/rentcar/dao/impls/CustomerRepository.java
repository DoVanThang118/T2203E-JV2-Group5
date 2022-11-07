package rentcar.dao.impls;

import rentcar.dao.interfaces.IRepository;
import rentcar.entities.Customer;
import rentcar.helper.Connector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class CustomerRepository implements IRepository<Customer> {
    @Override
    public ArrayList<Customer> all() {
        ArrayList<Customer> list = new ArrayList<>();
        try {
            String sql_txt = "select * from customers";
            Connector connector = Connector.getInstance();
            ResultSet resultSet = connector.query(sql_txt);
            while (resultSet.next()){
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String cmt = resultSet.getString("cmt");
                String tel = resultSet.getString("tel");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                Customer customer = new Customer(id,name,cmt,tel,email,address);
                list.add(customer);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public boolean create(Customer customer) {
        try {
            String sql_txt = "insert into customers(name,cmt,tel,email,address) values (?,?,?,?,?)";
            Connector connector = Connector.getInstance();
            ArrayList arrayList = new ArrayList<>();
            arrayList.add(customer.getName());
            arrayList.add(customer.getCmt());
            arrayList.add(customer.getTel());
            arrayList.add(customer.getEmail());
            arrayList.add(customer.getAddress());
            if (connector.execute(sql_txt,arrayList)) {
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Customer customer) {
        try {
            String sql_txt = "update customers set name=?,cmt=?,tel=?,email=?,address=? where id=?";
            Connector conn = Connector.getInstance();
            ArrayList arrayList = new ArrayList();
            arrayList.add(customer.getName());
            arrayList.add(customer.getCmt());
            arrayList.add(customer.getTel());
            arrayList.add(customer.getEmail());
            arrayList.add(customer.getAddress());
            arrayList.add(customer.getId());
            if(conn.execute(sql_txt,arrayList)){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Customer customer) {
        try {
            String sql_txt = "delete from customers where id = ?";
            Connector connector = Connector.getInstance();
            ArrayList arrayList = new ArrayList();
            arrayList.add(customer.getId());
            if (connector.execute(sql_txt,arrayList)) {
                return true;
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Customer findOne(Integer id) {
        try {
            String sql_txt = "select * from customers where id = ?";
            Connector connector = Connector.getInstance();
            ArrayList arrayList = new ArrayList();
            arrayList.add(id);
            ResultSet resultSet = connector.executeQuery(sql_txt,arrayList);
            while (resultSet.next()){
                int Id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String cmt = resultSet.getString("cmt");
                String tel = resultSet.getString("tel");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                return new Customer(Id,name,cmt,tel,email,address);
            }

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
