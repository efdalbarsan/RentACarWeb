package entity;

import java.util.Objects;

public class Arac {

    private Long aracid;
    private String plaka;
    private String marka;
    private String model;
    private double motor;
    private int yil;
    private int kilometre;
    private String yakit;
    private String vites;
    private int fiyat;
    private Firma firma;

    public Arac() {
    }

    public Arac(Long aracid, String plaka, String marka, String model, double motor, int yil, int kilometre, String yakit, String vites, int fiyat) {
        this.aracid = aracid;
        this.plaka = plaka;
        this.marka = marka;
        this.model = model;
        this.motor = motor;
        this.yil = yil;
        this.kilometre = kilometre;
        this.yakit = yakit;
        this.vites = vites;
        this.fiyat = fiyat;

    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }

    public Firma getFirma() {
        return firma;
    }

    public Long getAracid() {
        return aracid;
    }

    public void setAracid(Long aracid) {
        this.aracid = aracid;
    }

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getMotor() {
        return motor;
    }

    public void setMotor(double motor) {
        this.motor = motor;
    }

    public int getYil() {
        return yil;
    }

    public void setYil(int yil) {
        this.yil = yil;
    }

    public int getKilometre() {
        return kilometre;
    }

    public void setKilometre(int kilometre) {
        this.kilometre = kilometre;
    }

    public String getYakit() {
        return yakit;
    }

    public void setYakit(String yakit) {
        this.yakit = yakit;
    }

    public String getVites() {
        return vites;
    }

    public void setVites(String vites) {
        this.vites = vites;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    @Override
    public String toString() {
        return "Arac{" + "aracid= " + aracid + ", plaka= " + plaka + ", marka= " + marka + ", model= " + model + ", motor= " + motor + ", yil= " + yil + ", kilometre= " + kilometre + ", yakit= " + yakit + ", vites= " + vites + ", fiyat= " + fiyat + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.aracid);
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
        final Arac other = (Arac) obj;
        if (!Objects.equals(this.aracid, other.aracid)) {
            return false;
        }
        return true;
    }
    
    

}
