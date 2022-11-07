package rentcar.entities;

public class Coc {
    public Integer id;
    public String Coc;

    public Coc(Integer id, String coc) {
        this.id = id;
        Coc = coc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoc() {
        return Coc;
    }

    public void setCoc(String coc) {
        Coc = coc;
    }

    public String toString() {
        return getCoc();
    }
}
