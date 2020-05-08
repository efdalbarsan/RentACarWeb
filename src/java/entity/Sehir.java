/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Barsan
 */
public class Sehir {
    private int Sehir_id;
    private String adi;

    public Sehir() {
    }

    public Sehir(int Sehir_id, String adi) {
        this.Sehir_id = Sehir_id;
        this.adi = adi;
    }

    public int getSehir_id() {
        return Sehir_id;
    }

    public void setSehir_id(int Sehir_id) {
        this.Sehir_id = Sehir_id;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    @Override
    public String toString() {
        return "Sehir{" + "Sehir_id=" + Sehir_id + ", adi=" + adi + '}';
    }
    
    
}