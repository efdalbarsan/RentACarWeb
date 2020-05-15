package entity;

import java.util.List;

public class Firma {
    private int firmaid;
    private String adi;
    private String telefon;
    private String email;
    private String adres;  
    private Firma firma;
    private int sehir_id;
    private List<Sehir> firmaSehir;

    public Firma() {
    }

    public Firma(int firmaid, String adi, String telefon, String email, String adres, Firma firma) {
        this.firmaid = firmaid;
        this.adi = adi;
        this.telefon = telefon;
        this.email = email;
        this.adres = adres;
        this.firma = firma;
    }

    public Firma(int firmaid, String adi, String telefon, String email, String adres, int sehir_id) {
        this.firmaid = firmaid;
        this.adi = adi;
        this.telefon = telefon;
        this.email = email;
        this.adres = adres;
        this.sehir_id = sehir_id;
    }



    public int getFirmaid() {
        return firmaid;
    }

    public void setFirmaid(int firmaid) {
        this.firmaid = firmaid;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public int getSehir_id() {
        return sehir_id;
    }

    public void setSehir_id(int sehir_id) {
        this.sehir_id = sehir_id;
    }

    public List<Sehir> getFirmaSehir() {
        return firmaSehir;
    }

    public void setFirmaSehir(List<Sehir> firmaSehir) {
        this.firmaSehir = firmaSehir;
    }

    public Firma getFirma() {
        return firma;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }

    @Override
    public String toString() {
        return "Firma{" + "firmaid=" + firmaid + ", adi=" + adi + ", telefon=" + telefon + ", email=" + email + ", adres=" + adres + ", sehir_id=" + sehir_id + '}';
    }

   
    
    
}
