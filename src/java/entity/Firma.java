package entity;

import java.util.List;
import java.util.Objects;

public class Firma {
    private Long firmaid;
    private String adi;
    private String telefon;
    private String email;
    private String adres;  
    private Firma firma;
    private Long sehir_id;
    private List<Sehir> firmaSehir;

    public Firma() {
    }

    public Firma(Long firmaid, String adi, String telefon, String email, String adres, Firma firma, Long sehir_id, List<Sehir> firmaSehir) {
        this.firmaid = firmaid;
        this.adi = adi;
        this.telefon = telefon;
        this.email = email;
        this.adres = adres;
        this.firma = firma;
        this.sehir_id = sehir_id;
        this.firmaSehir = firmaSehir;
    }

    public Long getFirmaid() {
        return firmaid;
    }

    public void setFirmaid(Long firmaid) {
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

    public Long getSehir_id() {
        return sehir_id;
    }

    public void setSehir_id(Long sehir_id) {
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.firmaid);
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
        final Firma other = (Firma) obj;
        if (!Objects.equals(this.firmaid, other.firmaid)) {
            return false;
        }
        return true;
    }

   
    
    
}
