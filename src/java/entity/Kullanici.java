package entity;

import java.util.Objects;

public class Kullanici {

    private Long kullaniciid;
    private String email;
    private String kullaniciadi;
    private String sifre;
    private String telefon;
    private String adres;
    private Grup grup;

    public Kullanici() {
    }

    public Kullanici(Long kullaniciid, String email, String kullaniciadi, String sifre, String telefon, String adres) {
        this.kullaniciid = kullaniciid;
        this.email = email;
        this.kullaniciadi = kullaniciadi;
        this.sifre = sifre;
        this.telefon = telefon;
        this.adres = adres;
    }

    public Long getKullaniciid() {
        return kullaniciid;
    }

    public void setKullaniciid(Long kullaniciid) {
        this.kullaniciid = kullaniciid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKullaniciadi() {
        return kullaniciadi;
    }

    public void setKullaniciadi(String kullaniciadi) {
        this.kullaniciadi = kullaniciadi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public Grup getGrup() {
        return grup;
    }

    public void setGrup(Grup grup) {
        this.grup = grup;
    }

    @Override
    public String toString() {
        return "Kullanici{" + "kullaniciid=" + kullaniciid + ", email=" + email + ", kullaniciadi=" + kullaniciadi + ", sifre=" + sifre + ", telefon=" + telefon + ", adres=" + adres + ", grup=" + grup + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.kullaniciid);
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
        final Kullanici other = (Kullanici) obj;
        if (!Objects.equals(this.kullaniciid, other.kullaniciid)) {
            return false;
        }
        return true;
    }

}
