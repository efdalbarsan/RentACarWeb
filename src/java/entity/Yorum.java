package entity;

import java.util.Objects;

public class Yorum {

    private Long yorumid;
    private String yorum;
    private Kullanici kullanici;
    private Arac arac;

    public Yorum() {
    }

    public Yorum(Long yorumid, String yorum) {
        this.yorumid = yorumid;
        this.yorum = yorum;
    }

    public Long getYorumid() {
        return yorumid;
    }

    public void setYorumid(Long yorumid) {
        this.yorumid = yorumid;
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
        return "Yorum{" + "yorumid=" + yorumid + ", yorum=" + yorum + ", kullanici=" + kullanici + ", arac=" + arac + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.yorumid);
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
        final Yorum other = (Yorum) obj;
        if (!Objects.equals(this.yorumid, other.yorumid)) {
            return false;
        }
        return true;
    }

    

}
