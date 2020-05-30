package entity;

import java.util.List;
import java.util.Objects;


public class HasarKaydi {
    private Long hasarid;
    private String boya;
    private String cizik;
    private String degisim;
    private String aciklama;
    private Arac arac;

    public HasarKaydi() {
    }

    public HasarKaydi(Long hasarid, String boya, String cizik, String degisim, String aciklama) {
        this.hasarid = hasarid;
        this.boya = boya;
        this.cizik = cizik;
        this.degisim = degisim;
        this.aciklama = aciklama;
    }


    public Long getHasarid() {
        return hasarid;
    }

    public void setHasarid(Long hasarid) {
        this.hasarid = hasarid;
    }


    public String getBoya() {
        return boya;
    }

    public void setBoya(String boya) {
        this.boya = boya;
    }

    public String getCizik() {
        return cizik;
    }

    public void setCizik(String cizik) {
        this.cizik = cizik;
    }

    public String getDegisim() {
        return degisim;
    }

    public void setDegisim(String degisim) {
        this.degisim = degisim;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
        
    }

    public Arac getArac() {
        return arac;
    }

    public void setArac(Arac arac) {
        this.arac = arac;
    }
  
    
    @Override
    public String toString() {
        return "HasarKaydi{" + "hasarid=" + hasarid + ", boya=" + boya + ", cizik=" + cizik + ", degisim=" + degisim + ", aciklama=" + aciklama + ", arac=" + arac + '}';
    }
    


}


