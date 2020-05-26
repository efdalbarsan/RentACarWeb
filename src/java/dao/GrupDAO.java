package dao;

import entity.Grup;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GrupDAO extends Dao {

    public List read() {
        List<Grup> clist = new ArrayList();
        
        try {
            PreparedStatement st = getConn().prepareStatement("select * from grup");                    //sorgulari statement uzerinden yapariz
            ResultSet rs = st.executeQuery(); //executeQuery veritabanindan veri cekme islemini yapar. 

            while (rs.next()) {
                Grup tmp;
                tmp = new Grup(rs.getLong("grupid"), rs.getString("grupadi"));

                clist.add(tmp);//Her yeni grupi listeme ekliyorum

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return clist;
    }
    

    public Grup find(Long grupid) {
        Grup g = null;

        try {
            PreparedStatement st = getConn().prepareStatement("select * from grup where grupid=" + grupid);    //sorgulari statement uzerinden yapariz
            ResultSet rs = st.executeQuery(); //executeQuery veritabanindan veri cekme islemini yapar. 
            rs.next();

            g = new Grup();
            g.setGrupid(rs.getLong("grupid"));
            g.setGrupadi(rs.getString("grupadi"));

        } catch (SQLException ex) {
            System.out.println("ex.getMessage");
        }
        return g;
    }

    @Override
    public void create(Object obj) {
        Grup grup = (Grup) obj;
        String q = "insert into grup(grupadi) values (?)";
        try {
            PreparedStatement st = getConn().prepareStatement(q);
            st.setString(1, grup.getGrupadi());

            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void delete(Object obj) {
        Grup grup = (Grup) obj;
        String q = "delete from grup where grupid = ?";
        try {
            PreparedStatement st = getConn().prepareStatement(q);
            st.setLong(1, grup.getGrupid());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void update(Object obj) {
        Grup grup = (Grup) obj;
        String q = "update grup set grupadi=? where grupid = ?";
        try {
            PreparedStatement st = getConn().prepareStatement(q);
            st.setString(1, grup.getGrupadi());
            st.setLong(2, grup.getGrupid());

            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
