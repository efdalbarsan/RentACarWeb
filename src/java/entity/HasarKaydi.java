package entity;

import java.util.List;
import java.util.Objects;


public class HasarKaydi {
    private int hasarid;
    private int aracid;
    private String boya;
    private String cizik;
    private String degisim;
    private String aciklama;
    private HasarKaydi hasarKaydi;
    private Long aracid;
    private List<Arac> hasarkaydiArac;

    public HasarKaydi() {
    }

    public HasarKaydi(int hasarid, Long aracid, String boya, String cizik, String degisim, String aciklama, HasarKaydi hasarKaydi, List<Arac> hasarkaydiArac) {
        this.hasarid = hasarid;
        this.aracid = aracid;
        this.boya = boya;
        this.cizik = cizik;
        this.degisim = degisim;
        this.aciklama = aciklama;
        this.hasarKaydi = hasarKaydi;
        this.hasarkaydiArac = hasarkaydiArac;
    }


    public int getHasarid() {
        return hasarid;
    }

    public void setHasarid(int hasarid) {
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
    
    public Long getAracid() {
        return aracid;
    }

    public void setAracid(Long aracid) {
        this.aracid = aracid;
    }

    public HasarKaydi getHasarKaydi() {
        return hasarKaydi;
    }

    public void setHasarKaydi(HasarKaydi hasarKaydi) {
        this.hasarKaydi = hasarKaydi;
    }

    public List<Arac> getHasarkaydiArac() {
        return hasarkaydiArac;
    }

    public void setHasarkaydiArac(List<Arac> hasarkaydiArac) {
        this.hasarkaydiArac = hasarkaydiArac;
    }

    

    @Override
    public String toString() {
        return "HasarKaydi{" + "hasarid=" + hasarid + ", boya=" + boya + ", cizik=" + cizik + ", degisim=" + degisim + ", aciklama=" + aciklama + ", aracid=" + aracid + '}';
    }
    


}


