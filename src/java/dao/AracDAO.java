package dao;

import entity.Arac;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AracDAO extends Dao {

    private FirmaDAO firmaDAO;
    private DocumentDao documentDao;

    public List read(int page, int pageSize) {
        List<Arac> clist = new ArrayList();

        int start = (page - 1) * pageSize;
        try {
            PreparedStatement st = getConn().prepareStatement("select * from arac order by aracid asc limit " + pageSize + " offset " + start);                    //sorgulari statement uzerinden yapariz
            ResultSet rs = st.executeQuery(); //executeQuery veritabanindan veri cekme islemini yapar. 

            while (rs.next()) {
                Arac tmp = new Arac();
                tmp.setAracid(rs.getLong("aracid"));
                tmp.setPlaka(rs.getString("plaka"));
                tmp.setMarka(rs.getString("marka"));
                tmp.setModel(rs.getString("model"));
                tmp.setMotor(rs.getDouble("motor"));
                tmp.setYil(rs.getInt("yil"));
                tmp.setKilometre(rs.getInt("kilometre"));
                tmp.setYakit(rs.getString("yakit"));             
                tmp.setVites(rs.getString("vites"));
                tmp.setFirma(this.getFirmaDAO().find(rs.getLong("firmaid")));
                tmp.setFiyat(rs.getInt("Fiyat"));         
                tmp.setDocument(this.getDocumentDao().find(rs.getLong("document_id")));
                clist.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return clist;
    }

    public int count() {
        int count = 0;

        try {
            PreparedStatement st = getConn().prepareStatement("select count(aracid) as arac_count from arac");
            ResultSet rs = st.executeQuery();
            rs.next();
            count = rs.getInt("arac_count");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public Arac find(Long aracid) {
        Arac a = null;

        try {
            PreparedStatement st = getConn().prepareStatement("select * from arac where aracid=" + aracid);    //sorgulari statement uzerinden yapariz
            ResultSet rs = st.executeQuery(); //executeQuery veritabanindan veri cekme islemini yapar. 
            rs.next();

            a = new Arac();
            a.setAracid(rs.getLong("aracid"));
            a.setPlaka(rs.getString("plaka"));
            a.setMarka(rs.getString("marka"));
            a.setModel(rs.getString("model"));
            a.setMotor(rs.getDouble("motor"));
            a.setYil(rs.getInt("yil"));
            a.setKilometre(rs.getInt("kilometre"));
            a.setYakit(rs.getString("yakit"));
            a.setYakit(rs.getString("vites"));
            a.setFiyat(rs.getInt("Fiyat"));
            a.setFirma(getFirmaDAO().find(rs.getLong("firmaid")));
            a.setDocument(getDocumentDao().find(rs.getLong("document_id")));

        } catch (SQLException ex) {
            System.out.println("ex.getMessage");
        }
        return a;
    }

   @Override
    public void create(Object obj) {
        Arac arac = (Arac) obj;
        String q = "insert into arac(plaka,marka,model,motor,yil,kilometre,yakit,vites,firmaid,fiyat,document_id) values (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = getConn().prepareStatement(q);
            st.setString(1, arac.getPlaka());
            st.setString(2, arac.getMarka());
            st.setString(3, arac.getModel());
            st.setDouble(4, arac.getMotor());
            st.setInt(5, arac.getYil());
            st.setInt(6, arac.getKilometre());
            st.setString(7, arac.getYakit());
            st.setString(8, arac.getVites());
            st.setLong(9, arac.getFirma().getFirmaid());
            st.setInt(10, arac.getFiyat());
            st.setLong(11, arac.getDocument().getId());

            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void delete(Object obj) {
        Arac arac = (Arac) obj;
        String q = "delete from arac where aracid = ?";
        try {
            PreparedStatement st = getConn().prepareStatement(q);
            st.setLong(1, arac.getAracid());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void update(Object obj) {
        Arac arac = (Arac) obj;
        String q = "update arac set plaka=?,marka=?,model=?,motor=?,yil=?,kilometre=?,yakit=?,vites=?,firmaid=?,fiyat=?,document_id=? where aracid = ?";
        try {
            PreparedStatement st = getConn().prepareStatement(q);
            st.setString(1, arac.getPlaka());
            st.setString(2, arac.getMarka());
            st.setString(3, arac.getModel());
            st.setDouble(4, arac.getMotor());
            st.setInt(5, arac.getYil());
            st.setInt(6, arac.getKilometre());
            st.setString(7, arac.getYakit());
            st.setString(8, arac.getVites());
            st.setLong(9, arac.getFirma().getFirmaid());
            st.setInt(10, arac.getFiyat());
            st.setLong(11, arac.getDocument().getId());
            st.setLong(12, arac.getAracid());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public FirmaDAO getFirmaDAO() {
        if (this.firmaDAO == null) {
            this.firmaDAO = new FirmaDAO();
        }
        return firmaDAO;
    }

    public List read() {
        List<Arac> clist = new ArrayList();

        
        try {
            PreparedStatement st = getConn().prepareStatement("select * from arac");                    //sorgulari statement uzerinden yapariz
            ResultSet rs = st.executeQuery(); //executeQuery veritabanindan veri cekme islemini yapar. 

            while (rs.next()) {
                Arac tmp = new Arac();
                tmp.setAracid(rs.getLong("aracid"));
                tmp.setPlaka(rs.getString("plaka"));
                tmp.setMarka(rs.getString("marka"));
                tmp.setModel(rs.getString("model"));
                tmp.setMotor(rs.getDouble("motor"));
                tmp.setYil(rs.getInt("yil"));
                tmp.setKilometre(rs.getInt("kilometre"));
                tmp.setYakit(rs.getString("yakit"));             
                tmp.setVites(rs.getString("vites"));
                tmp.setFirma(this.getFirmaDAO().find(rs.getLong("firmaid")));
                tmp.setFiyat(rs.getInt("Fiyat"));         
                tmp.setDocument(this.getDocumentDao().find(rs.getLong("document_id")));
                clist.add(tmp);
            }
                

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return clist;
    }

    public DocumentDao getDocumentDao() {
         if (this.documentDao == null) {
            this.documentDao = new DocumentDao();
        }
        return documentDao;
    }
    
}
