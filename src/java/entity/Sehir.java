/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;

/**
 *
 * @author Barsan
 */
public class Sehir {
    private Long Sehir_id;
    private String adi;

    public Sehir() {
    }

    public Sehir(Long Sehir_id, String adi) {
        this.Sehir_id = Sehir_id;
        this.adi = adi;
    }

    public Long getSehir_id() {
        return Sehir_id;
    }

    public void setSehir_id(Long Sehir_id) {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.Sehir_id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sehir other = (Sehir) obj;
        if (!Objects.equals(this.Sehir_id, other.Sehir_id)) {
            return false;
        }
        return true;
    }
    
    
}