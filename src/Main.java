import rentcar.entities.Customer;
import rentcar.helper.Connector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("Hello world!");

        Customer book = new Customer();
        book.setId(11);
        book.setName("asdaqdqwfwqfqwfqwfwr ư");

        String sql_txt = "INSERT INTO books(id,name) VALUES(?,?)";
        Connector conn = Connector.getInstance();
        ArrayList arr = new ArrayList();
        arr.add(book.getId());
        arr.add(book.getName());
//        conn.execute();
        conn.executeQuery(sql_txt,arr);

    }
}