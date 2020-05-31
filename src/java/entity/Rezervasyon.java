package entity;

import java.sql.Date;

public class Rezervasyon {

    private int rezervasyonid;
    private String aciklama;
    private Date tarih;
    private String tempDate;
    private Kullanici kullanici;
    private Arac arac;

    public Rezervasyon() {
    }

    public Rezervasyon(int rezervasyonid, String aciklama, Date tarih) {
        this.rezervasyonid = rezervasyonid;
        this.aciklama = aciklama;
        this.tarih = tarih;
    }

    public String getTempDate() {
        return tempDate;
    }

    public void setTempDate(String tempDate) {
        this.tempDate = tempDate;
    }

    public int getRezervasyonid() {
        return rezervasyonid;
    }

    public void setRezervasyonid(int rezervasyonid) {
        this.rezervasyonid = rezervasyonid;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public Arac getArac() {
        return arac;
    }

    public void setArac(Arac arac) {
        this.arac = arac;
    }

    @Override
    public String toString() {
        return "Rezervasyon{" + "rezervasyonid=" + rezervasyonid + ",aciklama=" + aciklama + ", tarih=" + tarih + ", tempDate=" + tempDate + ", kullanici=" + kullanici + ", arac=" + arac + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.rezervasyonid;
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
        final Rezervasyon other = (Rezervasyon) obj;
        if (this.rezervasyonid != other.rezervasyonid) {
            return false;
        }
        return true;
    }

}
