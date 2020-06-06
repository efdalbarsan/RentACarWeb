package dao;

import entity.Kullanici;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KullaniciDAO extends Dao {

    private GrupDAO grupDAO;

    public List read(int page, int pageSize) {
        List<Kullanici> clist = new ArrayList();
        int start = (page - 1) * pageSize;
        try {
            PreparedStatement st = getConn().prepareStatement("select * from kullanici order by kullaniciid asc limit " + start + " , " + pageSize);                    //sorgulari statement uzerinden yapariz
            ResultSet rs = st.executeQuery(); //executeQuery veritabanindan veri cekme islemini yapar. 

            while (rs.next()) {
                Kullanici tmp;
                tmp = new Kullanici(rs.getLong("kullaniciid"), rs.getString("email"), rs.getString("kullaniciadi"), rs.getString("sifre"), rs.getString("telefon"), rs.getString("adres"));

                tmp.setGrup(this.getGrupDAO().find(rs.getLong("grupid")));
                clist.add(tmp);//Her yeni kullanicii listeme ekliyorum

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return clist;
    }

    public int count() {
        int count = 0;

        try {
            PreparedStatement st = getConn().prepareStatement("select count(kullaniciid) as kullanici_count from kullanici");
            ResultSet rs = st.executeQuery();
            rs.next();
            count = rs.getInt("kullanici_count");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public Kullanici find(Long kullaniciid) {
        Kullanici k = null;

        try {
            PreparedStatement st = getConn().prepareStatement("select * from kullanici where kullaniciid=" + kullaniciid);    //sorgulari statement uzerinden yapariz
            ResultSet rs = st.executeQuery(); //executeQuery veritabanindan veri cekme islemini yapar. 
            rs.next();

            k = new Kullanici();
            k.setKullaniciid(rs.getLong("kullaniciid"));
            k.setEmail(rs.getString("email"));
            k.setKullaniciadi(rs.getString("kullaniciadi"));
            k.setSifre(rs.getString("sifre"));
            k.setGrup(getGrupDAO().find(rs.getLong("grupid")));
            k.setTelefon(rs.getString("telefon"));
            k.setAdres(rs.getString("adres"));

        } catch (SQLException ex) {
            System.out.println("ex.getMessage");
        }
        return k;
    }

    @Override
    public void create(Object obj) {
        Kullanici kullanici = (Kullanici) obj;
        String q = "insert into kullanici(email,kullaniciadi,sifre,grupid,telefon,adres) values (?,?,?,?,?,?)";
        kullanici.setAdres(turkishEncode(kullanici.getAdres()));
        try {
            PreparedStatement st = this.getConn().prepareStatement(q);
            st.setString(1, kullanici.getEmail());
            st.setString(2, kullanici.getKullaniciadi());
            st.setString(3, kullanici.getSifre());
            if (kullanici.getGrup() == null) {
                st.setLong(4, 3);
            } else {
                st.setLong(4, kullanici.getGrup().getGrupid());
            }

            st.setString(5, kullanici.getTelefon());
            st.setString(6, kullanici.getAdres());

            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void delete(Object obj) {
        Kullanici kullanici = (Kullanici) obj;
        String q = "delete from kullanici where kullaniciid = ?";
        try {
            PreparedStatement st = getConn().prepareStatement(q);
            st.setLong(1, kullanici.getKullaniciid());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void update(Object obj) {
        Kullanici kullanici = (Kullanici) obj;
        String q = "update kullanici set email=?,kullaniciadi=?,sifre=?,grupid=?,telefon=?,adres=? where kullaniciid = ?";
        System.out.println(kullanici.toString());
        try {
            PreparedStatement st = this.getConn().prepareStatement(q);
            st.setString(1, kullanici.getEmail());
            st.setString(2, kullanici.getKullaniciadi());
            st.setString(3, kullanici.getSifre());
            st.setLong(4, kullanici.getGrup().getGrupid());
            st.setString(5, kullanici.getTelefon());
            st.setString(6, kullanici.getAdres());
            st.setLong(7, kullanici.getKullaniciid());

            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Kullanici Login(String email, String parola) {
        Kullanici tmp = null;
        try {
            PreparedStatement pst = this.getConn().prepareStatement("select * from kullanici where email=? and sifre=?");
            pst.setString(1, email);
            pst.setString(2, parola);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                tmp = new Kullanici(rs.getLong("kullaniciid"), rs.getString("email"), rs.getString("kullaniciadi"), rs.getString("sifre"), rs.getString("telefon"), rs.getString("adres"));
                tmp.setGrup(this.getGrupDAO().find(rs.getLong("grupid")));

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return tmp;
    }

    public List read() {
        List<Kullanici> clist = new ArrayList();
        try {
            PreparedStatement st = this.getConn().prepareStatement("select * from kullanici");                    //sorgulari statement uzerinden yapariz
            ResultSet rs = st.executeQuery(); //executeQuery veritabanindan veri cekme islemini yapar. 

            while (rs.next()) {
                Kullanici tmp;
                tmp = new Kullanici(rs.getLong("kullaniciid"), rs.getString("email"), rs.getString("kullaniciadi"), rs.getString("sifre"), rs.getString("telefon"), rs.getString("adres"));

                tmp.setGrup(this.getGrupDAO().find(rs.getLong("grupid")));
                clist.add(tmp);//Her yeni kullanicii listeme ekliyorum

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return clist;
    }

    public GrupDAO getGrupDAO() {
        if (grupDAO == null) {
            this.grupDAO = new GrupDAO();
        }
        return grupDAO;
    }

    public String turkishEncode(String term) {
        String newTerm = term.replace('ş', 's');
        newTerm = newTerm.replace('ğ', 'g');
        newTerm = newTerm.replace('ö', 'o');
        newTerm = newTerm.replace('ç', 'c');
        newTerm = newTerm.replace('ü', 'u');
        newTerm = newTerm.replace('ı', 'i');
        newTerm = newTerm.replace('İ', 'I');

        return newTerm;
    }

}
