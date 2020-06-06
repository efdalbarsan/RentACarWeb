/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Sehir;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SehirDAO extends Dao {

    public List read(int page, int pageSize) {

        List<Sehir> clist = new ArrayList();
        int start = (page - 1) * pageSize;

        try {
            PreparedStatement st = this.getConn().prepareStatement("select * from sehir order by sehir_id limit " +start+ " , " +pageSize);                    //sorgulari statement uzerinden yapariz
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                Sehir tmp = new Sehir();
                tmp.setSehir_id(rs.getLong("sehir_id"));
                tmp.setAdi(rs.getString("adi"));

                clist.add(tmp);//Her yeni sehiri listeme ekliyorum

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return clist;
    }

    public int count() {
        int count = 0;
        
        try {
            PreparedStatement st = getConn().prepareStatement("select count(sehir_id) as sehir_count from sehir");
            ResultSet rs = st.executeQuery();
            rs.next();
            count = rs.getInt("sehir_count");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    @Override
    public void create(Object obj) {
        Sehir sehir = (Sehir) obj;
        String q = "insert into sehir(adi) values (?)";
        try {
            PreparedStatement st = getConn().prepareStatement(q);
            st.setString(1, sehir.getAdi());

            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void delete(Object obj) {
        Sehir sehir = (Sehir) obj;
        String q = "delete from sehir where sehir_id = ?";
        try {
            PreparedStatement st = getConn().prepareStatement(q);
            st.setLong(1, sehir.getSehir_id());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void update(Object obj) {
        Sehir sehir = (Sehir) obj;
        String q = "update sehir set adi=? where sehir_id = ?";
        try {
            PreparedStatement st = getConn().prepareStatement(q);
            st.setString(1, sehir.getAdi());
            st.setLong(2, sehir.getSehir_id());

            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Sehir find(Long sehir_id) {
        Sehir s = null;
        try {
            PreparedStatement st = this.getConn().prepareStatement("select * from sehir where sehir_id = " + sehir_id);
            ResultSet rs = st.executeQuery();
            rs.next();

            s = new Sehir();
            s.setSehir_id(rs.getLong("sehir_id"));
            s.setAdi(rs.getString("adi"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return s;
    }

    public List<Sehir> getSehirFirma(Long firmaid) {
        List<Sehir> firmaSehir = new ArrayList<>();
        System.out.println(firmaid + "-------------------------------firmaid");
        try {
            PreparedStatement st = this.getConn().prepareStatement("select * from firma_sehir where firmaid =" + firmaid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                firmaSehir.add(this.find(rs.getLong("sehir_id")));
                System.out.println(this.find(rs.getLong("sehir_id")).toString() + "---------------");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        return firmaSehir;
    }

    public List read() {

        List<Sehir> clist = new ArrayList();

        try {
            PreparedStatement st = this.getConn().prepareStatement("select * from sehir");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Sehir tmp = new Sehir();
                tmp.setSehir_id(rs.getLong("sehir_id"));
                tmp.setAdi(rs.getString("adi"));

                clist.add(tmp);//Her yeni sehiri listeme ekliyorum

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return clist;
    }

}
