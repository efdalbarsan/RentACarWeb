package controller;

import dao.GrupDAO;
import dao.KullaniciDAO;
import entity.Grup;
import entity.Kullanici;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class KullaniciController implements Serializable {

    private List<Kullanici> kullaniciList;
    private KullaniciDAO kullaniciDAO;
    private GrupDAO grupDAO;
    private List<Grup> grupList;

    private int page = 1;
    private int pageSize = 5;
    private int pageCount;

    public void next() {
        if (this.page == this.getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public void previous() {
        if (this.page == 1) {
            this.page = this.getPageCount();
        } else {
            this.page--;
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getKullaniciDAO().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public KullaniciController() {
    }

    private Kullanici kullanici;

    public void updateForm(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public void clearForm() {
        this.kullanici = new Kullanici();
    }

    public String index() {
        clearForm();
        return "index";
    }

    public void deleteConfirm(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public void delete() {
        this.getKullaniciDAO().delete(this.kullanici);
        this.kullanici = new Kullanici();
        clearForm();
    }

    public void modify() {
        this.getKullaniciDAO().update(this.kullanici);
        clearForm();
    }

    public void create() {
        System.out.println("-------------------------->" + this.kullanici.toString());

        this.getKullaniciDAO().create(this.kullanici);
        clearForm();
    }

    public void register() {
        System.out.println("-------------------------->" + this.kullanici.toString());
        this.getKullaniciDAO().create(this.kullanici);
        clearForm();
    }

    public Kullanici getKullanici() {
        if (this.kullanici == null) {
            this.kullanici = new Kullanici();
        }
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public List<Kullanici> getKullaniciList() {
        this.kullaniciList = this.getKullaniciDAO().read();
        return kullaniciList;
    }

    public void setKullaniciList(List<Kullanici> kullaniciList) {
        this.kullaniciList = kullaniciList;
    }

    public KullaniciDAO getKullaniciDAO() {
        if (this.kullaniciDAO == null) {
            this.kullaniciDAO = new KullaniciDAO();
        }
        return kullaniciDAO;
    }

    public void setKullaniciDAO(KullaniciDAO kullaniciDAO) {
        this.kullaniciDAO = kullaniciDAO;
    }

    public GrupDAO getGrupDAO() {
        if (this.grupDAO == null) {
            this.grupDAO = new GrupDAO();
        }
        return grupDAO;
    }

    public List<Grup> getGrupList() {
        this.grupList = this.getGrupDAO().read();
        return grupList;
    }

    public void setGrupList(List<Grup> grupList) {
        this.grupList = grupList;
    }
}
