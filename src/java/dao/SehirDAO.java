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

/**
 *
 * @author Barsan
 */
public class SehirDAO extends Dao{
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

    public List read() {

        List<Sehir> clist = new ArrayList();

        try {
            Statement st = this.getConn().createStatement();                    //sorgulari statement uzerinden yapariz
            ResultSet rs = st.executeQuery("select * from sehir"); //executeQuery veritabanindan veri cekme islemini yapar. 

            while (rs.next()) {
                Sehir tmp;
                tmp = new Sehir(rs.getInt("sehir_id"), rs.getString("adi"));

                clist.add(tmp);//Her yeni sehiri listeme ekliyorum

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return clist;
    }

    @Override
    public void update(Object obj) {
        Sehir sehir = (Sehir) obj;
        String q = "update sehir set adi=? where sehir_id = ?";
        try {
            PreparedStatement st = getConn().prepareStatement(q);
            st.setString(1, sehir.getAdi());
            st.setInt(2, sehir.getSehir_id());
           
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
            st.setInt(1, sehir.getSehir_id());
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
