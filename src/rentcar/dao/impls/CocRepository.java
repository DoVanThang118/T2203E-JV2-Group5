package rentcar.dao.impls;

import rentcar.dao.interfaces.IRepository;
import rentcar.entities.Car;
import rentcar.entities.Coc;
import rentcar.helper.Connector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class CocRepository implements IRepository<Coc> {
    @Override
    public ArrayList<Coc> all() {
        ArrayList<Coc> ls = new ArrayList<>();
        try {
            String sql_txt ="select * from coc";
            Connector connector =Connector.getInstance();
            ResultSet rs = connector.query(sql_txt);
            while (rs.next()){
                int id =rs.getInt("id");
                String coc = rs.getString("giaycoc");
                Coc c = new Coc(id,coc);
                ls.add(c);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return ls;
    }

    @Override
    public boolean create(Coc coc) {
        return false;
    }

    @Override
    public boolean update(Coc coc) {
        return false;
    }

    @Override
    public boolean delete(Coc coc) {
        return false;
    }

    @Override
    public Coc findOne(Integer id) {
        try {
            String sql_txt = "select * from coc where id = ?";
            Connector connector = Connector.getInstance();
            ArrayList arrayList = new ArrayList();
            arrayList.add(id);
            ResultSet resultSet = connector.executeQuery(sql_txt,arrayList);
            while (resultSet.next()){
                int Id = resultSet.getInt("id");
                String giaycoc = resultSet.getString("giaycoc");
                return new Coc(Id,giaycoc);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
