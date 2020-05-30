package entity;

public class Yorum {

    private int yorumid;
    private int kullaniciid;
    private String yorum;
    private Kullanici kullanici;
    private Arac arac;

    public Yorum() {
    }

    public Yorum(int yorumid, int kullaniciid, String yorum) {
        this.yorumid = yorumid;
        this.kullaniciid = kullaniciid;
        this.yorum = yorum;
    }

    public int getYorumid() {
        return yorumid;
    }

    public void setYorumid(int yorumid) {
        this.yorumid = yorumid;
    }

    public int getKullaniciid() {
        return kullaniciid;
    }

    public void setKullaniciid(int kullaniciid) {
        this.kullaniciid = kullaniciid;
    }


    public String getYorum() {
        return yorum;
    }

    public void setYorum(String yorum) {
        this.yorum = yorum;
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
        return "Yorum{" + "yorumid=" + yorumid + ", kullaniciid=" + kullaniciid + ", yorum=" + yorum + ", kullanici=" + kullanici + ", arac=" + arac + '}';
    }



}
