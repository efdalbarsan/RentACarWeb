package entity;

import java.util.Objects;

public class Grup {

    private Long grupid;
    private String grupadi;

    public Grup() {
    }

    public Grup(Long grupid, String grupadi) {
        this.grupid = grupid;
        this.grupadi = grupadi;
    }

    public Long getGrupid() {
        return grupid;
    }

    public void setGrupid(Long grupid) {
        this.grupid = grupid;
    }


    public String getGrupadi() {
        return grupadi;
    }

    public void setGrupadi(String grupadi) {
        this.grupadi = grupadi;
    }

    
    @Override
    public String toString() {
        return "Grup{" + "grupid=" + grupid + ", grupadi=" + grupadi + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.grupid);
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
        final Grup other = (Grup) obj;
        if (!Objects.equals(this.grupid, other.grupid)) {
            return false;
        }
        return true;
    }

    


}
