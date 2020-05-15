package dao;

import entity.Firma;
import entity.Sehir;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FirmaDAO extends Dao {

    private SehirDAO sehirDAO;
    
    public List read(int page, int pageSize) {
        List<Firma> firmaList = new ArrayList<>();

        int start = (page - 1) * pageSize;
        try {
            Statement st = this.getConn().createStatement();                    //sorgulari statement uzerinden yapariz
            ResultSet rs = st.executeQuery("select * from firma order by firmaid asc limit " + pageSize + " offset " + start); 

            while (rs.next()) {
                Firma tmp=new Firma();            
                tmp.setFirmaid(rs.getLong("firmaid"));
                tmp.setAdi(rs.getString("adi"));
                tmp.setTelefon(rs.getString("telefon"));
                tmp.setEmail(rs.getString("email"));
                tmp.setAdres(rs.getString("adres"));
                tmp.setFirmaSehir(this.getSehirDAO().getSehirFirma(tmp.getFirmaid()));
                firmaList.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return firmaList;
    }

    public int count() {
        int count = 0;

        try {
            PreparedStatement st = getConn().prepareStatement("select count(firmaid) as firma_count from firma");
            ResultSet rs = st.executeQuery();
            rs.next();
            count = rs.getInt("firma_count");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public Firma find(int firmaid) {
        Firma f = null;

        try {
            Statement st = this.getConn().createStatement();    //sorgulari statement uzerinden yapariz
            ResultSet rs = st.executeQuery("select * from firma where firmaid=" + firmaid); //executeQuery veritabanindan veri cekme islemini yapar. 
            rs.next();

            f = new Firma();
            f.setFirmaid(rs.getLong("firmaid"));
            f.setAdi(rs.getString("adi"));
            f.setTelefon(rs.getString("telefon"));
            f.setEmail(rs.getString("email"));
            f.setAdres(rs.getString("Adres"));
            f.setSehir_id(rs.getLong("sehir_id"));

        } catch (SQLException ex) {
            System.out.println("ex.getMessage");
        }
        return f;
    }

    @Override
    public void create(Object obj) {
        Firma firma = (Firma) obj;
        try {
            PreparedStatement st = this.getConn().prepareStatement("insert into firma(adi,telefon,email,adres) values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1, firma.getAdi());
            st.setString(2, firma.getTelefon());
            st.setString(3, firma.getEmail());
            st.setString(4, firma.getAdres());

            st.executeUpdate();
            ResultSet gk = st.getGeneratedKeys();
            Long firmaid = null;
            if (gk.next()) {
                firmaid = gk.getLong(1);
            }

            for (Sehir t : firma.getFirmaSehir()) {
                st = this.getConn().prepareStatement("insert into firma_sehir(firmaid,sehir_id,firma_sehir_id) values(?,?,default)");
                st.setLong(1, firmaid);
                st.setLong(2, t.getSehir_id());
                st.executeUpdate();
            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void delete(Object obj) {
        Firma firma = (Firma) obj;

        String q = "delete from firma where firmaid = ?";
        try {
            PreparedStatement st = this.getConn().prepareStatement(q);
            st.setLong(1, firma.getFirmaid());
            st.executeUpdate();
            st=this.getConn().prepareStatement("delete from firma_sehir where firmaid=?");
            st.setLong(1, firma.getFirmaid());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Object obj) {
        Firma firma = (Firma) obj;
        String q = "update firma set adi=?,telefon=?,email=?,adres=? where firmaid = ?";
        try {
            PreparedStatement st = getConn().prepareStatement(q);
            st.setString(1, firma.getAdi());
            st.setString(2, firma.getTelefon());
            st.setString(3, firma.getEmail());
            st.setString(4, firma.getAdres());
            st.setLong(5, firma.getFirmaid());
            st.executeUpdate();
            st=this.getConn().prepareStatement("delete from firma_sehir where firmaid=?");
            st.setLong(1, firma.getFirmaid());
            st.executeUpdate();
            
             for (Sehir t : firma.getFirmaSehir()) {
                st = this.getConn().prepareStatement("insert into firma_sehir(firmaid,sehir_id,firma_sehir_id) values(?,?,default)");
                st.setLong(1, firma.getFirmaid());
                st.setLong(2, t.getSehir_id());
                st.executeUpdate();
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        public List read() {
        List<Firma> firmaList = new ArrayList<>();

        
        try {
            Statement st = this.getConn().createStatement();                    //sorgulari statement uzerinden yapariz
            ResultSet rs = st.executeQuery("select * from firma"); 

            while (rs.next()) {
                Firma tmp=new Firma();            
                tmp.setFirmaid(rs.getLong("firmaid"));
                tmp.setAdi(rs.getString("adi"));
                tmp.setTelefon(rs.getString("telefon"));
                tmp.setEmail(rs.getString("email"));
                tmp.setAdres(rs.getString("adres"));
                tmp.setFirmaSehir(this.getSehirDAO().getSehirFirma(rs.getLong("firmaid")));
                firmaList.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return firmaList;
    }

    public SehirDAO getSehirDAO() {
        if(this.sehirDAO == null){
            sehirDAO = new SehirDAO();
        }
        return sehirDAO;
    }
}
